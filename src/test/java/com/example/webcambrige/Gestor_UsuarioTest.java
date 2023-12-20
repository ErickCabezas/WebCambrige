package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gestor_UsuarioTest {
    Gestor_Usuario gestor_usuario = null;
    entities.Usuario usuario;

    @Before
    public void setUp() {
        gestor_usuario = new Gestor_Usuario();
        gestor_usuario.agregarUsuario(new entities.Usuario("Erick", "Cabezas", "1751398924", "erick.cabezas@epn.edu.ec",
                "0998369390", "estudiante", 2, "erick", "123"));
    }

    @Test
    public void given_AnUser_when_searchUserAndAddUser_then_ok() {
        String expected = "1751398924";
        assertEquals(expected, gestor_usuario.buscarUsuario("erick", "123").getCedula());
    }




}