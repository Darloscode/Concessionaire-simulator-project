package com.mycompany.proyectoparcialpoo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

import com.mycompany.model.Vehiculos.*;
import com.mycompany.model.Usuarios.*;
/**
 *
 * @author ander
 */
public class Prueba {
    public static void main(String[] args) {
        /*
        ArrayList<Camion> arr = new ArrayList<Camion>();

        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));    
        System.out.println(arr);

        //Cliente c1 = new Cliente("12333", "Darlos", "Carlos", "Flores", "AF", "0959447095", "Padre", 122);        

        //String contenido = c1.getNombre()+","+c1.getApellido()+","+arr;
        
        String asdds = "asdfa";

        System.out.println(asdds==null);


        String nombre = "Codi";
        String apellido = "Facilito";
        String a="adfasd";
        String b="<sdfasdfa";
        String nombreCompleto = String.format("%s %100s", b, a);
        System.out.println(nombreCompleto);
        System.out.println(String.format("%100s", b));
        for(int i=0; i<=10; i++){
            nombreCompleto = String.format("%s %s", nombre, apellido);
            System.out.println(nombreCompleto);
        }
       
        String s = "dfdf";
        System.out.println(isNumeric(s));
        Random rnd = new Random();
        for(int i=0; i<=10; i++){
            int ale = rnd.nextInt(100);
            System.out.println(ale);

        }
        
        Random rnd = new Random();
        int num = 0;
        int n = 0;
        int rango = 1;
        while(num!=0 | n!=100){
            num = rnd.nextInt(rango+1);
            System.out.println(num);
            n++;
        }                
        */
        Cliente cl1 = new Cliente(null, null, null, null, null, null, 0);
        Automovil au1 = new Automovil(null, null, 0, null, 0, false, false, 0);
        ArrayList arreglo = new ArrayList<>();
        ArrayList prueba = new ArrayList<>();
        prueba.add(cl1);
        prueba.add(au1);
        arreglo.add(prueba);
        prueba.add(cl1);
        prueba.add(au1);
        arreglo.add(prueba);
        prueba.add(cl1);
        prueba.add(au1);
        arreglo.add(prueba);
        System.out.println(arreglo.size());


    }
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}