package com.mycompany.model.Usuarios;

public class Cliente extends Usuario{ 

    private String tipo = "Cliente";
    private String cedula;
    private String ocupacion;
    private double ingresos; 
    
    
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
