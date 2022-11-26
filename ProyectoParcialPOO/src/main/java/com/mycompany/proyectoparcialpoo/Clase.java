package com.mycompany.proyectoparcialpoo;

public abstract class Clase {
    public abstract void mostrarSansion();
    public static void mostrarSa(){
        System.out.println("asdfa");
    }
    public static void main(String [] args){
        Clase p = new Partido();
        p.mostrarSansion();
        p.mostrarSa();
    }
}

class Partido extends Clase{
    public void mostrarSansion(){
        System.out.println("sfaffff");        
    }
    public static void mostrarSa(){
        System.out.println("asdfasdfadf");
    }
}
