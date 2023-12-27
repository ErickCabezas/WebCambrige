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
    <title>Cuenta Cambrige</title>
    <link rel="stylesheet" href="hojaDeEstilos/stylesCuentaUsuario.css">
</head>
<body>

<div class="contenedor">
    <div class="titulo">
        <h1>BIENVENIDO A CAMBRIGE</h1>
    </div>
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
            <p class="label"><b> Nivel :</b><%=usuario.getNivel()%>
            </p>
            <br>
        </div>
    </div>


    <div class="contenedorBotones">

        <%
            if (usuario.getModoUsuario().equals("gerencial")) {
        %>
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="CursoYExamen">Cursos y examenes</button>
            </form>
        </div>
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="registrarUser">Registrar User</button>
            </form>
        </div>
        <%
        } else {
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
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="CursoYExamen">Cursos y examenes</button>
            </form>
        </div>
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="cobrar"> cobrar</button>
            </form>
        </div>
        <div class="sinColumna">
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="registrarEstudiante"> Registrar Estudiante</button>
            </form>
        </div>
        <%} else {%>
        <div class="sinColumna">
            <form action="CuentaServlet" method="POST">
                <button type="submit"> Inscribirse en curso</button>
            </form>

            <%
                if (usuario.getNivel() == 0) {
            %>
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="pruebaSimulacion">Prueba Simulacion</button>
            </form>
            <% } %>
        </div>
        <%}%>
        <%}%>
        <%}%>
        <div class="sinColumna">
            <br>
            <form action="CuentaServlet" method="GET">
                <button type="submit" name="opc" value="cerrar"> cerrar sesión</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>

