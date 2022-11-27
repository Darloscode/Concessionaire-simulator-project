package com.mycompany.model.Vehiculos;

public class Automovil extends Vehiculo{

    private String tipo = "Automovil";
    private int asientos;
    private boolean convertible;
    private boolean camara;

    public Automovil(String marca, String modelo, int year,  Motor mtr, int asientos, boolean conv, boolean cam, double precio){
        super(marca, modelo, year, mtr, 4, precio);
        this.asientos = asientos;
        this.convertible = conv;
        this.camara = cam;
    }

    public int getAsientos() {
        return asientos;
    }    

    public boolean getConvertible() {
        return convertible;
    }    

    public boolean getCamara() {
        return camara;
    }

    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nAsiento: "+asientos+"\nConvertible: "+convertible+"\nCamara: "+camara;
    }
    
    public String toString(){
        return "Tipo: "+tipo+", "+super.toString()+", Asientos: "+asientos+", Convertible: "+convertible+", Camara: "+camara+", Precio: "+getPrecio();
    }
}

