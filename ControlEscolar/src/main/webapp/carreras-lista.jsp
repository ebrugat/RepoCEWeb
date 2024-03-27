<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Carrera" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Carrera Management Application</title>
</head>
<body>
    <header>
        <nav>
            <div>
                <a href="<%=request.getContextPath()%>/list">Carrera Management App</a>
            </div>
            <ul>
                <li><a href="<%=request.getContextPath()%>/list">Carreras</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div>
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
