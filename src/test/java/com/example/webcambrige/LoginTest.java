package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    Login login = null;

    @Before
    public void setUp() {
        login = new Login("Julian","SO2023@B");

    }

    @Test
    public void given_when_then_error(){
        assertFalse(login.validarCredenciales("Julian","SO2023B"));
    }



}