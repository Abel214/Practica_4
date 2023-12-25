/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.autos;


import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Modelo.Auto;
import Modelo.Tipos;


/**
 *
 * @author ALEJANDRO
 */
public class AutoControl1 extends DaoImplement<Auto>{
     private DynamicList<Auto>listR=new DynamicList<>();
     private Auto auto;
     
     public AutoControl1(){
         super(Auto.class);
     }
    public DynamicList<Auto> getListR() {
        listR=all();
        return listR;
    }

    public void setListR(DynamicList<Auto> listR) {
        this.listR = listR;
    }

    public Auto getAuto() {
        if(auto==null)
            auto=new Auto();
            return auto;
        
        
    }


    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public Boolean persit(){
        auto.setId(all().getLength()+1);
        
        return persist(auto);
    }
//    public static void main(String[]args){
//        CasaControl1 rc=new CasaControl1();
//        System.out.println(rc.all());
//        rc.getCasa().setDescripcion("Vivienda independiente");
//        rc.getCasa().setNombre_casa("Casa unifamiliar");
//        rc.persit();
//        rc.setCasa(null);
//        
//        rc.getCasa().setDescripcion("Comparten paredes laterales");
//        rc.getCasa().setNombre_casa("Casa adosada");
//        rc.persit();
//        rc.setCasa(null);
//        rc.getCasa().setDescripcion("Dos viviendas separadas");
//        rc.getCasa().setNombre_casa("Doplex");
//        rc.persit();
//        rc.setCasa(null);
//        rc.getCasa().setDescripcion("Tres viviendas separadas");
//        rc.getCasa().setNombre_casa("Triplex");
//        rc.persit();
//        rc.setCasa(null);
//         
//    }
}
