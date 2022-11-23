package com.mycompany.model.Usuarios;

public class Vendedor extends Usuario{

    private String tipo = "Vendedor";
    private int id;
    
    public Vendedor(String nombre, String apellido, String usuario, String password, int id){
        super(nombre, apellido,usuario, password);
        this.id=id;
    }

    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos()+"\nID: "+id;
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
