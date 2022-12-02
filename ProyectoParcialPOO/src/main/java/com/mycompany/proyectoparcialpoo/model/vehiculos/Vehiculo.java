package com.mycompany.proyectoparcialpoo.model.vehiculos;

public class Vehiculo {
    private String  marca;
    private String modelo;
    private int year;
    private Motor mtr;
    private int llantas;
    private double precio;
    private Estado disponibilidad;

    private Mantenimiento mantenimiento;
    private EstadoMantenimiento estadomant;
    
    //Constructor
    public Vehiculo(String marca, String modelo, int year, Motor mtr, int llantas, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.mtr = mtr;
        this.llantas = llantas;
        this.precio = precio;
        this.disponibilidad = Estado.Disponible;
    }

    
    //Métodos getters
    public Motor getMotor(){
        return mtr;
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
    public Estado getDisponibilidad(){
        return disponibilidad;
    }
    public Mantenimiento getMantenimiento(){
        return mantenimiento;
    }
    public EstadoMantenimiento getEstadoMantenimiento(){
        return estadomant;
    }

    //Métodos setters
    public void setDisponibilidad(Estado disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    public void setMantenimiento(Mantenimiento mantenimiento){
        this.mantenimiento = mantenimiento;
    }    
    public void setEstadoMantenimiento(EstadoMantenimiento estadomant){
        this.estadomant = estadomant;
    }
                
    
    //Métodos para mostrar información del vehiculo
    public String mostrarDatos(){
        return "\nEstado: "+disponibilidad+"\nMarca: "+marca+"\nModelo: "+modelo+"\nAño: "+year+"\nMotor: "+mtr+"\nLlantas: "+llantas+"\nPrecio: "+precio;
    }
    @Override
    public String toString(){
        return "Marca: "+marca+", Modelo: "+modelo+", Año: "+year+", Motor: "+mtr+", Llantas: "+llantas;
    }     
}
