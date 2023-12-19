package servlet;

import com.example.webcambrige.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="CobrarServlet", urlPatterns = {"/CobrarServlet"})
public class CobrarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String nombreUsuario= solicitud.getParameter("usuario");
        String monto= solicitud.getParameter("monto");
        String modoPago= solicitud.getParameter("metodoPago");
        //Usuario usuario=LoginServlet.gestor_usuario.buscarUsuario(nombreUsuario);
        String notificacion="";
        /*if(sePuedeCobrar(usuario, monto)){
            //misma linea en distintos if's
            if(modoPago.equalsIgnoreCase("0")){
                notificacion="Seleccione modo de pago";
            }else {
                notificacion = confirmarPago(usuario, modoPago);
            }
        }else{
            notificacion="no existe el estudiante con ese usuario o el monto es incorrecto";
        }*/
        pasarNotificacion(solicitud,notificacion);
        respuesta.sendRedirect("cobrar.jsp");
    }

    public boolean sePuedeCobrar(Usuario usuario, String monto) {
        return usuario != null&& Double.parseDouble(monto)==usuario.getInscripcion().getCurso().getCosto();
    }

    public String confirmarPago(Usuario usuario, String modoPago) {
        String notificacion;
        if(usuario.getInscripcion().pagar(modoPago)){
            notificacion="Pago Guardado";
        }else{
            notificacion="Pago no realizado";
        }
        return notificacion;
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
