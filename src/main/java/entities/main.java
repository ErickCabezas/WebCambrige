package entities;

import com.example.webcambrige.Gestor_Cursos;
import com.example.webcambrige.Gestor_ExamenUbicacion;
import com.example.webcambrige.Gestor_Usuario;
import jakarta.persistence.*;
import servlet.LoginServlet;

import java.util.Calendar;
import java.util.List;

import static entities.Inscripcioncurso.agregarInscripcion;
import static entities.Examenubicacion.agregarExamen;
import static entities.Inscripcioncurso.buscarInscripcionPorUsuario;
import static entities.Inscripcioncurso.agregarCurso;

public class main {


    public static void main(String[] args) {
        boolean b = agregarCurso(1, 1);
        System.out.println(b);
    }
}