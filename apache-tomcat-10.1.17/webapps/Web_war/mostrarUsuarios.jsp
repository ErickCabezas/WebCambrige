<%@ page import="java.util.List" %>
<%@ page import="com.example.web.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 11/11/2023
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/stylesLista.css"/>
</head>
<body>
    <h1>Lista de usuarios registrados</h1>
    <div class="tm-list">
    <%
        List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
        int cont=1;
        for(Usuario user: listaUsuarios){
    %>
        <div class="tm-list-item">
            <img src="imagenes/user.png" alt="Image" class="tm-list-item-img">
            <div class="tm-black-bg tm-list-item-text">
                <h3 class="tm-list-item-name">Usuario N° <%=cont%><span class="tm-list-item-price">Estudiante</span></h3>
                <p class="tm-list-item-description">Info: <%= user.getLogin().getUsuario()%></p>
                <%cont+=1;%>
            </div>
        </div>
    </div>
    <%}%>
    </div>
</body>
</html>
