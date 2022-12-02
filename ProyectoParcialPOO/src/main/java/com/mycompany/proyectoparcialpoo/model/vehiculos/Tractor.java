package com.mycompany.proyectoparcialpoo.model.vehiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tractor extends Vehiculo{
    private String tipo = "Tractor";
    private boolean agricola;
    private Transmision transmision;
    
    //Constructor
    public Tractor(String marca, String modelo, int year, boolean agricola, Transmision transmision, double precio){
        super(marca, modelo, year, Motor.Diesel, 4, precio);
        this.agricola = agricola;
        this.transmision = transmision;
    }

    //Métodos getters
    public boolean getAgricola() {
        return agricola;
    }    
    public Transmision getTransmision() {
        return transmision;
    }    

    //Métodos para mostrar información del vehiculo con un dibujo
    @Override
    public String mostrarDatos(){
        File archivo1 = new File("Dibujos\\tractor1.txt");
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
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nAgricola: "+agricola+"\nTransmision: "+transmision;
    }
    
    @Override
    public String toString(){
        File archivo1 = new File("Dibujos\\tractor1.txt");
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
        return "Tipo: "+tipo+", "+super.toString()+", Agricola: "+agricola+", Transmision: "+transmision+", Precio: "+getPrecio();
    }      
}
