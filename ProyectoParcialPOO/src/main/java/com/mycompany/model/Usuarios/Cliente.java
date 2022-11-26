package com.mycompany.model.Usuarios;

import java.util.ArrayList;

import com.mycompany.model.Vehiculos.Estado;
import com.mycompany.model.Vehiculos.Vehiculo;

public class Cliente extends Usuario{ 

    private String tipo = "Cliente";
    private String cedula;
    private String ocupacion;
    private double ingresos;    
    private ArrayList<Vehiculo> vehiculos;
    public ArrayList<String> mensajes;
    
    public Cliente(String nombre, String apellido, String usuario, String password, String cedula, String ocupacion, double ingresos){
        super(nombre, apellido,usuario, password);        
        this.cedula =cedula;
        this.ingresos = ingresos;
        this.ocupacion = ocupacion;                        
    }

    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos()+"\nCedula: "+cedula+"\nOcupacion: "+ocupacion+"\nIngresos: "+ingresos;
    }
    
    public void agregarVehiculo(Vehiculo auto){
        vehiculos.add(auto);
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public String getTipo(){
        return tipo;
    }

    public void setCedula(String cedula){
        this.cedula = cedula; 
    }

    public void consultarStock(ArrayList<Vehiculo> vehiculos){
        int i = 1;
        System.out.println();
        for(Vehiculo vh : vehiculos){
            if(vh.getDisponibilidad().equals(Estado.Disponible)){
                System.out.println(i+". Marca: "+vh.getMarca()+", Modelo: "+vh.getModelo()+", Año: "+vh.getYear());
            }
            i++;
        }
    }

    public Vehiculo solicitarCotizacion(int indice, ArrayList<Vehiculo> arreglo){        
        return arreglo.get(indice-1);
    }
    



   
    



    /*
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
    */
    
    
}
