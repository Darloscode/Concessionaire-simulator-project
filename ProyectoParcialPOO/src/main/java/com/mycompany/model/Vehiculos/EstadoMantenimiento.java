package com.mycompany.model.Vehiculos;

public enum EstadoMantenimiento {

    ADMI("Admitido"), Reparacion("En reparacion"), Prueba("En etapa de prueba");

    private String estadomant;

    private EstadoMantenimiento(String estadomant){
        this.estadomant = estadomant;
    }

    
}
