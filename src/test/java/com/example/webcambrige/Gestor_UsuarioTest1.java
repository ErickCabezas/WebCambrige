package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Gestor_UsuarioTest1 {

    Gestor_Usuario gestor_usuario = null;
    entities.Usuario usuario;


    @Before
    public void setUp() {
        gestor_usuario = new Gestor_Usuario();
    }

    @Test
    public void given_numberCC_when_validate_then_error() {
        assertFalse(gestor_usuario.validarCedulaEcuatoriana("1752823648"));
    }


    @Test
    public void given_AnUser_when_assignCourse_then_ok() {
        assertTrue(gestor_usuario.asignarNivel(gestor_usuario.buscarUsuario("johan", "123").getUsuarioId(), 2));
    }






}