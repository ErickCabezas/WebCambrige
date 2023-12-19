package entities;

import com.example.webcambrige.Gestor_Usuario;
import jakarta.persistence.*;

import java.util.Calendar;

import static entities.Inscripcioncurso.agregarInscripcion;

public class main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date fechaActual = new java.sql.Date(calendar.getTime().getTime());
        Inscripcioncurso inscripcioncurso = new Inscripcioncurso(1,fechaActual, 1, false);
        agregarInscripcion(inscripcioncurso);
    }
}