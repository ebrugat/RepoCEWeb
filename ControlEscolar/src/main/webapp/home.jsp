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
    </body>
</html>