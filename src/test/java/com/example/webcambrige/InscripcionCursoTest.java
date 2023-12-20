package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionCursoTest {

    Gestor_Usuario gestor_usuario = null;
    Usuario usuario = null;
    CursoIngles cursoIngles = null;

    InscripcionCurso inscripcionCurso = null;

    @Before
    public void setUp() {
        gestor_usuario = new Gestor_Usuario();
        cursoIngles = new CursoIngles(1, 180, "12/8/2023", "12/11/2023", "14-16", 4, 300);
        usuario = new Usuario("Juan","Cabezas","1751398924","erick.cabezas@epn.edu.ec","estudiante","0998792990","erick","e123");
        inscripcionCurso = new InscripcionCurso(usuario, "20/12/2023");
    }

    @Test
    public void given_anUser_when_inscribeACurse_then_error() {
        assertFalse(inscripcionCurso.inscribirCurso(cursoIngles));
    }

    @Test
    public void given_anUser_when_inscribeACurse_then_ok() {
        usuario.setNivel(1);
        assertTrue(inscripcionCurso.inscribirCurso(cursoIngles));
    }


}