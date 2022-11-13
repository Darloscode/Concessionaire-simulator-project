package com.mycompany.model.subclass;

import com.mycompany.model.supclass.Vehiculo;

public class Motocicleta extends Vehiculo{

    private String tipo;

    public Motocicleta(String ma, String mod, int year,  String mot, String tipo, double precio){
        super(ma, mod, year, mot, 2, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString(){    
        return super.toString() + ", Tipo=" + tipo;
    }    
}
