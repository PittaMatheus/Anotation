package br.com.fatecmogidascruzes.controladora;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controladora extends HttpServlet {

    private static Map<String, MetodoServico> mapeamentoRequisicoes = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();

        try {
            // Procurar, nas classes do projeto, por aquelas que estejam
            // anotadas com @ServicoWeb. Quando encontrar, procurar por
            // métodos dentro dela que estejam anotados com @MapeamentoURL.
            // Preencher o mapa em função desta informação.
            DescobridorClasses descobridorClasses = new DescobridorClasses();
            List<Class> encontradas = descobridorClasses.descobrir("br.com");
            for (Class classe : encontradas) {
                if (null != classe.getDeclaredAnnotation(ServicoWeb.class)) {
                    for (Method metodo : classe.getDeclaredMethods()) {
                        MapeamentoURL mapeamentoURL = metodo.getDeclaredAnnotation(MapeamentoURL.class);
                        if (null != mapeamentoURL) {
                            String caminho = mapeamentoURL.caminho();
                            if (!caminho.startsWith("/")) {
                                caminho = "/" + caminho;
                            }
                            mapeamentoRequisicoes.put(caminho, new MetodoServico(classe, metodo));
                        }
                    }
                }
            }

            // Exibir resumo dos mapeamentos.
            for (Entry<String, MetodoServico> entradaMapa : mapeamentoRequisicoes.entrySet()) {
                System.out.printf("Mapeamento de %s para %s.%s\n", entradaMapa.getKey(), entradaMapa.getValue().getClasse().getName(), entradaMapa.getValue().getMetodo().getName());
            }
        } catch (IOException | ClassNotFoundException erro) {
            erro.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Descobrir o caminho na URL.
            String urlAcao = request.getRequestURI();
            urlAcao = urlAcao.substring(request.getContextPath().length());

            // Procurar no mapa por esse caminho (chave) e recuperar o objeto de Classe e Method
            // associado (valor).
            MetodoServico metodoServico = mapeamentoRequisicoes.get(urlAcao);
            if (null == metodoServico) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }

            response.getWriter().println(urlAcao);

            // Descobrir quais parametro este metodo recebe.
            Method metodo = metodoServico.getMetodo();
            Object[] valoresParametros = new Object[metodo.getParameters().length];
            int i = 0;
            for (Parameter parametro : metodo.getParameters()) {
                Prefixo prefixo = parametro.getDeclaredAnnotation(Prefixo.class);
                String prefixoParametro = "";
                if (null != prefixo) {
                    prefixoParametro = prefixo.valor() + ".";
                }

                // Para cada parametro, criar um objeto.
                Object objetoParametro = Class.forName(parametro.getType().getName()).newInstance();
                // Para cada objeto, preencher os dados com os dados da requisicao.
                for(Field atributo: objetoParametro.getClass().getDeclaredFields()) {
                    System.out.println("Tentando recuperar da requisição um parâmetro com nome " + prefixoParametro + atributo.getName());
                    if(null != request.getParameter(prefixoParametro + atributo.getName())) {
                        atributo.setAccessible(true);
                        atributo.set(objetoParametro, request.getParameter(prefixoParametro + atributo.getName()));
                    }
                }
                valoresParametros[i++] = objetoParametro;
            }

            // Criar um objeto da classe de servico (que e classe do metodo em questao).
            // Executar o metodo, recuperar a resposta.
            Object servico = metodoServico.getClasse().newInstance();
            String retorno = (String) metodo.invoke(servico, valoresParametros);
            
            response.getWriter().println("O resultado da execução é " + retorno);
            
            // Redirecionar o usuario para o caminho de resposta especificado.
            // Exibir resumo dos mapeamentos.
            for (Entry<String, MetodoServico> entradaMapa : mapeamentoRequisicoes.entrySet()) {
                System.out.printf("Mapeamento de %s para %s.%s\n", entradaMapa.getKey(), entradaMapa.getValue().getClasse().getName(), entradaMapa.getValue().getMetodo().getName());
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
