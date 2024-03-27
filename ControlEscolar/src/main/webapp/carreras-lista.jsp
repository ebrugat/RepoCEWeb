<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Carrera Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand"> Carrera Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Carreras</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Carreras</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/crear" class="btn btn-success">Añadir Nueva Carrera</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombres</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="carreras" items="${carreras}">
                                            
						<tr>
							<td><c:out value="${carreras.id}" /></td>
							<td><c:out value="${carreras.nombre}" /></td>
							<td><a href="modificar?id=<c:out value='${carreras.id}'/>">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
                                                            <a href="/ControlEscolar/borrar?id=<c:out value='${carreras.id}'/>">Borrar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>