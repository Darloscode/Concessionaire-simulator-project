package com.mycompany.model.Vehiculos;

public class Vehiculo {

    private String  marca;
    private String modelo;
    private int year;
    private Motor mtr;
    private int llantas;
    private double precio;
    private Estado disponibilidad;
    
    public Vehiculo(String marca, String modelo, int year, Motor mtr, int llantas, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.mtr = mtr;
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

    public Motor getMotor(){
        return mtr;
    }
    
    public void setMotor(Motor mtr){
        this.mtr = mtr;
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

    public int getLlanta() {
        return llantas;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String mostrarDatos(){
        return "\nEstado: "+disponibilidad+"\nMarca: "+marca+"\nModelo: "+modelo+"\nAño: "+year+"\nMotor: "+mtr+"\nLlantas: "+llantas+"\nPrecio: "+precio;
    }        
}