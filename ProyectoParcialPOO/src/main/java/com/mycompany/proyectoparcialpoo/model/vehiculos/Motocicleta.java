package com.mycompany.proyectoparcialpoo.model.vehiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Motocicleta extends Vehiculo{
    private String tipo = "Motocicleta";
    private Categoria ctg; 

    //Constructor
    public Motocicleta(String marca, String modelo, int year,  Motor mtr, Categoria ctg, double precio){
        super(marca, modelo, year, mtr, 2, precio);
        this.ctg = ctg;
    }

    //Métodos getters
    public String getTipo() {
        return tipo;
    }
    public Categoria getCategoria(){
        return ctg;
    }    

    //Métodos para mostrar información del vehiculo con un dibujo
    @Override
    public String mostrarDatos(){
        if(ctg == Categoria.Deportiva){
            File archivo1 = new File("Dibujos\\moto2.txt");
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
            return "Vehiculo: "+tipo+"\nCategoría: "+ctg+super.mostrarDatos();
        }else if(ctg == Categoria.Scotter){
            File archivo1 = new File("Dibujos\\moto3.txt");
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
            return "Vehiculo: "+tipo+"\nCategoría: "+ctg+super.mostrarDatos();                        
        }else{
            File archivo1 = new File("Dibujos\\moto1.txt");
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
            return "Vehiculo: "+tipo+"\nCategoría: "+ctg+super.mostrarDatos(); 
        }
    }

    @Override
    public String toString(){
        if(ctg == Categoria.Deportiva){
            File archivo1 = new File("Dibujos\\moto2.txt");
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
               return "Tipo: "+tipo+", "+super.toString()+", Categoria: "+ctg+", Precio: "+getPrecio(); 
        }else if(ctg == Categoria.Scotter){
            File archivo1 = new File("Dibujos\\moto3.txt");
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
                return "Tipo: "+tipo+", "+super.toString()+", Categoria: "+ctg+", Precio: "+getPrecio();                        
        }else{
            File archivo1 = new File("Dibujos\\moto1.txt");
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
               return "Tipo: "+tipo+", "+super.toString()+", Categoria: "+ctg+", Precio: "+getPrecio(); 
            }
    }    
}
