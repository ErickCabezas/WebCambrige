<%@ page import="com.example.webcambrige.CursoIngles" %>
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
    <title>Cursos</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/stylesLista.css"/>
</head>
<body>
<h1>Lista de cursos registrados</h1>
<div class="contenedorBotones">
    <form action="CursosYExamenesServlet" method="GET">
        <button type="submit" name="operacion" value="4"> Regresar</button>
    </form>
</div>
<div id="Cursos">
    <%
        List<CursoIngles> cursos = (List) request.getSession().getAttribute("listaCursos");
        int cont=1;
        for(CursoIngles curso: cursos){
    %>
    <div class="tm-list-item">
        <div class="tm-black-bg tm-list-item-text">
            <h3 class="tm-list-item-name">curso N° <%=cont%></h3>
            <p class="tm-list-item-description">Info: <%=curso.toString()%></p>
            <%cont+=1;%>
        </div>
    </div>
</div>
<%}%>

</body>
</html>
