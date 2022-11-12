/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.subclass;

public class Vendedor extends Usuario{

    private int ID;
    
    
   public  Vendedor(String password, String usuario, String nombre,String apellido, int ID){
       super(password,usuario,nombre,apellido);
       this.ID=ID;              
   }

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
    
}
