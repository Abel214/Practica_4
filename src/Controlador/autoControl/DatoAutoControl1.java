/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.autoControl;

import Controlador.Listas.DynamicList;
import Controlador.Dao.DaoImplement;
import Controlador.Utiles.Utiles;
import Modelo.Auto;
import Modelo.Tipos;
import java.lang.reflect.Field;
/**
 *
 * @author ALEJANDRO
 */
public class DatoAutoControl1 extends DaoImplement<Tipos> {
      private DynamicList<Tipos> tipos;
    private Tipos tipos1;
     public DatoAutoControl1() {
        super(Tipos.class);
    }

    public DynamicList<Tipos> getTipos() {
        tipos=all();
        return tipos;
    }

    public void setTipos(DynamicList<Tipos> tipos) {
        this.tipos = tipos;
    }

    public Tipos getTipos1() {
        if (tipos1 == null) {
            tipos1 = new Tipos();
        }
        return tipos1;
    }

    public void setTipos1(Tipos tipos1) {
        this.tipos1 = tipos1;
    }




    public Boolean persist(){
        tipos1.setId(all().getLength()+ 1);
        return persist(tipos1);
    }
    public DynamicList<Tipos> ordenarQuickSort(DynamicList<Tipos> lista, Integer tipo, String field) throws Exception {
        Field attribute = Utiles.getField(Tipos.class, field);
        Integer n = lista.getLength();
        Tipos[] tipos = lista.toArray();
        if (attribute != null) {
            quickSort(tipos, tipo, field, 0, tipos.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(tipos);
    }

    private void quickSort(Tipos[] tipos, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Tipos pivote = tipos[(izq + der) / 2];

            while (i <= j) {
                while (tipos[i].compare(pivote, field, tipo) < 0) {
                    i++;
                }

                while (tipos[j].compare(pivote, field, tipo) > 0) {
                    j--;
                }

                if (i <= j) {
                    Tipos temp = tipos[i];
                    tipos[i] = tipos[j];
                    tipos[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(tipos, tipo, field, izq, j);
            quickSort(tipos, tipo, field, i, der);
        }
    }
    public DynamicList<Tipos> busquedaBinaria(String texto, DynamicList<Tipos> tipos, String criterio) {
    DynamicList<Tipos> lista = new DynamicList<>();
    try {
        Tipos [] aux = ordenarQuickSort(tipos, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Tipos  p = aux[medio];
            String valorCriterio = obtenerValorCriterio(p, criterio).toLowerCase();
            if (valorCriterio.contains(texto.toLowerCase())) {
                lista.add(p);
            }
            if (valorCriterio.compareTo(texto.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }
    } catch (Exception e) {
        System.out.println("No existe el valor a comparar");
    }

    return lista;
    }


    private String obtenerValorCriterio(Tipos tipo, String criterio) {
        switch (criterio.toLowerCase()) {
            case "estado_pago":
                return tipo.getEstado_pago();
            case "estado_auto":
                return tipo.getEstado_auto();
            case "vendedor":
                return tipo.getVendedor();
            case "color":
                return tipo.getColor();
            case "marca":
                return tipo.getMarca();
            case "precio":
                return tipo.getPrecio();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    public DynamicList<Tipos> busquedaBinariaLineal(String texto, DynamicList<Tipos> tipos, String criterio) {
        DynamicList<Tipos> lista = new DynamicList<>();
        try {
            Tipos[] aux = ordenarQuickSort(tipos, 0, criterio).toArray();
            int inicio = 0;
            int fin = aux.length - 1;
            while (inicio <= fin) {
                int medio = (inicio + fin) / 2;
                Tipos p = aux[medio];
                String valorCriterio = obtenerValorCriterio(p, criterio).toLowerCase();

                if (valorCriterio.contains(texto.toLowerCase())) {
                    lista.add(p);
                    int i = medio - 1;
                    while (i >= 0 && obtenerValorCriterio(aux[i], criterio).toLowerCase().contains(texto.toLowerCase())) {
                        lista.add(aux[i]);
                        i--;
                    }
                    int j = medio + 1;
                    while (j < aux.length && obtenerValorCriterio(aux[j], criterio).toLowerCase().contains(texto.toLowerCase())) {
                        lista.add(aux[j]);
                        j++;
                    }
                    break;  
                }

                if (valorCriterio.compareTo(texto.toLowerCase()) < 0) {
                    inicio = medio + 1; // El elemento está en la mitad derecha
                } else {
                    fin = medio - 1; // El elemento está en la mitad izquierda
                }
            }
        } catch (Exception e) {
            System.out.println("No existe el valor a comparar");
        }

        return lista; 
    }
}
