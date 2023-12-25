/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.autoControl;

import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Modelo.Vendedor;

/**
 *
 * @author ALEJANDRO
 */
public class ControlAgenteVendedor extends DaoImplement<Vendedor> {
      private DynamicList<Vendedor> vendedor;
    private Vendedor vendedor1;
     public ControlAgenteVendedor() {
         super(Vendedor.class);
    }

    public DynamicList<Vendedor> getVendedor() {
        vendedor=all();
        return vendedor;
    }

    public void setVendedor(DynamicList<Vendedor> vendedor) {
        this.vendedor= vendedor;
    }

    public Vendedor getVendedor1() {
        if (vendedor1 == null) {
            vendedor1 = new Vendedor();
        }
        return vendedor1;
    }

    public void setVendedor1(Vendedor vendedor1) {
        this.vendedor1 = vendedor1;
    }




    public Boolean persist(){
        vendedor1.setId(all().getLength()+ 1);
        return persist(vendedor1);
    }
}
