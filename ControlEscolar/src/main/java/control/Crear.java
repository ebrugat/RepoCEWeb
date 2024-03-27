package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
 * @author Mati
 */
@WebServlet(name = "crear", urlPatterns = {"/crear"})
public class Crear extends HttpServlet {
    private CarreraDao carreraDao;
    private Carrera car;
    
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
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rp = request.getRequestDispatcher("carrera-form.jsp");
        rp.forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            insertarCarrera(request,response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Crear.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertarCarrera(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ClassNotFoundException{
        String nombre = request.getParameter("nombre");
        Carrera nuevaCarrera = new Carrera(nombre);
        carreraDao.insertData(nuevaCarrera.getNombre());
        response.sendRedirect("list");
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
