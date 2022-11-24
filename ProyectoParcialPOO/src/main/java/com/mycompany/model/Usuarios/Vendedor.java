package com.mycompany.model.Usuarios;

import java.util.ArrayList;

import com.mycompany.model.Vehiculos.Vehiculo;

public class Vendedor extends Usuario{

    private String tipo = "Vendedor";
    private int id;
    private ArrayList cotizaciones = new ArrayList<>();
    
    public Vendedor(String nombre, String apellido, String usuario, String password, int id){
        super(nombre, apellido,usuario, password);
        this.id=id;
    }

    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos()+"\nID: "+id;
    }

    public String getTipo(){
        return tipo;
    }

    public ArrayList getCotizaciones(){
        return cotizaciones;
    }

    public void agregarCotizacion(Vehiculo auto, Cliente cl){
        ArrayList cotizar = new ArrayList<>();
        cotizar.add(auto);
        cotizar.add(cl);
        cotizaciones.add(cotizar);
    }

    
    /*
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "ID=" + ID + '}';
    }
     */
    
}
