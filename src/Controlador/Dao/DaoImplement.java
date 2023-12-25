/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.Listas.DynamicList;

import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ALEJANDRO
 */
public class DaoImplement<T> implements DaoInterface<T>{
    private Class<T> clazz;
    private XStream conection;
    private String URL;

    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection=Bridge.getConection();
        URL= Bridge.URL+clazz.getSimpleName()+".json";
        
    }
    @Override
    public Boolean persist(T data){
        DynamicList<T> Id=all();
        Id.add(data);
        try {
            conection.toXML(Id,new FileWriter(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
        
        
    }
    @Override
    public Boolean merge(T data, Integer index) {
        DynamicList<T> dl = all();
        try {
            dl.getNode(index).setInfo(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            this.conection.toXML(dl, new FileWriter(URL));
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    @Override
    public DynamicList<T> all(){
    DynamicList<T> dl=new DynamicList<>();
    try{
          dl=(DynamicList<T>)conection.fromXML(new FileReader(URL));
    } catch(Exception e){
      
    }
    return dl;
    }
    @Override
    public T get(Integer id){
        throw new UnsupportedOperationException("Not supported yet,");
    }
}
    

