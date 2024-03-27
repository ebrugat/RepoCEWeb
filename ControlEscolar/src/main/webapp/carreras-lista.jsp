<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Carrera Management Application</title>
<link>
</head>
<body>

	<header>
		<nav>
			<div>
				<a href="<%=request.getContextPath()%>/list"> Carrera Management App </a>
			</div>

			<ul>
				<li><a href="<%=request.getContextPath()%>/list"> Carreras</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div>
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

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