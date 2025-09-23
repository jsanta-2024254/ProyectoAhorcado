package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Useer;
import modelo.UsuarioDAO;

@WebServlet("/Validacion")
public class Validar extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los datos del formulario
        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password"); 

        Useer useer = usuarioDAO.validar(user_name, user_password);

        if (useer != null) {
            // Usuario válido → guardamos en sesión
            HttpSession sesion = request.getSession();
            sesion.setAttribute("user_name", useer);

            // Redirigir al JSP del juego
            response.sendRedirect("ControladorPalabra");
        } else {
            // Usuario inválido → mensaje de error
            request.setAttribute("mensajeError", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet de validación para el login de AhorcadoKobe";
    }
}
