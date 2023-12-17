<%@ page import="com.example.webcambrige.ExamenUbicacion" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 16/12/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Examenes</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/stylesLista.css"/>
</head>
<body>
<h1>Lista de examenes registrados</h1>
<div class="contenedorBotones">
    <form action="CursosYExamenesServlet" method="GET">
        <button type="submit" name="operacion" value="4"> Regresar</button>
    </form>
</div>
<div id="Examenes">
    <%
        List<ExamenUbicacion> examenes = (List) request.getSession().getAttribute("listaExamenes");
        int cont=1;
        for(ExamenUbicacion examen: examenes){
    %>
    <div class="tm-list-item">
        <div class="tm-black-bg tm-list-item-text">
            <h3 class="tm-list-item-name">examen N° <%=cont%></h3>
            <p class="tm-list-item-description">Info: <%= examen.toString()%></p>
            <%cont+=1;%>
        </div>
    </div>
</div>
<%}%>

</body>
</html>
