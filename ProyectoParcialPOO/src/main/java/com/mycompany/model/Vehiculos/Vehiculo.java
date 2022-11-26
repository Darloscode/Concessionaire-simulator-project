package com.mycompany.model.Vehiculos;

public class Vehiculo {

    private String  marca;
    private String modelo;
    private int year;
    private String motor;
    private int llantas;
    private double precio;
    private Estado disponibilidad;
    
    public Vehiculo(String marca, String modelo, int year,  String motor, int llantas, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.motor = motor;
        this.llantas = llantas;
        this.precio = precio;
        this.disponibilidad = Estado.Disponible;
    }
    
    public Estado getDisponibilidad(){
        return disponibilidad;
    }

    public void setDisponible(Estado disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    public String getMarca() {
        return marca;        
    }

    public String getModelo() {
        return modelo;
    }
    
    public int getYear() {
        return year;
    }

    public String getMotor() {
        return motor;        
    }
    
    public int getLlanta() {
        return llantas;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String mostrarDatos(){
        return "\nMarca: "+marca+"\nModelo: "+modelo+"\nAño: "+year+"\nMotor: "+motor+"\nLlantas: "+llantas+"\nPrecio: "+precio+"\nEstado: "+disponibilidad;
    }

    
}