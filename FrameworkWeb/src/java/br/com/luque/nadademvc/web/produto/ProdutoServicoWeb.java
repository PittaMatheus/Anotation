package br.com.luque.nadademvc.web.produto;

import br.com.luque.nadademvc.web.servicoweb.MetodoHTTP;
import br.com.luque.nadademvc.web.servicoweb.ParametroRequisicao;
import br.com.luque.nadademvc.web.servicoweb.RecursoWeb;
import br.com.luque.nadademvc.web.servicoweb.ResultadoRequisicao;
import br.com.luque.nadademvc.web.servicoweb.ServicoWeb;

/**
 * Esta classe implementa um serviço web de produtos.
 *
 * @author Leandro Luque
 */
@ServicoWeb(caminhoBase = "/produtos")
public class ProdutoServicoWeb {

    private ProdutoServico produtoServico = new ProdutoServico();

    @RecursoWeb(recurso = "/editar", metodo = MetodoHTTP.GET)
    public ResultadoRequisicao consultarProduto(@ParametroRequisicao(nome = "id") long id) {
        throw new UnsupportedOperationException("Você deve retirar isso após implementar");
    }

    @RecursoWeb(metodo = MetodoHTTP.GET)
    public ResultadoRequisicao consultarProdutos() {
        throw new UnsupportedOperationException("Você deve retirar isso após implementar");
    }

    @RecursoWeb(metodo = MetodoHTTP.POST)
    public ResultadoRequisicao inserir(@ParametroRequisicao(nome = "produto") ProdutoVM produto) {
        throw new UnsupportedOperationException("Você deve retirar isso após implementar");
    }

    @RecursoWeb(recurso = "/testar", metodo = MetodoHTTP.GET)
    public ResultadoRequisicao testar(@ParametroRequisicao(nome = "produto") ProdutoVM produto) {
        ResultadoRequisicao resultadoRequisicao = new ResultadoRequisicao();
        resultadoRequisicao.setCaminhoRelativoRecursoRetorno("/exibirResultadoTeste.jsp");
        resultadoRequisicao.addDado("produto", produto);
        return resultadoRequisicao;
    }
}
