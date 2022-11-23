/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoparcialpoo;
import java.io.*;
import java.util.ArrayList;
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

        ArrayList<Usuario> usuarios = inicializarSistema();
        for(Usuario a:usuarios){
            System.out.println(a.mostrarDatos());
            System.out.println();
        }

        ArrayList<Vehiculo> vehiculos = cargarVehiculos();
        for(Vehiculo v:vehiculos){
            System.out.println(v.mostrarDatos());
            System.out.println();
        }

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

        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\usuarios2.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();          
            lectura = entrada.readLine(); 

            while (lectura != null){
                
                String[] datos = lectura.split(",");

                if(datos[0].equals("Cliente")){                                    
                    double ingresos = Double.parseDouble(datos[7]);
                    arreglo.add(new Cliente(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], ingresos));
                }else if(datos[0].equals("Vendendor")){                    
                    int iden = Integer.parseInt(datos[5]);
                    arreglo.add(new Vendedor(datos[1], datos[2], datos[3], datos[4], iden));
                }else if(datos[0].equals("Jefe Taller")){
                    arreglo.add(new JefedeTaller(datos[1], datos[2], datos[3], datos[4]));
                }else if(datos[0].equals("Supervisor")){
                    arreglo.add(new Supervisor(datos[1], datos[2], datos[3], datos[4]));

                }                
                lectura = entrada.readLine();
            }
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }                    
        return arreglo;
    }

    private static ArrayList<Vehiculo> cargarVehiculos(){
        
        ArrayList<Vehiculo> arreglo = new ArrayList<>();        

        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\vehiculos.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();          
            lectura = entrada.readLine(); 

            while (lectura != null){
                
                String[] datos = lectura.split(",");

                if(datos[0].equals("Automovil")){                    
                    int year = Integer.parseInt(datos[3]);
                    int asientos = Integer.parseInt(datos[5]);
                    boolean conv = Boolean.parseBoolean(datos[6]);
                    boolean cam = Boolean.parseBoolean(datos[7]);
                    arreglo.add(new Automovil(datos[1], datos[2], year, datos[4], asientos, conv, cam, 34444));
                }else if(datos[0].equals("Camion")){                    
                    int year = Integer.parseInt(datos[3]);
                    int llantas = Integer.parseInt(datos[5]);
                    double capacidad = Double.parseDouble(datos[6]);
                    double ejes = Double.parseDouble(datos[7]);                    
                    arreglo.add(new Camion(datos[1], datos[2], year, datos[4], llantas, capacidad, ejes, 35555));
                }else if(datos[0].equals("Motocicleta")){
                    int year = Integer.parseInt(datos[3]);                    
                    arreglo.add(new Motocicleta(datos[1], datos[2], year, datos[4], datos[6], 34344));
                }else if(datos[0].equals("Tractor")){
                    int year = Integer.parseInt(datos[3]);
                    Boolean agri = Boolean.parseBoolean(datos[6]);                                        
                    arreglo.add(new Tractor(datos[1], datos[2], year, agri, datos[7], 78787));

                }                
                lectura = entrada.readLine();
            }
            
            entrada.close();            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }                    
        return arreglo;            
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