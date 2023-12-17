package com.example.webcambrige;

public class Login {
    private String usuario;
    private String contrasenia;

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public boolean validarCredenciales(String usuario, String contrasenia) {
        return this.usuario.equals(usuario) && this.contrasenia.equals(contrasenia);
    }

    public String getUsuario() {
        return usuario;
    }
}
