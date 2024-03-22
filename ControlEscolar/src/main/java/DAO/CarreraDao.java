/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Carrera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Mati
 */
public class CarreraDao {
    
    private Carrera car;
    private Connection conexion;

    public CarreraDao(){}
    public CarreraDao(Carrera car, Connection conexion) {
        setCar(car);
        setConexion(conexion);
    }


    public void insertData(Connection con, String table, String columna, String inputCarrera) {
        try {
            String SQLQuery = "INSERT INTO " + table + " (" + columna + ") VALUES (?)";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setString(1, inputCarrera);
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public ArrayList<Carrera> readData(String table, String columna, Connection con) {
        ArrayList<Carrera> carreras = new ArrayList<>();
        try {
            String SQLQuery = "SELECT * FROM " + table;
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString(columna);
                Carrera carrera = new Carrera(id, nombre);
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return carreras;
    }


    public static void deleteData(String table, int id, Connection con){
        try {
            String SQLQuery = "DELETE FROM " + table + " WHERE id = ?";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
                pt.setInt(1, id);
                pt.executeUpdate();
                System.out.println("Se ha eliminado la fila correctamente");
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(String table, String columna, String nombreAntiguo, String nombreNuevo, Connection con) {
        try {
            String query = "UPDATE " + table + " SET " + columna + " = ? WHERE " + columna + " LIKE ?"; 
            try (PreparedStatement pt = con.prepareStatement(query)) {
                pt.setString(1, nombreNuevo);
                pt.setString(2, nombreAntiguo);
                pt.executeUpdate();
                System.out.println("Datos actualizados correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando los datos: " + e.getMessage());
        }
    }
  
    public Carrera getCar() {
        return car;
    }

    public void setCar(Carrera car) {
        this.car = car;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
