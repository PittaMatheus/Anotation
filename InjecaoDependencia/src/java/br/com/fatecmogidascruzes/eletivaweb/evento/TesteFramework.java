package br.com.fatecmogidascruzes.eletivaweb.evento;

public class TesteFramework {

    public void testar() {
        
        FrameworkID frameworkID = new FrameworkId();
        ServicoEvento servicoEvento = (ServicoEvento) frameworkId.get(ServicoEvento.class);
        servicoEvento.fazAlgo();
        
    }
    
}
