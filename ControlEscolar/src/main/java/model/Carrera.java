/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */

public class Carrera{

    private String nombre;
    int id;
    
    public Carrera(){
    }
    public Carrera (String nombrep){
        this.nombre = nombrep;
    }
    public Carrera(int idp, String nombrep){
        setId(idp);
        setNombre(nombrep);

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
