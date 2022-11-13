/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;
import  java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Sexto
 */
public class Supervisor extends Usuario{
    private ArrayList<Supervisor>Certificaciones;
    
    
    public Supervisor(String password, String usuario,  String nombre, String apellido){
        super(password,usuario,nombre,apellido);
        this.Certificaciones=new ArrayList<>();
    }

    public ArrayList<Supervisor> getCertificaciones() {
        return Certificaciones;
    }

    public void setCertificaciones(ArrayList<Supervisor> Certificaciones) {
        this.Certificaciones = Certificaciones;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supervisor other = (Supervisor) obj;
        return Objects.equals(this.Certificaciones, other.Certificaciones);
    }

    @Override
    public String toString() {
        return "Supervisor{" + "Certificaciones=" + Certificaciones + '}';
    }
    
    
    public boolean administrarSolicitudes(){
        
       return false ;  
    }
}
       
        
        
    

