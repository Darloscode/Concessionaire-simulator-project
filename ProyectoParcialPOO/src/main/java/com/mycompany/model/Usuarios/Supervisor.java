package com.mycompany.model.Usuarios;

import com.mycompany.model.Vehiculos.Vehiculo;
import java.util.ArrayList;

public class Supervisor extends Usuario{

    private String tipo = "Supervisor";
    private ArrayList<Vehiculo> solicitudes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
            
    public Supervisor(String nombre, String apellido, String usuario, String password){
        super(nombre, apellido,usuario, password);        
    }

    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }

    public String getTipo(){
        return tipo;
    }
    

    public void agregarSolicitud(Vehiculo vh, Cliente cl){
        solicitudes.add(vh);
        clientes.add(cl);
    }

    public ArrayList<Vehiculo> getSolicitudes() {
        return solicitudes;
    }


    /*
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
     */
}
       
        
        
    

