/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoparcialpoo;
import java.util.ArrayList;
//import java.io.*;
import java.util.Scanner;
import com.mycompany.model.Usuarios.*;
import com.mycompany.model.Vehiculos.*;

/**
 *
 * @author ander
 */
public class ProyectoParcialPOO {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        String opcion;
        String usuario;
        String contraseña;
    
        while(!salir){
            System.out.println("*********************************");   
            System.out.println("**Bienvenido**");
            System.out.println("1. Cliente ");
            System.out.println("2. Vendedor");
            System.out.println("3. Supervisor");
            System.out.println("4. Jefe de taller");
            System.out.println("5. Salir\n");
            
            System.out.print("Elija una opcion: ");
            opcion = entrada.nextLine();            
            System.out.println("*********************************");   
            
            switch(opcion){
                case "1":
                    System.out.println("********Cliente********");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                    
                    System.out.print("Contraseña: ");
                    contraseña = entrada.nextLine();

                    boolean verificar = login(usuario, contraseña);

                    String op = "";

                    while((!verificar)){

                        System.out.println("¿Quiere volver a intentarlo?");
                        System.out.println("1. Reintentar");
                        System.out.println("2. Salir\n");
                        System.out.print("Elija una opcion: ");
                        op = entrada.nextLine();

                        if(op.equals("1")){ 
                            System.out.println("--------------------------------");
                            System.out.println("***Cliente***");

                            System.out.print("Usuario: ");
                            usuario = entrada.nextLine();
                    
                            System.out.print("Contraseña: ");
                            contraseña = entrada.nextLine();

                            verificar = login(usuario, contraseña);
                        }else if(op.equals("2")){
                            break;
                        }else{
                            System.out.println("Elija una opción correcta");
                        }
                    }                  
                    
                    break;
                /*
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
                 */                
                case "5":
                    salir = true;
                    break;

                default:
                    System.out.println("Ingrese una opción valida");
            }
        }
    }


    private static boolean login(String user, String password){

        return true;

    }
    
    private static ArrayList<Usuario> inicializarSistema(){
        ArrayList<Usuario> arreglo = new ArrayList<>();        
        return new ArrayList<Usuario>();
    }


    /*
    private static boolean login(String user, String password){
        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\usuarios.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();                                           
            lectura = entrada.readLine(); 

            while (lectura != null){
                
                String[] datos = lectura.split(",");                

                if((datos[3].equals(user)) & (datos[4].equals(password))){                    
                    System.out.println("\nHas iniciado sección\n");
                    entrada.close();
                    return true;
                }                              
                lectura = entrada.readLine();
            }
            System.out.println("\nSu usuario o contraseña estan incorrectos\n");
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }                    
        return false;
    }
    */    
}