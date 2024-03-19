<%-- 
    Document   : crearcarrera
    Created on : 18 mar 2024, 9:57:58
    Author     : Mati
--%>

<%@page contentType = "text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="./Crear" method="post"> 
            <input type="text" name="nombre"/>
            <input type="submit" value="Crear"/>
        </form>
    </body>
</html>
