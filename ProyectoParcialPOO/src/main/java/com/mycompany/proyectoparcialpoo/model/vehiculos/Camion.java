package com.mycompany.proyectoparcialpoo.model.vehiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Camion extends Vehiculo{
    private String tipo = "Camion";
    private double capacidad;
    private double ejes;

    //Constructor
    public Camion(String marca, String modelo, int year,  Motor mtr, int llantas, double capacidad, double precio){
        super(marca, modelo, year, mtr, llantas, precio);
        this.capacidad = capacidad;        
    }
    
    //Métodos getters
    public double getCapacidad() {
        return capacidad;
    }
    public double getEjes() {
        return capacidad/2;
    }
    
    //Métodos para mostrar información del vehiculo con un dibujo
    @Override
    public String mostrarDatos(){
        File archivo1 = new File("Dibujos\\camion1.txt");
        Scanner sc;
        try {
            sc = new Scanner(archivo1);
            while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);           
        }  
        } catch (FileNotFoundException ex) {
            System.out.println(" ");
        }  
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nCapacidad: "+capacidad+"\nEjes: "+ejes;
    }
    
    @Override
    public String toString(){
        File archivo1 = new File("Dibujos\\camion1.txt");
        Scanner sc;
        try {
            sc = new Scanner(archivo1);
            while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);           
        }  
        } catch (FileNotFoundException ex) {
            System.out.println(" ");
        }  
        return "Tipo: "+tipo+", "+super.toString()+", Capacidad: "+capacidad+", N° de ejes: "+ejes+", Precio: "+getPrecio();
    }   
}
