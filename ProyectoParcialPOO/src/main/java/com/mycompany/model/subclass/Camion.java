package com.mycompany.model.subclass;

import com.mycompany.model.supclass.Vehiculo;

public class Camion extends Vehiculo{
    private double capacidad;
    private double ejes;

    public Camion(String ma, String mod, int year,  String mot, int lla, double precio, double capacidad, double ejes){
        super(ma, mod, year, mot, lla, precio);
        this.capacidad = capacidad;
        this.ejes = ejes;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEjes() {
        return ejes;
    }

    public void setEjes(double ejes) {
        this.ejes = ejes;
    }

    public String toString(){    
        return super.toString() + ", Capacidad de carga=" + capacidad + ", Número de ejes=" + ejes;    
    }
}
