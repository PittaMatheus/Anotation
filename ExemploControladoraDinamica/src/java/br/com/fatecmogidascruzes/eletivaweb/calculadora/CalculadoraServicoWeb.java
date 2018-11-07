package br.com.fatecmogidascruzes.eletivaweb.calculadora;

import br.com.fatecmogidascruzes.controladora.MapeamentoURL;
import br.com.fatecmogidascruzes.controladora.Prefixo;
import br.com.fatecmogidascruzes.controladora.ServicoWeb;

@ServicoWeb
public class CalculadoraServicoWeb {

    @MapeamentoURL(caminho = "/somar")
    // operacao.
    public String somar(@Prefixo(valor = "operacao") OperacaoDTO operacao) {
        return String.valueOf(Double.valueOf(operacao.getOperando1()) + Double.valueOf(operacao.getOperando2()));
    }

    @MapeamentoURL(caminho = "/subtrair")
    // operacao.
    public String subtrair(@Prefixo(valor = "operacao") OperacaoDTO operacao) {
        return String.valueOf(Double.valueOf(operacao.getOperando1()) - Double.valueOf(operacao.getOperando2()));
    }
    
}

