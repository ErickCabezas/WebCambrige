<%@ page import="entities.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 15/12/2023
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calificar</title>
    <link rel="stylesheet" href="hojaDeEstilos/stylesCalificar.css">
</head>

<body>
<div class="contenedor">
    <h1 id="titulo">Datos del Estudiante</h1>
    <form action="CalificarServlet" method="POST">


        <p><label>Usuario del estudiante:</label><input type="text" name="usuarioId"></p>

        <p><b>Nivel del estudiante (1-5):</b></p>
        <p><label>Nivel:</label><input type="text" name="calificacion"></p>
        <button type="submit"> Guardar</button>
    </form>
    <br>
    <div class="contenedorBotones">
        <form action="CalificarServlet" method="GET">
            <button type="submit"> Home</button>
        </form>
        <%
            String calificado = ".....";
            calificado = (String) request.getSession().getAttribute("Notificacion");
        %>


        <%
            if (calificado != null) {
        %>
        <p><%=calificado%>
        </p>
        <br>
        <%}%>
    </div>
</div>

</body>
</html>

