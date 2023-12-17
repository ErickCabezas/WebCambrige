package servlet;

import com.example.webcambrige.CursoIngles;
import com.example.webcambrige.ExamenUbicacion;
import com.example.webcambrige.InscripcionCurso;
import com.example.webcambrige.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="ExamenServlet", urlPatterns = {"/ExamenServlet"})
public class ExamenServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        Usuario usuario=LoginServlet.usuario;
        String horario = solicitud.getParameter("horario");
        ExamenUbicacion examen= CursosYExamenesServlet.examenesUbicacion.examenConHorario(horario);
        usuario.setInscripcion(new InscripcionCurso(usuario,String.valueOf(LocalDate.now())));
        String textoNotificacion="";

        if(examen==null) {
            textoNotificacion="seleccione otro horario";
            respuesta.sendRedirect("examen.jsp");
        }else{
            usuario.getInscripcion().setExamenUbicacion(examen);
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
