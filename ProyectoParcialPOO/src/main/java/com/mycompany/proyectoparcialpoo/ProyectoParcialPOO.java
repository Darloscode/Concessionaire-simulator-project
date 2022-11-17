/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoparcialpoo;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ander
 */
public class ProyectoParcialPOO {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String usuario;
        String contraseña;
    
        while(!salir){            
            System.out.println("**Bienvenido**");
            System.out.println("1. Cliente ");
            System.out.println("2. Vendedor");
            System.out.println("3. Supervisor");
            System.out.println("4. Jefe de taller");
            System.out.println("5. Salir");
            
            System.out.print("Elija una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();            
            
            switch(opcion){
                case 1:   
                    System.out.println("***Cliente***");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                    
                    System.out.print("Contraseña: ");
                    contraseña = entrada.nextLine();
                    login(usuario, contraseña);
                    break;
                    
                case 2:
                    System.out.println("***Vendedor***");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                    
                    System.out.print("Contraseña: ");
                    contraseña = entrada.nextLine();    
                    break;
                    
                case 3:
                    System.out.println("***Supervisor***");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                    
                    System.out.print("Contraseña: ");
                    contraseña = entrada.nextLine();  
                    break;
                    
                case 4:
                    System.out.println("***Jefe de Taller***");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                    
                    System.out.print("Contraseña: ");
                    contraseña = entrada.nextLine();  
                    break;
                    
                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Fuera de rango");
            }
        }
    }

    private static boolean login(String user, String password){
        File archivo = new File("..\\files\\usuarios.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();                        
            while (lectura != null){
                System.out.println(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }                    

        return true;        
    }
}