package servlet;

//import com.example.webcambrige.Usuario;
import entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="CalificarServlet", urlPatterns = {"/CalificarServlet"})
public class CalificarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        String contrasena = solicitud.getParameter("contrasena");
        double calificacion= Double.parseDouble(solicitud.getParameter("calificacion")) ;
        Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario, contrasena);
        String notificacion="";
        if(usuario!=null){
            //misma linea en distintos if's
            if(LoginServlet.gestor_usuario.asignarNivel(usuario,calificacion)){
                notificacion="Usuario calificado y nivel asignado: "+usuario.getNivel();
            }else {
                notificacion="Ingrese una calificación valida";
            }
        }else{
            notificacion="no existe el estudiante con ese usuario";
        }
        pasarNotificacion(solicitud,notificacion);
        respuesta.sendRedirect("calificar.jsp");
    }
    public void pasarNotificacion(HttpServletRequest solicitud, String notificacion){
        HttpSession miSesion = solicitud.getSession();
        miSesion.setAttribute("Notificacion", notificacion);
    }

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        respuesta.sendRedirect("cuentaUser.jsp");
    }
}
