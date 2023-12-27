package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PruebaSimulacionTest {

    private String[] respuestas = {"are", "since", "meat", "What", "is", "them", "my", "Where", "specially", "very well"};

    @Test
    public void given_respuestasUsuario_when_seEnvian_then_OK() {
        int expected = 80;
        assertEquals(expected, PruebaSimulacion.verificarRespuestas(respuestas));
    }
}