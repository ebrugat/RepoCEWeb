/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.CarreraDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Carrera;

/**
 *
 * @author Enric
 */
@WebServlet(name = "borrar", urlPatterns = {"/borrar"})
public class Borrar extends HttpServlet {
    private CarreraDao carreraDao;
    private Carrera car;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Carrera getCar() {
        return car;
    }

    public void setCar(Carrera car) {
        this.car = car;
    }
    
    public CarreraDao getCarreraDao() {
        return carreraDao;
    }

    public void setCarreraDao(CarreraDao carreraDao) {
        this.carreraDao = carreraDao;
    }
    @Override
    public void init(){
        this.carreraDao = new CarreraDao();
        this.car = new Carrera();
        this.id = 0;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String identifier = request.getParameter("id");
        setId(Integer.parseInt(identifier));
        RequestDispatcher rp = request.getRequestDispatcher("deletemenu.jsp");
        rp.forward(request,response);
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
        String action = request.getParameter("submit");
            if(action.equals("Confirmar")){
                borrarCarrera(request,response);
            }
            else{
                response.sendRedirect("list");
            }
    }
    public void borrarCarrera (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        CarreraDao.deleteData(car.getTable(), id);
        response.sendRedirect("list");
       }catch (ClassNotFoundException ex) {
        Logger.getLogger(Borrar.class.getName()).log(Level.SEVERE, null, ex);
     }
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