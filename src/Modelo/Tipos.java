/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author ALEJANDRO
 */
public class Tipos  {
    private Auto Id_auto;
    private String estado_pago;
    private String estado_auto;
    private Integer Id;
    private String vendedor;
    private String color;
    private String marca;
    private String precio;
    

    public Tipos() {
        this.Id_auto = null;
        this.estado_pago = null;
        this.estado_auto = null;
        this.Id = null;
        this.vendedor = null;
        this.precio=null;
        this.color=null;
        this.marca=null;
    }

    public Tipos(Auto Id_auto, String estado_pago, String estado_auto, Integer Id, String vendedor, String color, String marca, String precio) {
        this.Id_auto = Id_auto;
        this.estado_pago = estado_pago;
        this.estado_auto = estado_auto;
        this.Id = Id;
        this.vendedor = vendedor;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
    }

    public Auto getId_auto() {
        return Id_auto;
    }

    public void setId_auto(Auto Id_auto) {
        this.Id_auto = Id_auto;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public String getEstado_auto() {
        return estado_auto;
    }

    public void setEstado_auto(String estado_auto) {
        this.estado_auto = estado_auto;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tipos{" + "Id_auto=" + Id_auto + ", estado_pago=" + estado_pago + ", estado_auto=" + estado_auto + ", Id=" + Id + ", vendedor=" + vendedor + ", color=" + color + ", marca=" + marca + ", precio=" + precio + '}';
    }
    public Integer compare(Tipos p, String field, Integer type) {
        // 0 menor, 1 mayor
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("estado_pago")) {
                    return estado_pago.compareTo(p.getEstado_pago());
                } else if (field.equalsIgnoreCase("estado_auto")) {
                    return estado_auto.compareTo(p.getEstado_auto());
                } else if (field.equalsIgnoreCase("vendedor")) {
                    return vendedor.compareTo(p.getVendedor());
                } else if (field.equalsIgnoreCase("color")) {
                    return color.compareTo(p.getColor());
                } else if (field.equalsIgnoreCase("marca")) {
                    return marca.compareTo(p.getMarca());
                } else if (field.equalsIgnoreCase("precio")) {
                    return precio.compareTo(p.getPrecio());
                } else if (field.equalsIgnoreCase("Id")) {
                    return Id.compareTo(p.getId());
                }
            case 1:
                if (field.equalsIgnoreCase("estado_pago")) {
                    return p.getEstado_pago().compareTo(estado_pago);
                } else if (field.equalsIgnoreCase("estado_auto")) {
                    return p.getEstado_auto().compareTo(estado_auto);
                } else if (field.equalsIgnoreCase("vendedor")) {
                    return p.getVendedor().compareTo(vendedor);
                } else if (field.equalsIgnoreCase("color")) {
                    return p.getColor().compareTo(color);
                } else if (field.equalsIgnoreCase("marca")) {
                    return p.getMarca().compareTo(marca);
                } else if (field.equalsIgnoreCase("precio")) {
                    return p.getPrecio().compareTo(precio);
                } else if (field.equalsIgnoreCase("Id")) {
                    return p.getId().compareTo(Id);
                }
            default:
                throw new AssertionError();
        }
    }
   

   
    
    
    

    
    
}
