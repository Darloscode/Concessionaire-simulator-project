/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoparcialpoo;
import com.mycompany.model.*;
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
    }
        
}
