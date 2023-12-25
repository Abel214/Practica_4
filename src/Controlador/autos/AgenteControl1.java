/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.autos;

import Controlador.Dao.DaoImplement;
import Controlador.Listas.DynamicList;
import Controlador.Utiles.Utiles;

import Modelo.Vendedor;
import java.lang.reflect.Field;

/**
 *
 * @author ALEJANDRO
 */
public class AgenteControl1 extends DaoImplement<Vendedor>{
     private DynamicList<Vendedor>listR=new DynamicList<>();
     private Vendedor vendedor;
     
     public AgenteControl1(){
         super(Vendedor.class);
     }
    public DynamicList<Vendedor> getVendedores() {
        return listR = all();
    }

    public void setListR(DynamicList<Vendedor> listR) {
        this.listR = listR;
    }

    public Vendedor getVendedor() {
        if(vendedor==null)
            vendedor=new Vendedor();
            return vendedor;
        
        
    }


    public void setVendedor (Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Boolean persit(){
        vendedor.setId(all().getLength()+1);
        
        return persist(vendedor);
    }
    public DynamicList<Vendedor> ordenarQuickSort(DynamicList<Vendedor> lista, Integer tipo, String field) throws Exception {
        Field attribute = Utiles.getField(Vendedor.class, field);
        Integer n = lista.getLength();
        Vendedor[] vendedores = lista.toArray();
        if (attribute != null) {
            quickSort(vendedores, tipo, field, 0, vendedores.length - 1);
        } else {
            throw new Exception("No existe el atributo: " + field);

        }

        return lista.toList(vendedores);
    }

    private void quickSort(Vendedor[] vendedores, Integer tipo, String field, int izq, int der) {
        if (izq < der) {
            int i = izq;
            int j = der;
            Vendedor pivote = vendedores[(izq + der) / 2];

            while (i <= j) {
                while (vendedores[i].compare(pivote, field, tipo) < 0) {
                    i++;
                }

                while (vendedores[j].compare(pivote, field, tipo) > 0) {
                    j--;
                }

                if (i <= j) {
                    Vendedor temp = vendedores[i];
                    vendedores[i] = vendedores[j];
                    vendedores[j] = temp;
                    i++;
                    j--;
                }
            }

            quickSort(vendedores, tipo, field, izq, j);
            quickSort(vendedores, tipo, field, i, der);
        }
    }
    public DynamicList<Vendedor> busquedaBinaria(String texto, DynamicList<Vendedor> vendedores, String criterio) {
    DynamicList<Vendedor> lista = new DynamicList<>();
    try {
        Vendedor [] aux = ordenarQuickSort(vendedores, 0, criterio).toArray();
        int inicio = 0;
        int fin = aux.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Vendedor  p = aux[medio];
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


    private String obtenerValorCriterio(Vendedor vendedor, String criterio) {
        switch (criterio.toLowerCase()) {
            case "apellido":
                return vendedor.getApellido();
            case "nombre":
                return vendedor.getNombre();
            case "cedula":
                return vendedor.getCedula();
            case "numero":
                return vendedor.getNumero();
            case "edad":
                return vendedor.getEdad();
            case "ruc":
                return vendedor.getRuc();
            default:
                throw new IllegalArgumentException("Criterio no válido");
        }
    }
    public DynamicList<Vendedor> busquedaBinariaLineal(String texto, DynamicList<Vendedor> vendedores, String criterio) {
        DynamicList<Vendedor> lista = new DynamicList<>();
        try {
            Vendedor[] aux = ordenarQuickSort(vendedores, 0, criterio).toArray();
            int inicio = 0;
            int fin = aux.length - 1;
            while (inicio <= fin) {
                int medio = (inicio + fin) / 2;
                Vendedor p = aux[medio];
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
