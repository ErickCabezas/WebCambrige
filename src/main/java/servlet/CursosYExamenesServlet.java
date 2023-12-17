package servlet;

import com.example.webcambrige.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="CursosYExamenesServlet", urlPatterns = {"/CursosYExamenesServlet"})
public class CursosYExamenesServlet extends HttpServlet {
    public static Gestor_Cursos cursos=new Gestor_Cursos();
    public static Gestor_ExamenUbicacion examenesUbicacion= new Gestor_ExamenUbicacion();
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        int opcion=Integer.parseInt(solicitud.getParameter("operacion"));
        HttpSession misesion = solicitud.getSession();
        switch (opcion){
            case 1:
                misesion.setAttribute("listaCursos",CursosYExamenesServlet.cursos.getCursos());
                respuesta.sendRedirect("cursos.jsp");
                break;
            case 2:
                misesion.setAttribute("listaExamenes",CursosYExamenesServlet.examenesUbicacion.getExamenes());
                respuesta.sendRedirect("examenes.jsp");
                break;
            case 3:
                respuesta.sendRedirect("cuentaUser.jsp");
                break;
            case 4:
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        int opcion=Integer.parseInt(solicitud.getParameter("operacion"));
        HttpSession misesion = solicitud.getSession();

        switch (opcion){
            case 1:
                misesion.setAttribute("notificacion", AgregarCurso(solicitud));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 2:
                int idcurso = Integer.parseInt(solicitud.getParameter("id"));
                misesion.setAttribute("notificacion",CursosYExamenesServlet.cursos.eliminarCurso(idcurso));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 3:
                misesion.setAttribute("notificacion",AgregarExamen(solicitud));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 4:
                int idexamen = Integer.parseInt(solicitud.getParameter("id"));
                misesion.setAttribute("notificacion",CursosYExamenesServlet.examenesUbicacion.eliminarExamen(idexamen));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
        }
    }
    public String AgregarCurso(HttpServletRequest solicitud) {
        int id = Integer.parseInt(solicitud.getParameter("id"));
        String fechaInicio = solicitud.getParameter("fecha inicio");
        String fechaFin = solicitud.getParameter("Fecha fin");
        String horario = solicitud.getParameter("Horario");
        int nivel= Integer.parseInt(solicitud.getParameter("Nivel"));
        int aula= Integer.parseInt(solicitud.getParameter("Aula"));
        double costo= Double.parseDouble(solicitud.getParameter("Costo"));

        return CursosYExamenesServlet.cursos.agregarCurso(new CursoIngles( id, aula, fechaInicio, fechaFin, horario, nivel, costo));
    }
    public String AgregarExamen(HttpServletRequest solicitud) {
        int id = Integer.parseInt(solicitud.getParameter("id"));
        String horario = solicitud.getParameter("horario");
        String fechaExamen= solicitud.getParameter("fecha");

        return CursosYExamenesServlet.examenesUbicacion.agregarExamen(new ExamenUbicacion( id,fechaExamen,horario));
    }

}
