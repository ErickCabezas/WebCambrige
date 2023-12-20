<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%@ page import="com.example.web.Login" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/styles.css"/>

</head>
<body>

<div id="cuadro">

    <form action="LoginServlet" method="POST">
        <h1 id="titulo">INICIAR SESIÓN</h1>
        <br>
        <div class="nombreUsuario">
            <label id="subtitulo1">NOMBRE DE USUARIO</label>
            <br><br>
            <input type="text" class="entrada" name="user"/>
            <br><br>
            <br>
            <div class="Contraseña">
                <label id="subtitulo2">CONTRASEÑA</label>
                <br><br>
                <input type="password" class="entrada" name="contrasenia"/>
                <br><br>
            </div>

        </div>


        <input type="submit" value="Iniciar sesión" id="boton"/>

    </form>

    <form action="LoginServlet" method="GET">
        <br>
        <div class="btnRegistro">
            <button type="submit"> Registrarse</button>
        </div>

    </form>

    <br>
</div>
</body>
</html>