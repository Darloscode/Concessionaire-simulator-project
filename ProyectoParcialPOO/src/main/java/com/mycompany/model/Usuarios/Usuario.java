package com.mycompany.model.Usuarios;

public abstract class Usuario {

    private String tipo;
    private String usuario;
    private String password;     
    private String nombre;
    private String apellido; 

    public Usuario(String nombre, String apellido, String usuario, String password){ 
        this.usuario=usuario;
        this.password=password;
        this.nombre=nombre;        
        this.apellido=apellido;        
    }
    
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

    public String mostrarDatos(){
        return "\nNombre: "+nombre+"\nApellido: "+apellido+"\nUsuario: "+usuario;
    }

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isDecimal(String cadena){
        try {            
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e){
            return false;        
        }
    }
}