<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Carrera" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Carreras</title>
</head>
<body>
    <h1>Listado de Carreras</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
        </tr>
        <% 
            ArrayList<Carrera> carreras = (ArrayList<Carrera>) request.getAttribute("carreras");
            if (carreras != null) {
                for (Carrera carrera : carreras) {
        %>
        <tr>
            <td><%= carrera.getId() %></td>
            <td><%= carrera.getNombre() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">No hay carreras disponibles</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
