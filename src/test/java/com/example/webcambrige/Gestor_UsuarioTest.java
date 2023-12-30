package com.example.webcambrige;

import entities.ConexionBD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Gestor_UsuarioTest {
    Gestor_Usuario gestor_usuario = new Gestor_Usuario();

    @Test
    public void given_AnUser_when_searchUser_then_ok() {
        String expected = "1751398924";
        assertEquals(expected, gestor_usuario.buscarUsuario("erick", "123").getCedula());
    }
}
