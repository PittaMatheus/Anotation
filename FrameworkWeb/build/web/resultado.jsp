<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da Operação</title>
    </head>
    <body>
        <h1>Resultado da Operação</h1>
        <%= request.getAttribute("resultado")%>
    </body>
</html>
