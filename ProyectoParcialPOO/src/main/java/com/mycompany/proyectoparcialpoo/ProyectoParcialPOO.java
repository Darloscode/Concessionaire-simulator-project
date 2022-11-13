/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoparcialpoo;

import java.util.ArrayList;
import java.io.*;
import com.mycompany.model.subclass.Automovil;
import com.mycompany.model.subclass.Camion;
import com.mycompany.model.subclass.Motocicleta;
import com.mycompany.model.subclass.Tractor;
import com.mycompany.model.subclass.Usuario;
import com.mycompany.model.supclass.Vehiculo;

/**
 *
 * @author ander
 */
public class ProyectoParcialPOO {
    public static void main(String[] args) {

        Motocicleta m1 = new Motocicleta(null, null, 0, null, null, 0);
        Tractor t1 = new Tractor(null, null, 0, false, 0, null);
        Automovil a1 = new Automovil(null, null, 0, null, 0, 0, false, false);
        Camion c1 = new Camion(null, null, 0, null, 0, 0, 0, 0);
        System.out.println(m1);
        System.out.println(t1);
        System.out.println(a1);
        System.out.println(c1);

        cargarVehiculos();
                
    }


    public static ArrayList<Vehiculo> cargarVehiculos(){
        ArrayList<Vehiculo> arreglo = new ArrayList<Vehiculo>();
        File archivo = new File("D:\\Mis documentos\\Proyecto Parcial-POO\\POO9-ProyectoParcial\\ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\model\\files\\vehiculos.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            lectura = entrada.readLine();
            while (lectura != null){                
                lectura = entrada.readLine();
                
                System.out.println(lectura);
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return arreglo;
    }
        
}
