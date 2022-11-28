package com.mycompany.model.Usuarios;

import java.util.random.*;
import java.util.ArrayList;
import java.util.Random;

import com.mycompany.model.Vehiculos.Estado;
import com.mycompany.model.Vehiculos.Vehiculo;

public class Cliente extends Usuario{ 

    private String tipo = "Cliente";
    private String cedula;
    private String ocupacion;
    private double ingresos;    
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public ArrayList<String> mensajes = new ArrayList<>();
    private ArrayList<Vehiculo> cotizaciones = new ArrayList<>();
    
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
    
    public void enviarCotizacion(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        Random rnd = new Random();
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Vendedor")){                                
                Vendedor uservendedor = (Vendedor) arrayusuarios.get(indice);
                uservendedor.agregarCotizacion(vh, cl);                
                //uservendedor.getVehiculos().add(vh); PUEDES USAR ESTO SIN NECESIDAD DEL METODO AGREGARVEHICULO                          
                verificar = true;
            }         
        }
    }

    public void enviarCompra(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        for(Usuario us : arrayusuarios){
            if(us.getTipo().equals("Supervisor")){
                Supervisor spvisor = (Supervisor) us;
                spvisor.agregarSolicitud(vh, cl);
            }
        }
    }

    public Vehiculo solicitarCotizacion(int indice, ArrayList<Vehiculo> arreglo){        
        return arreglo.get(indice-1);
    }
    
    public Vehiculo solicitarCompra(Vehiculo vh, ArrayList<Vehiculo> arreglo){
        int indice = arreglo.indexOf(vh);
        return arreglo.get(indice);
    }    
    
    public ArrayList<String> getMensajes(){
        return mensajes;
    }

    public void agregarMensaje(String mensaje){
        mensajes.add(mensaje);
    }

    public ArrayList<Vehiculo> getCotizaciones(){
        return cotizaciones;
    }

    public void cotizacionesAprobadas(Vehiculo vh){
        cotizaciones.add(vh);
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
