package br.com.fatecmogidascruzes.eletivaweb.evento;

import br.com.fatecmogidascruzes.eletivaweb.armazenamento.ServicoArmazenamento;

public class ServicoEvento {

    //
    // Caminho com injeção de dependência.
    @Injetar
    private ServicoArmazenamento servicoArmazenamento;
    // @Injetar
    // public ServicoEvento(ServicoArmazenamento servicoArmazenamento) {
    // }
    //
    // Caminho com fábrica:
    // ServicoArmazenamento servicoArmazenamento = FabricaServicoArmazenamento.get();
    //
    
    public void fazAlgo() {
        servicoArmazenamento.armazenar(null);
    }
    
}
