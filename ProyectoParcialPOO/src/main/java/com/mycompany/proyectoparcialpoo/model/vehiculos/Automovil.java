package com.mycompany.proyectoparcialpoo.model.vehiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Automovil extends Vehiculo{    
    private String tipo = "Automovil";
    private int asientos;
    private boolean convertible;
    private boolean camara;

    //Constructor
    public Automovil(String marca, String modelo, int year,  Motor mtr, int asientos, boolean conv, boolean cam, double precio){
        super(marca, modelo, year, mtr, 4, precio);
        this.asientos = asientos;
        this.convertible = conv;
        this.camara = cam;
    }

    //Métodos getters
    public int getAsientos() {
        return asientos;
    }    
    public boolean getConvertible() {
        return convertible;
    }    
    public boolean getCamara() {
        return camara;
    }

    //Métodos para mostrar información del vehiculo con un dibujo
    @Override
    public String mostrarDatos(){
        File archivo1 = new File("Dibujos\\carro2.txt");
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
        return "Vehiculo: "+tipo+super.mostrarDatos()+"\nAsiento: "+asientos+"\nConvertible: "+convertible+"\nCamara: "+camara;
    }
    
    @Override
    public String toString(){
        File archivo1 = new File("Dibujos\\carro2.txt");
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
        return "Tipo: "+tipo+", "+super.toString()+", Asientos: "+asientos+", Convertible: "+convertible+", Camara: "+camara+", Precio: "+getPrecio();
    }   
}
