/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Useer;
import modelo.UsuarioDAO;
/**
 *
 * @author Joshua
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
        private UsuarioDAO usuarioDAO = new UsuarioDAO();


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
