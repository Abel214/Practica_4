/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALEJANDRO
 */
public class Auto {
     private Integer id;
    private String modelo; //todoterreno,unifamiliar
    public Auto(Integer id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        
    }
    
    public Auto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

    @Override
    public String toString() {
        return modelo;
    }
    
    
}
