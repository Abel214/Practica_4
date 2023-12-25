/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Listas.DynamicList;
import Modelo.Auto;


/**
 *
 * @author ALEJANDRO
 */
public class AutoControl {
     private DynamicList<Auto>autos;
  
    public AutoControl(){
        autos=new DynamicList<>();
        autos.add(new Auto(1,"Unifamiliar"));
        autos.add(new Auto(2,"Utilitario"));
        autos.add(new Auto(3,"Berlina"));
        autos.add(new Auto(4, "Coupe"));
        autos.add(new Auto(5,"Electrico"));
        autos.add(new Auto(6, "Ecologico"));
        autos.add(new Auto(7, "Todoterreno"));
       
        
    }

    public DynamicList<Auto> getTipo() {
        return autos;
    }

    public void setCasas(DynamicList<Auto> autos) {
        this.autos = autos;
    }

    

    
}
