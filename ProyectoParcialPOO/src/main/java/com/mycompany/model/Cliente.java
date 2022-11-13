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
    private int Cedula;
    private String Ocupacion;
    private int Ingresos; 
    
    public Cliente(String password, String usuario,  String nombre, String apellido){
        super(password,usuario, nombre,apellido);
        this.Categoria= Categoria; 
        this.Cedula=Cedula;
        this.Ingresos= Ingresos;
        this.Ocupacion= Ocupacion;
        
        
        
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getCedula() {
        return Cedula;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public int getIngresos() {
        return Ingresos;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public void setOcupacion(String Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public void setIngresos(int Ingresos) {
        this.Ingresos = Ingresos;
    }
    
    
    
}
