package com.mycompany.model.Usuarios;
import java.util.ArrayList;

import com.mycompany.model.Vehiculos.Vehiculo; 

public class JefedeTaller1 extends Usuario{

    private String tipo = "Jefe de Taller";

    ArrayList<Vehiculo>MantenimientoVehiculos;
    ArrayList<String>CertifiacionesTecnicas;
    ArrayList<Vehiculo>EntregarVehiculos;
                            
    public JefedeTaller1(String nombre, String apellido, String usuario, String password){
        super(nombre, apellido, usuario, password);
    }

    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }
    
    public String getTipo(){
        return tipo;
    }
    
    
}
