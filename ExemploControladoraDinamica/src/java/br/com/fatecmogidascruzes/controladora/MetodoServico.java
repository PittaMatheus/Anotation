package br.com.fatecmogidascruzes.controladora;

import java.lang.reflect.Method;

public class MetodoServico {
 
    private Class classe;
    private Method metodo;

    public MetodoServico() {
    }

    public MetodoServico(Class classe, Method metodo) {
        this.classe = classe;
        this.metodo = metodo;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public Method getMetodo() {
        return metodo;
    }

    public void setMetodo(Method metodo) {
        this.metodo = metodo;
    }
    
    
    
}
