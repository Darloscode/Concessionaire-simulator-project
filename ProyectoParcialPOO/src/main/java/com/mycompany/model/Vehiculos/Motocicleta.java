package com.mycompany.model.Vehiculos;

public class Motocicleta extends Vehiculo{

    private String tipo = "Motocicleta";
    private String grupo;    

    public Motocicleta(String marca, String modelo, int year,  String motor, String grupo, double precio){
        super(marca, modelo, year, motor, 2, precio);
        this.grupo = grupo;
    }

    public String getTipo() {
        return tipo;
    }    

    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+" "+grupo+super.mostrarDatos();
    }    
}
