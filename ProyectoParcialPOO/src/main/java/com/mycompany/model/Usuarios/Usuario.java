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
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }


    /*
        @Override
    public String toString(){
        return "Usuario{" + "password=" + password + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }
     */    
}
