package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CuentaServlet", urlPatterns = {"/CuentaServlet"})
public class CuentaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String opcion=solicitud.getParameter("opc");
        HttpSession miSesion = solicitud.getSession();
        if(opcion.equalsIgnoreCase("registrarUser")||
                opcion.equalsIgnoreCase("registrarEstudiante")){
            miSesion.setAttribute("LoginUser",LoginServlet.usuario );
            respuesta.sendRedirect("registro.jsp");
        }
        if(opcion.equalsIgnoreCase("cobrar")){
            respuesta.sendRedirect("cobrar.jsp");
        }
        if(opcion.equalsIgnoreCase("cerrar")){
            respuesta.sendRedirect("index.jsp");
        }
        if(opcion.equalsIgnoreCase("calificar")){
            respuesta.sendRedirect("calificar.jsp");
        }
        if(opcion.equalsIgnoreCase("CursoYExamen")){
            respuesta.sendRedirect("cursosYexamenes.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession miSesion= solicitud.getSession();
        miSesion.setAttribute("userMatricula",LoginServlet.usuario );
        respuesta.sendRedirect("matricula.jsp");
    }
}

