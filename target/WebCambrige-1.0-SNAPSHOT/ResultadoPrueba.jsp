<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wseba
  Date: 27/12/2023
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultados Prueba</title>
    <link rel="stylesheet" type="text/css" href="hojaDeEstilos/resultadosPrueba.css">
</head>
<body>

<div class="container">
    <h2>Resultado del Examen</h2>

    <div id="resultado">
        <h3>Resultados:</h3>
        <p>Nota: <%=request.getSession().getAttribute("respuestasCorrectasCount") %> de 100</p>
        <div id="respuestas">
            <%
                List<String> respuestasCorrectas = entities.PruebaSimulacion.obtenerRespuestasCorrectas();
                List<String> respuestasUsuario = (List<String>) request.getSession().getAttribute("respuestasCorrectas");
                List<String> enunciados = entities.PruebaSimulacion.obtenerEnunciados();
                for (int i = 0; i < respuestasCorrectas.size(); i++) {

            %>
            <p><b>Pregunta: <%=enunciados.get(i) %> </b><p>
            <p>
                Tu respuesta: <span><%=respuestasUsuario.get(i) %></span> |
                Respuesta correcta: <span><%=respuestasCorrectas.get(i) %></span>
            </p>
            <% } %>
        </div>
    </div>
</div>

</body>
</html>
