package servlet;


import com.example.webcambrige.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name="RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int opcion=Integer.parseInt(req.getParameter("opcRegistro"));
        switch (opcion){
            case 1:
                HttpSession misesion = req.getSession();
                misesion.setAttribute("listaUsuarios", LoginServlet.gestor_usuario.getUsuarios());
                resp.sendRedirect("mostrarUsuarios.jsp");
                break;
            case 2:
                resp.sendRedirect("cuentaUser.jsp");
                break;
            case 3:
                resp.sendRedirect("registro.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession misesion = solicitud.getSession();
        misesion.setAttribute("registro", RegistrarUsuario(solicitud));
        respuesta.sendRedirect("registro.jsp");
    }

    public String RegistrarUsuario(HttpServletRequest solicitud) {

        String nombre = solicitud.getParameter("nombre");
        String apellido = solicitud.getParameter("apellido");
        String cedula = solicitud.getParameter("cedula");
        String correo = solicitud.getParameter("correo");
        String modo = solicitud.getParameter("tipoUser");
        String telefono = solicitud.getParameter("telf");
        String usuario = solicitud.getParameter("user");
        String contrasenia = solicitud.getParameter("contrasenia");

        return LoginServlet.gestor_usuario.agregarUsuario(
                new Usuario(nombre, apellido, cedula, correo, modo, telefono, usuario, contrasenia));
    }
}
