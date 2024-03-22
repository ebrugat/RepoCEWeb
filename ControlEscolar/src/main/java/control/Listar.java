/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.CarreraDao;
import DAO.DbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrera;

/**
 *
 * @author Mati
 */
@WebServlet(name = "listar", urlPatterns = {"/listar"})
public class Listar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        DbConnect.loadDriver();
        try (Connection con = new DbConnect().getConexion()) {
            Carrera car = new Carrera();
            CarreraDao controlEscolar = new CarreraDao(car, con);  
            ArrayList<Carrera> carreras = controlEscolar.readData(car.getTable(), car.getColumna1(), con);
            request.setAttribute("carreras", carreras);
            request.getRequestDispatcher("./listar.jsp").forward(request, response);
            con.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action != null) {
        if (action.equals("delete")) {
            response.sendRedirect(request.getContextPath() + "/borrar");
        }else if (action.equals("update")) {
            response.sendRedirect(request.getContextPath() + "/modificar");
        }
    }
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}