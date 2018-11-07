package br.com.fatecmogidascruzes.eletivaweb.armazenamento;

import java.io.File;

//@Injetavel(ambiente = "dev")
public class ServicoArmazenamentoLocal implements ServicoArmazenamento {

    @Override
    public void armazenar(File arquivo) {
        // Código para armazenar localmente.
        
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Executando servico de armazenamento local");
    }
    
}
