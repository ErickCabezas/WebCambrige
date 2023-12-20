<%@ page import="entities.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRO DE USUARIOS</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/stylesRegistro.css"/>
</head>
<body>
<div id="cuadro">
    <h1 id="titulo">Datos de registro</h1>
    <form action="RegistroServlet" method="POST">
        <div class="nombreUsuario"><p><label>Nombre:</label><input type="text" name="nombre"></p>
            <p><label>Apellido:</label><input type="text" name="apellido"></p>
            <p><label>Cedula:</label><input type="text" name="cedula"></p>
            <p><label>Correo:</label><input type="text" name="correo"></p>
            <p><label>Telefono:</label><input type="text" name="telf"></p>
            <p><label>Usuario:</label><input type="text" name="user"></p>
            <p><label>Contraseña:</label><input type="text" name="contrasenia"></p>
        </div>
        <div class="contenedorRadioButton">
            <p><label>Tipo de usuario:</label></p>
            <div class="grupoRadioButton">
                <input type="radio" name="tipoUser" id="estudiante" value="estudiante"/>Estudiante
            </div>
            <div class="grupoRadioButton">
                <input type="radio" name="tipoUser" value="profesor"/>Profesor<br>
            </div>
            <div class="grupoRadioButton">
                <input type="radio" name="tipoUser" value="administrativo"/>Administrativo<br>
            </div>
        </div>
        <div class="btnRegistrarse">
            <button type="submit"> Registrarse</button>
        </div>
    </form>
    <br>
    <form action="RegistroServlet" method="GET">
        <div class="btnRegresarLogin">
            <button type="submit"> Regresar</button>
        </div>
    </form>
    <div class="txtAgregado">
        <%
            String agregado = ".....";
            if((Usuario)request.getSession().getAttribute("registro") != null){
                Usuario usuario = (Usuario)request.getSession().getAttribute("registro");
                agregado = usuario.getUsuario();
            }
        %>


        <%
            if (agregado != null) {
        %>
        <p id="usuarioEsRegistrado"><%=agregado%></p>
        <%}%>

        <br>

    </div>
</div>

<h1>Ver lista de usuarios</h1>
<form action="RegistroServlet" method="GET">
    <button type="submit" name="mostrar" value="mostrar"> Mostrar usuarios</button>
</form>
</body>
</html>
