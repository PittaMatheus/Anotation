package br.com.fatecmogidascruzes.controladora;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class DescobridorClasses {

    /**
     * Descobre as classes que estão dentro de um pacote e de seus subpacotes
     * recursivamente.
     *
     * @param pacote O pacote onde eu quero começar a procurar classes. Ex:
     * br.com.fatemogidascruzes
     * @return
     */
    public List<Class> descobrir(String pacote) throws IOException, ClassNotFoundException {

        ClassLoader carregadorClasses = Thread.currentThread().getContextClassLoader();
        String caminho = pacote.replace(".", "/");
        System.out.println(caminho);
        Enumeration<URL> urls = carregadorClasses.getResources(caminho);
        List<Class> resultado = new ArrayList<>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();

            resultado.addAll(descobrirRecursivo(url.getPath(), pacote));
        }

        return resultado;

    }

    public List<Class> descobrirRecursivo(String caminho, String pacote) throws IOException, ClassNotFoundException {
        File arquivo = new File(caminho);
        List<Class> resultado = new ArrayList<>();
        for (File filho : arquivo.listFiles()) {
            if (filho.isDirectory()) {
                resultado.addAll(descobrirRecursivo(filho.getPath(), pacote + "." + filho.getName()));
            } else if (filho.getName().endsWith(".class")) {
                resultado.add(Class.forName(pacote + "." + filho.getName().substring(0, filho.getName().length() - ".class".length())));
            }
        }
        return resultado;
    }

}
