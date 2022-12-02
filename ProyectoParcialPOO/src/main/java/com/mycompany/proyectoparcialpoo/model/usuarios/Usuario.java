package com.mycompany.proyectoparcialpoo.model.usuarios;

public class Usuario {        
    private String tipo;
    private String usuario;
    private String password;     
    private String nombre;
    private String apellido; 

    //Constructor
    public Usuario(String nombre, String apellido, String usuario, String password){ 
        this.usuario=usuario;
        this.password=password;
        this.nombre=nombre;        
        this.apellido=apellido;        
    }
    
    //Métodos getters
    public String getPassword(){
        return password;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTipo(){
        return tipo;
    }

    //Método para mostrar información del usuario
    public String mostrarDatos(){
        return "\nNombre: "+nombre+"\nApellido: "+apellido+"\nUsuario: "+usuario;
    }

    //Método de tipo boolean que verificará si el String puede convertirse en un valor tipo int
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //Método de tipo boolean que verificará si el String puede convertirse en un valor tipo double
    public static boolean isDecimal(String cadena){
        try {            
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e){
            return false;        
        }
    }            
}
