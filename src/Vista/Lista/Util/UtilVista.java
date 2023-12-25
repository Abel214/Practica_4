/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Lista.Util;

import Modelo.Auto;
import Modelo.Tipos;
import javax.swing.JComboBox;


/**
 *
 * @author ALEJANDRO
 */
public class UtilVista {
    public static void CargarComboRolesL(JComboBox cbx)throws Exception{
        Controlador.AutoControl rc= new Controlador.AutoControl();
        cbx.removeAllItems();
         for (int i = 0; i < rc.getTipo().getLength(); i++) {
            cbx.addItem(rc.getTipo().getInfo(i));
        }
    }
    
    public static Auto ObtenerCasaControladorL(JComboBox cbx){
        return (Auto)cbx.getSelectedItem();
    }
    
}
