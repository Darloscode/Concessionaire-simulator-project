package com.mycompany.model.Usuarios;
import java.util.ArrayList;

import com.mycompany.model.Vehiculos.Vehiculo; 

public class JefedeTaller extends Usuario{

    private String tipo = "Jefe de Taller";

    ArrayList<String>CertifiacionesTecnicas;


    ArrayList<Vehiculo> mantenimientoVehiculos = new ArrayList<>();
    ArrayList<Cliente> clientesmantenimiento = new ArrayList<>();

    ArrayList<Vehiculo> entregarvehiculos = new ArrayList<>();
    ArrayList<Cliente> clientesentregar = new ArrayList<>();

                            
    public JefedeTaller(String nombre, String apellido, String usuario, String password){
        super(nombre, apellido, usuario, password);        
    }

    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }
    
    public String getTipo(){
        return tipo;
    }

    public void agregarEntregas(Vehiculo auto, Cliente cl){        
        entregarvehiculos.add(auto);
        clientesentregar.add(cl);
    }

    public void agregarMantenimientos(Vehiculo auto, Cliente cl){
        mantenimientoVehiculos.add(auto);
        clientesmantenimiento.add(cl);
    }

    


    


    private ArrayList<Vehiculo> Ventas= new ArrayList<>();
    private ArrayList<Supervisor> clientes = new ArrayList<>();    
    public void agregarSolicitud(Vehiculo vh, Supervisor sp){
        Ventas.add(vh);
        clientes.add(sp);    
    }

    /*
    public ArrayList<JefedeTaller> getMantenimientoVehiculos() {
        return MantenimientoVehiculos;
    }

    public ArrayList<JefedeTaller> getCertifiacionesTecnicas() {
        return CertifiacionesTecnicas;
    }

    public ArrayList<JefedeTaller> getEntregarVehiculos() {
        return EntregarVehiculos;
    }

    public void setMantenimientoVehiculos(ArrayList<JefedeTaller> MantenimientoVehiculos) {
        this.MantenimientoVehiculos = MantenimientoVehiculos;
    }

    public void setCertifiacionesTecnicas(ArrayList<JefedeTaller> CertifiacionesTecnicas) {
        this.CertifiacionesTecnicas = CertifiacionesTecnicas;
    }

    public void setEntregarVehiculos(ArrayList<JefedeTaller> EntregarVehiculos) {
        this.EntregarVehiculos = EntregarVehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final JefedeTaller other = (JefedeTaller) obj;
        if (!Objects.equals(this.MantenimientoVehiculos, other.MantenimientoVehiculos)) {
            return false;
        }
        if (!Objects.equals(this.CertifiacionesTecnicas, other.CertifiacionesTecnicas)) {
            return false;
        }
        return Objects.equals(this.EntregarVehiculos, other.EntregarVehiculos);
    }
    */   
}