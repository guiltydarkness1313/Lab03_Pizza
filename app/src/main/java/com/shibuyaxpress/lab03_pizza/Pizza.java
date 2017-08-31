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
        String com=e1.getComplementos();
        int aux=0;
        switch (nom){
            case "Americana":
                aux=0;
                if(com.contains("extra queso")){
                    aux+=8;
                }else{
                    aux+=0;
                }
                if(com.contains("extra jamon")){
                    aux+=12;
                }else {
                    aux+=0;
                }
                aux+=40;
                e1.setPrecio(aux);
                break;
            case "Hawaina":
                aux=0;
                if(com.contains("extra queso")){
                    aux+=8;
                }else{
                    aux+=0;
                }
                if(com.contains("extra jamon")){
                    aux+=12;
                }else {
                    aux+=0;
                }
                aux+=45;
                e1.setPrecio(aux);
                break;
            case "Super Suprema":
                aux=0;
                if(com.contains("extra queso")){
                    aux+=8;
                }else{
                    aux+=0;
                }
                if(com.contains("extra jamon")){
                    aux+=12;
                }else {
                    aux+=0;
                }
                aux+=65;
                e1.setPrecio(aux);
                break;
            case "Meat Lover":
                aux=0;
                if(com.contains("extra queso")){
                    aux+=8;
                }else{
                    aux+=0;
                }
                if(com.contains("extra jamon")){
                    aux+=12;
                }else {
                    aux+=0;
                }
                aux+=60;
                e1.setPrecio(aux);
                break;
        }
    }

}
