<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Categoria</title>
    </head>
    <body>
        <h1>Teste Categoria</h1>
        <form action="${pageContext.request.contextPath}/do/categorias/testar">
            <label for="nome">Nome:</label><input type="text" name="categoria.nome" />
            <label for="descricao">Descrição:</label><input type="text" name="categoria.descricao" />
            <input type="submit" name="enviar" value =" Enviar " />
        </form>
    </body>
</html>
