<%@ page import="com.example.web.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cuenta Cambrige</title>
    <br>
    <link rel="stylesheet" href="hojaDeEstilos/stylesCuentaUsuario.css">
</head>
<body>


<div class="contenedor">
    <h1>BIENVENIDO A CAMBRIGE</h1>
    <%
        Usuario usuario = (Usuario) request.getSession().getAttribute("loginUser");
    %>
    <div class="containerPrincipal">
        <div class="columna izquierda">
            <p class="label"><b> Modo :</b><%=usuario.getModoUsuario()%>
            </p>
            <br>
            <p class="label"><b> ci :</b><%=usuario.getCedula()%>
            </p>
            <br>
            <p class="label"><b> correo :</b><%=usuario.getCorreo()%>
            </p>
            <br>
        </div>
        <div class="columna derecha">
            <p class="label"><b> Nombre completo:</b>
                <%=usuario.getNombre()%> <%=usuario.getApellido()%>
            </p>
            <br>
            <p class="label"><b> telefono :</b><%=usuario.getTelefono()%>
            </p>
            <br>
            <p class="label"><b> Nivel :</b><%=usuario.getInscripcion().nivel%>
            </p>
            <br>
        </div>
    </div>


    <div class="contenedorBotones">


        <%
            if (usuario.getModoUsuario().equals("profesor")) {
        %>
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="calificar"> calificar</button>
            </form>
        </div>
        <%
        } else {
            if (usuario.getModoUsuario().equals("administrativo")) {
        %>
        <div class="cobrar">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="cobrar"> cobrar</button>
            </form>
        </div>
        <%} else {%>
        <div class="IncribirseEnCurso">
            <form action="CuentaServlet" method="POST">
                <button type="submit"> Inscribirse en curso</button>
            </form>
        </div>
        <%}%>
        <%}%>
        <div class="CerrarSesion">
            <br>
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="cerrar"> cerrar sesión</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
