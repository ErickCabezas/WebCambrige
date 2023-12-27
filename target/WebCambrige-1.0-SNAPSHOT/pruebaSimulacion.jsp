<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wseba
  Date: 27/12/2023
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prueba Simulacion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
        }

        fieldset {
            margin-bottom: 20px;
        }

        legend {
            font-weight: bold;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-left: 240px;
        }
    </style>
</head>
<body>

<h2>Examen de Inglés</h2>

<form id="examenForm" action="PruebaSimulacionServlet" method="post">

    <fieldset>
        <legend>Pregunta 1:</legend>
        <label>What ________ your name?</label>
        <input type="radio" name="q1" value="is"> is
        <input type="radio" name="q1" value="am"> am
        <input type="radio" name="q1" value="are"> are
        <input type="radio" name="q1" value="be"> be
        <span id="correctAnswer1" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 2:</legend>
        <label>She hasn't seen her friends ________ last summer.</label>
        <input type="radio" name="q2" value="since"> since
        <input type="radio" name="q2" value="for"> for
        <input type="radio" name="q2" value="during"> during
        <input type="radio" name="q2" value="in"> in
        <span id="correctAnswer2" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 3:</legend>
        <label>I need to buy some ________ for dinner.</label>
        <input type="radio" name="q3" value="meat"> meat
        <input type="radio" name="q3" value="meats"> meats
        <input type="radio" name="q3" value="meeat"> meeat
        <input type="radio" name="q3" value="meets"> meets
        <span id="correctAnswer3" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 4:</legend>
        <label>________ is your name?</label>
        <input type="radio" name="q4" value="How"> How
        <input type="radio" name="q4" value="What"> What
        <input type="radio" name="q4" value="When"> When
        <input type="radio" name="q4" value="Where"> Where
        <span id="correctAnswer4" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 5:</legend>
        <label>My sister and I ________ going to the beach tomorrow.</label>
        <input type="radio" name="q5" value="am"> am
        <input type="radio" name="q5" value="is"> is
        <input type="radio" name="q5" value="are"> are
        <input type="radio" name="q5" value="be"> be
        <span id="correctAnswer5" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 6:</legend>
        <label>I can't find my keys. Have you seen ________?</label>
        <input type="radio" name="q6" value="they"> they
        <input type="radio" name="q6" value="them"> them
        <input type="radio" name="q6" value="those"> those
        <input type="radio" name="q6" value="it"> it
        <span id="correctAnswer6" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 7:</legend>
        <label>This is ________ book.</label>
        <input type="radio" name="q7" value="my"> My
        <input type="radio" name="q7" value="mines"> Mines
        <input type="radio" name="q7" value="me"> Me
        <input type="radio" name="q7" value="I"> I
        <span id="correctAnswer7" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 8:</legend>
        <label>________ are you from?</label>
        <input type="radio" name="q8" value="Who"> Who
        <input type="radio" name="q8" value="Where"> Where
        <input type="radio" name="q8" value="Whose"> Whose
        <input type="radio" name="q8" value="Which"> Which
        <span id="correctAnswer8" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 9:</legend>
        <label>I enjoy listening to music, ________ jazz.</label>
        <input type="radio" name="q9" value="specially"> Specially
        <input type="radio" name="q9" value="especially"> Especially
        <input type="radio" name="q9" value="especial"> Especial
        <input type="radio" name="q9" value="specialy"> Specialy
        <span id="correctAnswer9" class="correct-answer"></span>
    </fieldset>

    <fieldset>
        <legend>Pregunta 10:</legend>
        <label>She speaks French ________.</label>
        <input type="radio" name="q10" value="very good"> Very good
        <input type="radio" name="q10" value="very well"> Very well
        <input type="radio" name="q10" value="very nice"> Very nice
        <input type="radio" name="q10" value="very fine"> Very fine
        <span id="correctAnswer10" class="correct-answer"></span>
    </fieldset>

    <button type="submit">Enviar respuestas</button>


</form>

    <form action="PruebaSimulacionServlet" method="get">
        <button type="submit" value="reintentar" name="opc">Reintentar prueba</button>
    </form>



</body>
</html>
