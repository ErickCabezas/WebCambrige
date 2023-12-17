<%@ page import="com.example.webcambrige.CursoIngles" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.webcambrige.ExamenUbicacion" %><%--
  Created by IntelliJ IDEA.
  User: erick cabezas
  Date: 16/12/2023
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cursos y examenes</title>
    <script>
        function mostrarFormulario(opcion) {
            // Ocultar todos los formularios
            document.getElementById('formAgregarCurso').style.display = 'none';
            document.getElementById('formEliminarCurso').style.display = 'none';
            document.getElementById('formAgregarExamen').style.display = 'none';
            document.getElementById('formEliminarExamen').style.display = 'none';

            // Mostrar el formulario correspondiente a la opción seleccionada
            document.getElementById('form' + opcion).style.display = 'block';
        }
    </script>
</head>
<body>
<div class="Menu">
    <form action="CursosYExamenesServlet" method="GET">
        <button type="button" onclick="mostrarFormulario('AgregarCurso')">Agregar curso</button>
        <button type="button" onclick="mostrarFormulario('EliminarCurso')">Eliminar cursos</button>
        <button type="button" onclick="mostrarFormulario('AgregarExamen')">Agregar examen</button>
        <button type="button" onclick="mostrarFormulario('EliminarExamen')">Eliminar examen</button>
        <button type="submit" name="operacion" value="1">Mostrar Curso</button>
        <button type="submit" name="operacion" value="2">Mostrar examenes</button>
        <button type="submit" name="operacion" value="3">Cuenta</button>
    </form>
</div>
<!-- Formulario para agregar curso -->
<form id="formAgregarCurso" style="display: none;" action="CursosYExamenesServlet" method="POST">
    <h1 >Agregar curso</h1>
    <div class="atributosCurso">
        <p><label>ID:</label><input type="text" name="id"></p>
        <p><label>Fecha inicio:</label><input type="text" name="fecha inicio"></p>
        <p><label>Fecha fin:</label><input type="text" name="Fecha fin"></p>
        <p><label>Horario:</label><input type="text" name="Horario"></p>
        <p><label>Nivel:</label><input type="text" name="Nivel"></p>
        <p><label>Aula:</label><input type="text" name="Aula"></p>
        <p><label>Costo:</label><input type="text" name="Costo"></p>
    </div>
    <button type="submit" name="operacion" value="1">Agregar Curso</button>
</form>

<!-- Formulario para eliminar curso -->
<form id="formEliminarCurso" style="display: none;" action="CursosYExamenesServlet" method="POST">
    <h1>Eliminar curso</h1>
    <div class="idEliminarCurso">
        <p>Ingrese el ID del curso a eliminar</p>
        <p><label>ID:</label><input type="text" name="id"></p>
    </div>
        <button type="submit" name="operacion" value="2">Eliminar Curso</button>
</form>

<!-- Formulario para agregar examen -->
<form id="formAgregarExamen" style="display: none;" action="CursosYExamenesServlet" method="POST">
    <h1>Agregar examen</h1>
    <div class="atributosExamen">
        <p><label>ID:</label><input type="text" name="id"></p>
        <p><label>Horario:</label><input type="text" name="horario"></p>
        <p><label>Fecha examen:</label><input type="text" name="fecha"></p>
    </div>
        <button type="submit" name="operacion" value="3">Agregar examen</button>
</form>

<!-- Formulario para eliminar examen -->
<form id="formEliminarExamen" style="display: none;" action="CursosYExamenesServlet" method="POST">
    <h1>Eliminar examen</h1>
    <div class="idEliminarExamen">
        <p>Ingrese el ID del examen a eliminar</p>
        <p><label>ID:</label><input type="text" name="id"></p>
    </div>
        <button type="submit" name="operacion" value="4">Eliminar examen</button>
</form>
<div class="txtAgregado">
    <%
        String notifica = ".....";
        notifica = (String) request.getSession().getAttribute("notificacion");
        if (notifica != null) {
    %>
    <p id="usuarioEsRegistrado"><%=notifica%></p>
    <%}%>
    <br>
</div>
</body>
</html>
