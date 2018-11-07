package br.com.fatecmogidascruzes.eletivaweb.produto;

import br.com.fatecmogidascruzes.controladora.MapeamentoURL;
import br.com.fatecmogidascruzes.controladora.Prefixo;
import br.com.fatecmogidascruzes.controladora.ServicoWeb;

@ServicoWeb
public class ProdutoServicoWeb {

    @MapeamentoURL(caminho = "/produtos/inserir")
    public String inserir(@Prefixo(valor = "produto") ProdutoDTO produto) {
        // Código para usar a camada de serviço e inserir um produto.
        // servicoProduto.salvar(produtoDTO);
        return null;
    }

    @MapeamentoURL(caminho = "/produtos/excluir")
    public String excluir(@Prefixo(valor = "produto") ProdutoDTO produto) {
        // Código para usar a camada de serviço e inserir um produto.
        // servicoProduto.salvar(produtoDTO);
        return null;
    }
    
}
