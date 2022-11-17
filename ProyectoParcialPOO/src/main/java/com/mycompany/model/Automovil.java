package com.mycompany.model;

public class Automovil extends Vehiculo{

    private int asientos;
    private boolean convertible;
    private boolean camara;

    public Automovil(String ma, String mod, int year,  String mot, int asi, boolean conv, boolean cam, double precio){
        super(ma, mod, year, mot, 4, precio);
        this.asientos = asi;
        this.convertible = conv;
        this.camara = cam;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setMarca(int asi) {
        this.asientos = asi;
    }

    public boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean conv) {
        this.convertible = conv;
    }

    public boolean getCamara() {
        return camara;
    }

    public void setMarca(Boolean cam) {
        this.camara = cam;
    }

    public String toString(){    
        return super.toString() + ", Asientos=" + asientos + ", Convertible=" + convertible + ", Camara trasera=" + camara;    
    }
}
