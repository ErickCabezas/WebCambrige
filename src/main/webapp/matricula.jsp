<%@ page import="entities.Usuario" %>
<%@ page import="com.example.webcambrige.CursoIngles" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.CursosYExamenesServlet" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 15/12/2023
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MATRICULA</title>
    <link rel="stylesheet" href="hojaDeEstilos/stylesmatriculacion.css">
</head>
<body>
<div class="contenedor">
    <h1 id="titulo"><b>EMPIEZA CON TU MATRICULA</b></h1>
    <%
        Usuario user = (Usuario) request.getSession().getAttribute("userMatricula");
    %>
    <p><b>Hola <%=user.getNombre()%>  <%=user.getApellido()%>
    </b></p>
    <p>User: <%= user.getUsuario()%></p>
    <p>Nivel del curso: <%= user.getNivel()%></p>

    <%
        if (user.getNivel()!=0) {
    %>
    <form action="MatriculaServlet" method="POST">
        <p><b>Seleccione el horario al que se quiere matricular</b></p>

        <div class="contenedorBotones">
            <select name="horario">
                <option value="0" selected>.....</option>
                <option value="7-9">7-9</option>
                <option value="9-11">9-11</option>
                <option value="11-13">11-13</option>
                <option value="14-16">14-16</option>
                <option value="16-18">16-18</option>
                <option value="18-20">18-20</option>
            </select>
            <br>
            <button type="submit"> Guardar Inscrición</button>
        </div>
    </form>
    <br>
    <div class="contenedorBotones">
        <form action="MatriculaServlet" method="GET">
            <button type="submit" name="opc" value="2"> regresar</button>
        </form>
        <br>
        <%
            String notificacion = ".....";
            notificacion = (String) request.getSession().getAttribute("noti");
        %>
        <p><%=notificacion%></p>
        <br>
    </div>
    <%}else{%>
    <div class="contenedorBotones">
        <p>Dar la prueba de ubicación</p>
        <form action="MatriculaServlet" method="GET">
            <button type="submit" name="opc" value="1"> Examen de ubicación</button>
        </form>
    </div>
    <%}%>
</div>
</body>
</html>
