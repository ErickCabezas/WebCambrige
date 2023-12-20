package servlet;

import com.example.webcambrige.ExamenUbicacion;
import com.example.webcambrige.Gestor_Cursos;
import com.example.webcambrige.Gestor_ExamenUbicacion;
import com.example.webcambrige.Gestor_Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class CursosYExamenesServletTest {

    Gestor_ExamenUbicacion gestor_examenUbicacion = null;
    entities.Examenubicacion examen = null;

    @Before
    public void setUp() {
        gestor_examenUbicacion = new Gestor_ExamenUbicacion();
    }


    @Test
    public void given_ASchedule_when_searchCourse_then_ok() {
        String expected = "14-16";
        assertEquals(expected, gestor_examenUbicacion.buscarExamenporHorario("14-16").getHorario());
    }


}