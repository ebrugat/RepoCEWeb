<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
    <head>
    <title>Modificar</title>
    <link>
    </head>
    <body>

            <header>
                    <nav>
                            <div>
                                    <a href="<%=request.getContextPath()%>"> Home </a>
                            </div>

                            <ul>
                                    <li><a href="<%=request.getContextPath()%>/listar">Carreras</a></li>
                            </ul>
                    </nav>
            </header>
            <br>
            <div>
                    <div>
                            <div>				
                                <form action="modificar" method="post">
                                    <caption>
                                        <h2>						
                                    Editar Carrera seleccionada
                                            </h2>
                                    </caption>

                                    <fieldset>
                                            <label>Nuevo nombre</label> <input type="text"
                                                    name="nombre" required="required">
                                    </fieldset>
                                    <button type="submit">Guardar</button>
                                    </form>
                            </div>
                    </div>
            </div>
    </body>
</html>