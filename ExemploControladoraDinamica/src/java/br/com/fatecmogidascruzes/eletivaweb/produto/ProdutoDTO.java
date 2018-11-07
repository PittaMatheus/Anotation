package br.com.fatecmogidascruzes.eletivaweb.produto;

import java.util.Date;

public class ProdutoDTO {
 
    private String nome;
    private double preco;
    private Date data;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
