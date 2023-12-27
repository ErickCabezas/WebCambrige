package entities;

import java.util.Arrays;
import java.util.List;

public class PruebaSimulacion {
    private static final String[] respuestasCorrectas = {"is", "since", "meat", "What", "are", "them", "my", "Where", "specially", "very well"};
    private static final String[] enunciados = {"What ___ your name?", "She hasn't seen her friends ___ last summer", "I need to buy some ___ for dinner", "___ is your name?", "My sisteer and I ___ going to the beach tomorrow", "I can't fing my keys. Have you seen ___?", "This is ___ my book", "___ are you from?", "I enjoy listening to music, ___ jazz", "She speaks French ___"};

    public static int verificarRespuestas(String[] respuestasUsuario) {
        int nota = 0;

        for (int i = 0; i < respuestasCorrectas.length && i < respuestasUsuario.length; i++) {
            if (respuestasUsuario[i] != null && respuestasUsuario[i].equals(respuestasCorrectas[i])) {
                nota += 10;
            }
        }

        return nota;
    }

    public static List<String> obtenerRespuestasCorrectas() {
        return Arrays.asList(respuestasCorrectas);
    }

    public static List<String> obtenerEnunciados(){
        return Arrays.asList(enunciados);
    }
}
