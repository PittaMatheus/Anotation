package br.com.fatecmogidascruzes.eletivaweb.armazenamento;

public class FabricaServicoArmazenamento {
    
    public ServicoArmazenamento get() {
    
        String variavelAmbiente = System.getenv("ambiente");
        if("dev".equalsIgnoreCase(variavelAmbiente)) {
            return new ServicoArmazenamentoLocal();
        } else if("prod".equalsIgnoreCase(variavelAmbiente)) {
            return new ServicoArmazenamentoS3();
        } else {
            throw new IllegalArgumentException("Não pude identificar o ambiente em questão");
        }
    }
    
}
