package com.shibuyaxpress.lab03_pizza;

/**
 * Created by paulf on 28-Aug-17.
 */

public class Pizza {
    private String nombre;
    private int precio;
    private String complementos;
//poner 10 segundos y despues enviar notificación de envio

    public Pizza() {
    }

    public String getComplementos() {
        return complementos;
    }

    public void setComplementos(String complementos) {
        this.complementos = complementos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void obtenerPrecio(Pizza e1){
        String nom=e1.getNombre();
        switch (nom){
            case "Americana":
                e1.setPrecio(40);
                break;
            case "Hawaina":
                e1.setPrecio(45);
                break;
            case "Super Suprema":
                e1.setPrecio(65);
                break;
            case "Meat Lover":
                e1.setPrecio(60);
                break;
        }
    }

}
