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

public class main {


    public static void main(String[] args) {
        Gestor_ExamenUbicacion gestorExamenUbicacion = new Gestor_ExamenUbicacion();
        List<Examenubicacion> lista = gestorExamenUbicacion.listarExamenes();
        for(Examenubicacion examen: gestorExamenUbicacion.listarExamenes()) {
            examen.toString();
        }
    }
}