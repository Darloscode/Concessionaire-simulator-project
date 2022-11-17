package com.mycompany.model;

public class Vehiculo {
    private String  marca;
    private String modelo;
    private int año;
    private String motor;
    private int llantas;
    private double precio;
    
    public Vehiculo(String ma, String mod, int year,  String mot, int lla, double precio){
        this.marca = ma;
        this.modelo = mod;
        this.año = year;
        this.motor = mot;
        this.llantas = lla;
        this.precio = precio;
    }    

    public String getMarca() {
        return marca;        
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String mod) {
        this.modelo = mod;
    }

    public int getYear() {
        return año;
    }

    public void setYear(int yer) {
        this.año = yer;
    }

    public String getMotor() {
        return motor;        
    }

    public void setMotor(String mot) {
        this.motor = mot;
    }

    public int getLlanta() {
        return llantas;
    }

    public void setLlanta(int lla) {
        this.llantas = lla;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Vehiculo : " + "Marca=" + marca + ", Modelo=" + modelo + ", Año=" + año +", Motor=" + motor + ", Llantas=" + llantas;
    }    
}