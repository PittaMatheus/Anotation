package br.com.luque.nadademvc.web.produto;

import br.com.luque.nadademvc.web.servicoweb.MetodoHTTP;
import br.com.luque.nadademvc.web.servicoweb.ParametroRequisicao;
import br.com.luque.nadademvc.web.servicoweb.RecursoWeb;
import br.com.luque.nadademvc.web.servicoweb.ResultadoRequisicao;
import br.com.luque.nadademvc.web.servicoweb.ServicoWeb;

/**
 * Esta classe implementa um serviço web de categorias.
 *
 * @author Leandro Luque
 */
@ServicoWeb(caminhoBase = "/categorias")
public class CategoriaServicoWeb {

    
    
    @RecursoWeb(recurso = "/testar", metodo = MetodoHTTP.GET)
    public ResultadoRequisicao testar(@ParametroRequisicao(nome = "categoria") Categoria categoria) {
        ResultadoRequisicao resultadoRequisicao = new ResultadoRequisicao();
        resultadoRequisicao.setCaminhoRelativoRecursoRetorno("/categoriaInserida.jsp");
        resultadoRequisicao.addDado("categoria", categoria);
        return resultadoRequisicao;
    }
}
