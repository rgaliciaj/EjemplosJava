<%-- 
    Document   : index
    Created on : 25/02/2021, 11:02:12 PM
    Author     : Ronald Galicia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>---Owner---</h2>
        <form method="post" action="ownerServlet" >
            <label for="fname">1. Registrar un owner</label><br>
            <label for="fname">2. Listar todos los owners</label><br>
            <label for="fname">3. Actualizar los owners</label><br>
            <label for="fname">4. Eliminar un owner</label><br>
            <label for="fname">Elija su opcion</label><br>
            <input type="text" id="fname" name="optionOwner"><br>
            <button type="submit" class="btn btn-primary btn-lg btn-block">Enviar</button>
        </form>
        <h2>---Car---</h2>
        <form method="post" action="" >
            <label for="fname">1. Registrar un car</label><br>
            <label for="fname">2. Listar todos los cars</label><br>
            <label for="fname">3. Actualizar los cars</label><br>
            <label for="fname">4. Eliminar un car</label><br>
            <label for="fname">Elija su opcion</label><br>
            <input type="text" id="fname" name="nameowner"><br>
            <button type="submit" class="btn btn-primary btn-lg btn-block">Enviar</button>
        </form>
    </body>
</html>
