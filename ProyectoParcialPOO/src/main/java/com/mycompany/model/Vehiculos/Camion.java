package com.mycompany.model.Vehiculos;

public class Camion extends Vehiculo{
    private String tipo = "Camion";
    private double capacidad;
    private double ejes;

    public Camion(String marca, String modelo, int year,  String motor, int llantas, double capacidad, double ejes, double precio){
        super(marca, modelo, year, motor, llantas, precio);
        this.capacidad = capacidad;
        this.ejes = ejes;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public double getEjes() {
        return ejes;
    }
    
    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nCapacidad: "+capacidad+"\nEjes: "+ejes;
    }    
}
