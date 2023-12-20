package entities;

import com.example.webcambrige.Gestor_ExamenUbicacion;
import com.example.webcambrige.Gestor_Usuario;
import jakarta.persistence.*;

import java.util.Calendar;

import static entities.Inscripcioncurso.agregarInscripcion;
import static entities.Examenubicacion.agregarExamen;

public class main {


    public static void main(String[] args) {
        Gestor_Usuario gestorUsuario = new Gestor_Usuario();
        gestorUsuario.buscarUsuario("sebas", "123");
    }
}