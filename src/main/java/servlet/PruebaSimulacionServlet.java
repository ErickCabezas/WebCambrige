package servlet;

import java.io.IOException;
import java.util.Arrays;

import entities.PruebaSimulacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PruebaSimulacionServlet")
public class PruebaSimulacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener respuestas del formulario
        String[] respuestasUsuario = new String[10];
        for (int i = 0; i < 10; i++) {
            respuestasUsuario[i] = request.getParameter("q" + (i + 1));
        }

        // Verificar respuestas utilizando la clase de utilidad
        int respuestasCorrectasCount = PruebaSimulacion.verificarRespuestas(respuestasUsuario);

        // Guardar respuestas correctas en la sesión
        request.getSession().setAttribute("respuestasCorrectas", Arrays.asList(respuestasUsuario));


        // Guardar la nota en la sesión
        request.getSession().setAttribute("respuestasCorrectasCount", respuestasCorrectasCount);

        // Redirigir a la pantalla del formulario
        request.getRequestDispatcher("ResultadoPrueba.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcion = req.getParameter("opc");

        if (opcion.equalsIgnoreCase("reintentar")) {
            resp.sendRedirect("pruebaSimulacion.jsp");
        }
    }
}
