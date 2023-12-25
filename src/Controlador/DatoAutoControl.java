/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Listas.DynamicList;
import Modelo.Auto;
import Modelo.Tipos;

/**
 *
 * @author ALEJANDRO
 */
public class DatoAutoControl {
    private Tipos tipo;
    private DynamicList<Tipos> tipos;
     public DatoAutoControl() {
        tipo = new Tipos();
        this.tipos = new DynamicList<>();
    }

    public Tipos getTipo() {
       if(tipo==null){
            tipo=new Tipos();
        }
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public DynamicList<Tipos>Tipos() {
        return tipos;
    }

    public void setTipos(DynamicList<Tipos> tipos) {
        this.tipos = tipos;
    }

   
        

    //Mwtodo guardar
    public Boolean guardar(){
        tipo.setId(generarId());
        tipos.add(tipo);
        return true;
    }
    private Integer generarId(){
        return tipos.getLength()+1;
  }
    
   
    
     public void imprimir(){
        System.out.println(tipos.toString());
    }

    @Override
    public String toString() {
        return "DatoCasaControl{" + "tipo=" + tipo + ", tipos=" + tipos + '}';
    }
     
}
