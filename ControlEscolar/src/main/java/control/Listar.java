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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrera;

/**
 *
 * @author Enric
 */
@WebServlet(name = "lista", urlPatterns = {"/"})
public class Listar extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        try {
            listCarrera(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listCarrera(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException{
            ArrayList<Carrera> carreras = carreraDao.readData(car.getTable(), car.getColumna1());
            request.setAttribute("carreras", carreras);
            RequestDispatcher rp = request.getRequestDispatcher("carreras-lista.jsp");
            rp.forward(request,response);
    }
}
