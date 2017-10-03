/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Operaciones extends HttpServlet {

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
        //variable globales

        PrintWriter out = response.getWriter();
        String tipoConsulta = request.getParameter("envio");

        //parametros capturados
        String usu = request.getParameter("nombreUsuario");
        String pas = request.getParameter("password");

        //Asignacion a la respiesta html que va a generarse
        response.setContentType("text/html");

        out.println("<html>");
        out.println("<head><title>Datos introducidos por Formulario</title></head");
        out.println("<body>");
        out.println("<table border)\"5\">");
        out.println("<tr><td><b>USUARIO:</b></td><td><i>" + usu + "</i></td></tr>");
        out.println("</table><p>");
        out.println("<h1>TU CONSULTA</h1>");

        //para insertar tablas
        if ("MODIFICACIONES".equals(tipoConsulta)) {
            String BASE = request.getParameter("BASE");
            out.println("<form method='post' id='formulario' action='./SeleccionaT.jsp'>");
            out.println("<p>" + BASE + "</p>");
            out.println("<input type='hidden' name='BASE' value='" + BASE + "'>");
            out.println("<p><input type='submit' value='Confirmar Base datos'></p>");
            out.println("</form>");

        } 

        //////fin consulta
        out.println("<br></h1>FIN CONSULTA</h1>");
        out.println("<br><a href='./ElegirOperacion.html'>Volver atrás</a>");
        out.println("</body>");
        out.println("</html>");

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
