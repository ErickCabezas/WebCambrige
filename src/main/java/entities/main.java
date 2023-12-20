package entities;

import com.example.webcambrige.Gestor_Cursos;
import com.example.webcambrige.Gestor_ExamenUbicacion;
import com.example.webcambrige.Gestor_Usuario;
import jakarta.persistence.*;
import servlet.LoginServlet;

import java.util.Calendar;

import static entities.Inscripcioncurso.agregarInscripcion;
import static entities.Examenubicacion.agregarExamen;
import static entities.Inscripcioncurso.buscarInscripcionPorUsuario;

public class main {


    public static void main(String[] args) {
        Inscripcioncurso inscripcioncurso = buscarInscripcionPorUsuario(2);
        inscripcioncurso.toString();
    }
}