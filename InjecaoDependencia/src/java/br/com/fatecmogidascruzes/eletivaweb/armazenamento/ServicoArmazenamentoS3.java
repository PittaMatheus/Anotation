package br.com.fatecmogidascruzes.eletivaweb.armazenamento;

import java.io.File;

//@Injetavel(ambiente = "prod")
public class ServicoArmazenamentoS3 implements ServicoArmazenamento {

    @Override
    public void armazenar(File arquivo) {
        // Código para armazenar no S3.
        
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Executando servico de armazenamento S3");
    }
    
}
