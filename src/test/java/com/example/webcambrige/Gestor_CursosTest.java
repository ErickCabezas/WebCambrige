package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gestor_CursosTest {


    Gestor_Cursos gestor_curso = null;

    @Before
    public void setUp() {
        gestor_curso = new Gestor_Cursos();

    }

    @Test
    public void given_ASchedule_when_searchCourse_then_ok() {
        String expected = "7-9";
        assertEquals(expected, gestor_curso.buscarCursoPorHorario("7-9").getHorarioCurso());
    }


}