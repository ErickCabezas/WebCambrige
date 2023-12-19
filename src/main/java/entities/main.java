package entities;

import com.example.webcambrige.Gestor_Usuario;
import jakarta.persistence.*;

public class main {
    public static void main(String[] args) {
        Gestor_Usuario gestorUsuario = new Gestor_Usuario();
        Usuario usuario = gestorUsuario.buscarUsuario("sebastian", "123");
        usuario.toString();
    }
}