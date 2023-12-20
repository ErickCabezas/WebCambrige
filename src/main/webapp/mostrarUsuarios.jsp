<%@ page import="com.example.webcambrige.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 16/12/2023
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/stylesLista.css"/>
</head>
<body>
<div id="cuadro">
    <div id="cabeza">
        <h1>Lista de usuarios registrados</h1>
        <form action="RegistroServlet" method="GET">
            <button type="submit" name="opcRegistro" value="3"> Registro</button>
        </form>
    </div>
<div class="Lista">
    <%
        List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
        int cont=1;
        for(Usuario user: listaUsuarios){
    %>
    <div class="tm-list-item">
        <img src="imagenes/user.png" alt="Image" class="tm-list-item-img">
        <div class="tm-black-bg tm-list-item-text">
            <h3 class="tm-list-item-name">Usuario N° <%=cont%><span class="tm-list-item-price"><%= user.getModoUsuario()%></span></h3>
            <p class="tm-list-item-description">Info: <%= user.getLogin().getUsuario()%></p>
            <%cont+=1;%>
        </div>
    </div>
<%}%>
</div>
</div>
</body>
</html>
