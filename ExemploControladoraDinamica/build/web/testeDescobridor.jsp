<%@page import="br.com.fatecmogidascruzes.controladora.ServicoWeb"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatecmogidascruzes.controladora.DescobridorClasses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste do Descobridor de Classes</title>
    </head>
    <body>
        <h1>Teste do Descobridor de Classes</h1>
        <p>Classes que possuem a anotação ServicoWeb</p>
        <%
        
            DescobridorClasses descobridorClasses = new DescobridorClasses();
            List<Class> encontradas = descobridorClasses.descobrir("br.com");
            for(Class classe : encontradas) {
                if(null != classe.getDeclaredAnnotation(ServicoWeb.class)) {
                    out.println(classe.getName());
                    out.println("<br />");
                }
            }
            
        %>
    </body>
</html>
