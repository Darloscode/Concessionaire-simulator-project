package com.mycompany.model.subclass;

import com.mycompany.model.supclass.Vehiculo;

public class Tractor extends Vehiculo{
    private boolean agricola;
    private String transmision;

    public Tractor(String ma, String mod, int year, boolean agricola, double precio, String transmision){
        super(ma, mod, year, "Diesel", 4, precio);
        this.agricola = agricola;
        this.transmision = transmision;
    }

    public boolean getAgricola() {
        return agricola;
    }

    public void setAgricola(Boolean agricola) {
        this.agricola = agricola;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setMarca(String transmision) {
        this.transmision = transmision;
    }

    public String toString(){    
        return super.toString() + ", Agricola=" + agricola + ", Transmision=" + transmision;
    }
}
