package servlet;

import com.example.webcambrige.CursoIngles;
import com.example.webcambrige.InscripcionCurso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

import com.example.webcambrige.Usuario;

@WebServlet(name="MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        int opcion=Integer.parseInt(solicitud.getParameter("opc"));
        HttpSession miSesion = solicitud.getSession();
        switch (opcion){
            case 1:
                miSesion.setAttribute("userMatricula", LoginServlet.usuario);
                respuesta.sendRedirect("examen.jsp");
                break;
            case 2:
                respuesta.sendRedirect("cuentaUser.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession miSesion= solicitud.getSession();
        Usuario usuario=LoginServlet.usuario;
        String horario = solicitud.getParameter("horario");
        CursoIngles curso =CursosYExamenesServlet.cursos.CursosConHorario(horario, usuario.getNivel());
        usuario.setInscripcion(new InscripcionCurso(usuario,String.valueOf(LocalDate.now())));
        String textoNotificacion="";
        if(horario.equalsIgnoreCase("0") || curso==null){
            textoNotificacion="No hay cursos disponibles en ese horario seleccione otro";
        }else{
            if(usuario.getInscripcion().inscribirCurso(curso)){
                textoNotificacion = confirmacionInscripcion(usuario);
            }else{
                textoNotificacion="Error al inscribir en el curso";
            }
        }
        miSesion.setAttribute("noti", textoNotificacion);
        respuesta.sendRedirect("matricula.jsp");
    }

    public String confirmacionInscripcion(Usuario usuario) {
      String textoNotificacion;
      textoNotificacion= usuario.getNombre()+" "+
              usuario.getApellido()
                +"\nRealice el pago del curso"
                +"\nen las oficinas de CAMBRIGE "
                +"\npara finalizar su inscripción"
                +"\ncosto: $"+usuario.getInscripcion().getCurso().getCosto();
        return textoNotificacion;
    }

}
