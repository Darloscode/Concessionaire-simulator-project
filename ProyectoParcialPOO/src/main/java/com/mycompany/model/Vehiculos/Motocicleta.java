package com.mycompany.model.Vehiculos;

public class Motocicleta extends Vehiculo{

    private String tipo = "Motocicleta";
    private Categoria ctg; 

    public Motocicleta(String marca, String modelo, int year,  Motor mtr, Categoria ctg, double precio){
        super(marca, modelo, year, mtr, 2, precio);
        this.ctg = ctg;
    }

    public String getTipo() {
        return tipo;
    }

    public Categoria getCategoria(){
        return ctg;
    }    

    @Override
    public String mostrarDatos(){
        return "Vehiculo: "+tipo+"\nCategoría: "+ctg+super.mostrarDatos();
    }    

    public String toString(){
        return "Tipo: "+tipo+", "+super.toString()+", Categoria: "+ctg+", Precio: "+getPrecio();
    }
}
