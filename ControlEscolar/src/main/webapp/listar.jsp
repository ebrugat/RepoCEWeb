<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Carrera" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="./css/style.css"/>
        <title>Lista</title>
    </head>
    <body>
        <header>
            <nav>
                <div>
                    <a href="<%=request.getContextPath()%>">Home</a>
                </div>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/listar">Carreras</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="centrar">
            <div>
                <h3>Lista de Carreras</h3>
                <hr>
                <div>
                    <a href="<%=request.getContextPath()%>/crear">Añadir Nueva Carrera</a>
                </div>
                <br>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            ArrayList<Carrera> carreras = (ArrayList<Carrera>) request.getAttribute("carreras");
                            if (carreras != null) {
                                for (Carrera carrera : carreras) {
                        %>
                                <tr>
                                    <td><%= carrera.getId() %></td>
                                    <td><%= carrera.getNombre() %></td>
                                    <td>
                                        <a href="/ControlEscolar/modificar?id=<%= carrera.getId() %>">Editar</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp; 
                                        <a href="/ControlEscolar/borrar?id=<%= carrera.getId() %>">Borrar</a>
                                    </td>
                                </tr>
                        <% 
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
