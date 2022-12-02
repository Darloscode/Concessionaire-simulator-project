package com.mycompany.model.Vehiculos;

public class Camion extends Vehiculo{
    private String tipo = "Camion";
    private double capacidad;
    private double ejes;

    public Camion(String marca, String modelo, int year,  Motor mtr, int llantas, double capacidad, double precio){
        super(marca, modelo, year, mtr, llantas, precio);
        this.capacidad = capacidad;        
    }
    
    public double getCapacidad() {
        return capacidad;
    }

    public double getEjes() {
        return capacidad/2;
    }
    
    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nCapacidad: "+capacidad+"\nEjes: "+ejes;
    }
    public String toString(){
        return "Tipo: "+tipo+", "+super.toString()+", Capacidad: "+capacidad+", N° de ejes: "+ejes+", Precio: "+getPrecio();
    }
}
