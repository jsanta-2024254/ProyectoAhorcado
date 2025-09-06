package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Palabra;
import modelo.PalabraDAO;

@WebServlet("/ControladorPalabra")
public class Controlador extends HttpServlet {

    private PalabraDAO palabraDAO = new PalabraDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Obtener todas las palabras desde el DAO
        List<Palabra> listaPalabras = palabraDAO.listarPalabras();

        if (listaPalabras != null && !listaPalabras.isEmpty()) {
            // Guardamos en sesión
            HttpSession sesion = request.getSession();
            sesion.setAttribute("listaPalabras", listaPalabras);

            // Redirigimos al JSP del juego
            response.sendRedirect("ahorcadoKobe.jsp");

        } else {
            // Si no hay palabras, mandamos mensaje de error
            request.setAttribute("mensajeError", "No hay palabras disponibles en la base de datos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Controlador para cargar las palabras del juego AhorcadoKobe";
    }
}
