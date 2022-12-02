package com.mycompany.model.Vehiculos;

public class Tractor extends Vehiculo{

    private String tipo = "Tractor";
    private boolean agricola;
    private Transmision transmision;
    
    public Tractor(String marca, String modelo, int year, boolean agricola, Transmision transmision, double precio){
        super(marca, modelo, year, Motor.Diesel, 4, precio);
        this.agricola = agricola;
        this.transmision = transmision;
    }

    public boolean getAgricola() {
        return agricola;
    }
    
    public Transmision getTransmision() {
        return transmision;
    }    

    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nAgricola: "+agricola+"\nTransmision: "+transmision;
    }

    public String toString(){
        return "Tipo: "+tipo+", "+super.toString()+", Agricola: "+agricola+", Transmision: "+transmision+", Precio: "+getPrecio();
    }
}
