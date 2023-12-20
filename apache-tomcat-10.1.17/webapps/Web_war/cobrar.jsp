<%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 21:50
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
    <h1 id="titulo">Datos del Estudiante:</h1>
    <form action="CobrarServlet" method="POST">
        <p><label>Usuario del estudiante:</label><input type="text" name="usuario"></p>
        <p><label>Monto:</label><input type="text" name="monto"></p>
        <p><b>Seleccione el metodo de pago:</b></p>
        <div class="contenedorBotones">
            <select name="metodoPago">
                <option value="0" selected>.....</option>
                <option value="efectivo">efectivo</option>
                <option value="tarjeta">tarjeta</option>
            </select>
            <button type="submit"> Guardar</button>
        </div>
    </form>
    <br>
    <div class="contenedorBotones">
        <form action="CobrarServlet" method="GET">
            <button type="submit"> Home</button>
        </form>
        <%
            String cobrado = ".....";
            cobrado = (String) request.getSession().getAttribute("Notificacion");
        %>

        <%
            if (cobrado != null) {
        %>
        <p><%=cobrado%></p>
        <br>
        <%}%>
    </div>
</div>

</body>
</html>
