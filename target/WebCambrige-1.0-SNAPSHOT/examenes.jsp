<%@ page import="entities.Examenubicacion" %>
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
<div id="cuadro">
    <div id="cabeza">
        <h1>Lista de examenes registrados</h1>
        <form action="CursosYExamenesServlet" method="GET">
            <button type="submit" name="operacion" value="4"> Regresar</button>
        </form>
    </div>
<div id="Cursos">
    <%
        List<Examenubicacion> examenes = (List) request.getSession().getAttribute("listaExamenes");
        int cont=1;
        for(Examenubicacion examen: examenes){
    %>
    <div class="tm-list-item">
        <div class="tm-black-bg tm-list-item-text">
            <h3 class="tm-list-item-name">examen N° <%=cont%></h3>
            <p class="tm-list-item-description">Info: <%=examen.toString()%></p>
            <%cont+=1;%>
        </div>
    </div>
<%}%>
</div>
</div>
</body>
</html>
