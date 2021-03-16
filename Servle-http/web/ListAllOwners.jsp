<%-- 
    Document   : ListAllOwners
    Created on : 1/03/2021, 06:04:58 PM
    Author     : Ronald Galicia
--%>

<%@page import="java.util.Iterator"%>
<%@page import="models.Owner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ownerDao" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input name="actionLIstHidden" type="hidden"  value="showOwners">
        
         <table class="table">
            <thead>
                <tr>
                    <th scope="col">IdOwner</th>
                    <th scope="col">Nombre</th>
                </tr>
            </thead>
            <tbody>

                <%
                    ownerDao oDao = new ownerDao(); 
                    List<Owner> ownList = ;
                    Iterator<Student> iteradorStudent = sList.iterator();
                    Student s = new Student();
                    while (iteradorStudent.hasNext()) {
                        s = iteradorStudent.next();
                %>

                <tr>
                    <td><%= s.getCarnet() %> </td>
                    <td><%= s.getNombre() %> </td>
                    <td><%= s.getfNacimiento() %> </td>
                    <td><%= s.getfRegistro() %> </td>
                    <td> 
                        <a 
                            type="button" 
                            class="btn btn-danger"
                            href="StudentController?accion=delete&idStudent=<%= s.getIdStudent() %> "
                            > Eliminar </a>
                    </td>

                </tr>
            <br>    


            <%
                }
            %>

            </tbody>
        </table>
    </body>
</html>
