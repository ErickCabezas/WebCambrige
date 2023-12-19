package servlet;

import com.example.webcambrige.Gestor_Cursos;
import com.example.webcambrige.Gestor_ExamenUbicacion;
import entities.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name="CursosYExamenesServlet", urlPatterns = {"/CursosYExamenesServlet"})
public class CursosYExamenesServlet extends HttpServlet {
    private Gestor_Cursos cursos = new Gestor_Cursos();
    public Gestor_ExamenUbicacion examenesUbicacion= new Gestor_ExamenUbicacion();
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        int opcion = Integer.parseInt(solicitud.getParameter("operacion"));
        HttpSession misesion = solicitud.getSession();
        switch (opcion){
            case 1:
                misesion.setAttribute("listaCursos", cursos.getCursos());
                respuesta.sendRedirect("cursos.jsp");
                break;
            case 2:
                misesion.setAttribute("listaExamenes", examenesUbicacion.getExamenes());
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
                try {
                    misesion.setAttribute("notificacion", AgregarCurso(solicitud));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 2:
                int idcurso = Integer.parseInt(solicitud.getParameter("id"));
                //misesion.setAttribute("notificacion",CursosYExamenesServlet.cursos.eliminarCurso(idcurso));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 3:
                try {
                    misesion.setAttribute("notificacion",AgregarExamen(solicitud));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
            case 4:
                int idexamen = Integer.parseInt(solicitud.getParameter("id"));
                misesion.setAttribute("notificacion", examenesUbicacion.eliminarExamen(idexamen));
                respuesta.sendRedirect("cursosYexamenes.jsp");
                break;
        }
    }
    public Cursoingles AgregarCurso(HttpServletRequest solicitud) throws ParseException {
        String fechaInicioStr = solicitud.getParameter("fecha inicio");
        String fechaFinStr = solicitud.getParameter("fecha fin");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");


        java.util.Date utilInicio = formatoFecha.parse(fechaInicioStr);
        java.util.Date utilFin = formatoFecha.parse(fechaFinStr);
        java.sql.Date fechaInicio = new java.sql.Date(utilInicio.getTime());
        java.sql.Date fechaFin = new java.sql.Date(utilFin.getTime());

        int id = Integer.parseInt(solicitud.getParameter("id"));

        String horario = solicitud.getParameter("Horario");
        int nivel= Integer.parseInt(solicitud.getParameter("Nivel"));
        int aula= Integer.parseInt(solicitud.getParameter("Aula"));
        double costo= Double.parseDouble(solicitud.getParameter("Costo"));

        Cursoingles cursoingles = new Cursoingles(fechaInicio, fechaFin, horario, nivel, aula, costo);
        cursos.agregarCurso(cursoingles);
        return cursoingles;
    }
    public Examenubicacion AgregarExamen(HttpServletRequest solicitud) throws ParseException {
        String horario = solicitud.getParameter("horario");
        String fechaExamenStr= solicitud.getParameter("fecha");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilFecha = formatoFecha.parse(fechaExamenStr);
        java.sql.Date fechaExamen = new java.sql.Date(utilFecha.getTime());

        Examenubicacion examenubicacion = new Examenubicacion(horario, fechaExamen);
        examenesUbicacion.agregarExamen(examenubicacion);

        return examenubicacion;
    }

}
