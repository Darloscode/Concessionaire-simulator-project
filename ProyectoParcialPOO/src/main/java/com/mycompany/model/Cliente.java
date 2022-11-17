/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Sexto
 */
public class Cliente extends Usuario{    
    private String Categoria;
    private String Cedula;
    private String Ocupacion;
    private double Ingresos; 
    
    
    public Cliente(String password, String usuario,  String nombre, String apellido, String Categoria, String Cedula, String Ocupacion, double Ingresos){
        super(password,usuario, nombre,apellido);
        this.Categoria= Categoria; 
        this.Cedula=Cedula;
        this.Ingresos= Ingresos;
        this.Ocupacion= Ocupacion;
        
        
        
    }    
    public String getCategoria() {
        return Categoria;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public double getIngresos() {
        return Ingresos;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setOcupacion(String Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public void setIngresos(int Ingresos) {
        this.Ingresos = Ingresos;
    }
    
    
    
}
