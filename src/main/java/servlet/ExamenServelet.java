package servlet;

//import com.example.webcambrige.CursoIngles;
//import com.example.webcambrige.ExamenUbicacion;
//import com.example.webcambrige.InscripcionCurso;
//import com.example.webcambrige.Usuario;
import com.example.webcambrige.Gestor_ExamenUbicacion;
import entities.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Calendar;

import static entities.Inscripcioncurso.agregarInscripcion;

@WebServlet(name="ExamenServlet", urlPatterns = {"/ExamenServlet"})
public class ExamenServelet extends HttpServlet {

    Gestor_ExamenUbicacion gestorExamenUbicacion = new Gestor_ExamenUbicacion();
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        Usuario usuario = LoginServlet.usuario;
        String horario = solicitud.getParameter("horario");
        Examenubicacion examen= gestorExamenUbicacion.buscarExamenporHorario(horario);
        Calendar calendar = Calendar.getInstance();
        java.sql.Date fechaActual = new java.sql.Date(calendar.getTime().getTime());

        String textoNotificacion="";

        if(examen==null) {
            textoNotificacion="seleccione otro horario";
            respuesta.sendRedirect("examen.jsp");
        }else{
            Inscripcioncurso inscripcioncurso = new Inscripcioncurso(usuario.getUsuarioId(), usuario, fechaActual, examen.getId(), examen, false);
            //usuario.getInscripcion().setExamenUbicacion(examen);
            agregarInscripcion(inscripcioncurso);
            textoNotificacion="Guardado "+examen.toString();
            respuesta.sendRedirect("examen.jsp");
        }
        pasarNotificacion(solicitud,textoNotificacion);
    }
    public void pasarNotificacion(HttpServletRequest solicitud, String notificacion){
        HttpSession miSesion = solicitud.getSession();
        miSesion.setAttribute("noti", notificacion);
    }
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}