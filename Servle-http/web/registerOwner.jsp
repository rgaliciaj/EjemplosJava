<%-- 
    Document   : registerOwner
    Created on : 26/02/2021, 12:46:19 PM
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
        <div id="max-space-add" class="card">
            <a href="index.jsp" type="button" class="btn btn-outline-warning">Regresar</a><br>
            <div class="card-body">
                <form method="post" action="ownerServlet" >
                    <div class="form-group">
                      <label for="exampleInputEmail1">Ingrese el nombre de owner</label>
                      <input  name="nameOwner" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" >
                      <input name="actionFormHidden" type="hidden"  value="register">
                      <button type="submit" class="btn btn-success btn-lg btn-block">Agregar</button>
                    </div>
                </form>
            </div>
        </div>
</body>
</html>
