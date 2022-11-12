/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.subclass;

import java.util.Objects;

/**
 *
 * @author Aaroncito
 */
public class Usuario {
    private String password;
    private String usuario; 
    private String nombre;
    private String apellido; 

    
    public Usuario( String password, String usuario,  String nombre, String apellido){   
        this.password=password; 
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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
    
    
    @Override
    public String toString() {
        return "Usuario{" + "password=" + password + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
   
    
}
