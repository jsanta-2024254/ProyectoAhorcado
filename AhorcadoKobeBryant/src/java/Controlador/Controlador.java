package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Palabra;
import modelo.PalabraDAO;

@WebServlet("/ControladorPalabra")
public class Controlador extends HttpServlet {

    private PalabraDAO palabraDAO = new PalabraDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Palabra> listaPalabras = palabraDAO.listarPalabras();

        System.out.println("Servlet: palabras obtenidas = " + listaPalabras.size());

        if (listaPalabras != null && !listaPalabras.isEmpty()) {
            request.setAttribute("listaPalabras", listaPalabras);
            request.getRequestDispatcher("ahorcadoKobe.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "No hay palabras disponibles en la base de datos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Controlador para cargar las palabras del juego AhorcadoKobe";
    }
}
