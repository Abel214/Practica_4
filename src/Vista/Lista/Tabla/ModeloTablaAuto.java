/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Lista.Tabla;

import Controlador.Listas.DynamicList;
import Modelo.Auto;
import Modelo.Tipos;
import Vista.Vendedor;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ALEJANDRO
 */
public class ModeloTablaAuto extends AbstractTableModel  {
     private DynamicList<Tipos> tipos;

    public DynamicList<Tipos> getTipos() {
        return tipos;
    }

    public void setTipos(DynamicList<Tipos> tipos) {
        this.tipos = tipos;
    }
     public ModeloTablaAuto() {
        this.tipos=new DynamicList<>();
    }
    @Override
    public int getRowCount(){
        return tipos.getLength();
        
    }
    @Override
    public int getColumnCount() {
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return 7;
    }
    @Override
    public String getValueAt(int i,int i1){
        // i=fila 1=columna
        try {
            Tipos p = tipos.getInfo(i);
            
        switch(i1){
            case 0: return (p !=null) ? p.getMarca():" ";   //modelos ternarios
            case 1: return (p !=null) ? p.getId_auto().getModelo():" ";
            case 2: return (p !=null) ? p.getColor():" ";
            case 3: return (p !=null) ? p.getEstado_auto():" ";
            case 4: return (p !=null) ? p.getEstado_pago():" ";
            case 5: return (p !=null) ? p.getPrecio():" ";
            case 6: return (p !=null) ? p.getVendedor():" ";
            default:
                return null;
        }
         } catch (Exception e) {
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Marca";
                 case 1:
                return "Modelo";
                case 2:
                return "Color";
                case 3:
                    return "Estado";
                case 4:
                    return "Estado pago";
                 case 5:
                    return "Precio";
                case 6:
                    return "Vendedor";
           
            default:
                return null;

        }
    }
    
    
}
