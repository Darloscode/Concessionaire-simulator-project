package com.mycompany.proyectoparcialpoo;

import java.util.ArrayList;

import com.mycompany.model.*;
import java.io.*;
/**
 *
 * @author ander
 */
public class Prueba {
    public static void main(String[] args) {

        ArrayList<Camion> arr = new ArrayList<Camion>();

        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));
        arr.add(new Camion(null, null, 0, null, 0, 0, 0, 0));    
        System.out.println(arr);

        //Cliente c1 = new Cliente("12333", "Darlos", "Carlos", "Flores", "AF", "0959447095", "Padre", 122);

        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\usuarios.txt");

        //String contenido = c1.getNombre()+","+c1.getApellido()+","+arr;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();                                           
            lectura = entrada.readLine(); 

            while (lectura != null){
                
                String[] datos = lectura.split(";");
                for(String d: datos){
                    System.out.println(d);

                }
                ArrayList<Vehiculo> carros = new ArrayList<Vehiculo>();                
                
                System.out.println(datos);
                               
                lectura = entrada.readLine();
            }
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } 
        
        
    }
}