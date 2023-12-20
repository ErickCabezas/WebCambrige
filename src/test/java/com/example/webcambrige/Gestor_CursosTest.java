package com.example.webcambrige;

import entities.Cursoingles;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Gestor_CursosTest {


    Gestor_Cursos gestor_curso = null;
    entities.Cursoingles cursoingles = null;
    entities.Usuario usuario;

    @Before
    public void setUp() {
        gestor_curso = new Gestor_Cursos();
        cursoingles = new entities.Cursoingles(Date.valueOf("12/8/2023"), Date.valueOf("12/11/2023"), "14-16", 2, 4, 300);
        gestor_curso.agregarCurso(cursoingles);

    }

    @Test
    public void given_ASchedule_when_searchCourse_then_ok() {
        String expected = "14-16";
        assertEquals(expected, gestor_curso.buscarCursoPorHorario("14-16"));
    }


}