package com.mycompany.proyectoparcialpoo;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;


import com.mycompany.model.Usuarios.*;
import com.mycompany.model.Vehiculos.*;

public class ProyectoParcialPOO {
     
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarSistema();        
        
        Scanner entrada = new Scanner(System.in);

        boolean salir = false;
        boolean exit = false;

        int user = -1;

        String opcion = "", usuario, password, tipo = "", op ="";

        boolean cotizar=false;

        while(!salir){
            System.out.println("\n*********************************");   
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
                    System.out.println("\n************Cliente************");
                    tipo = "Cliente";

                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();

                    user = login(usuario, password, tipo);                      
                    
                    
                    if(user != -1){                        
                        Usuario cl = usuarios.get(user);                    
                        Cliente usercliente = (Cliente) cl;                                                  

                        op = "";                        

                        usercliente.mostrarMensajes();

                        usercliente.mostrarCotizacionesAprobadas(usuarios, usercliente, vehiculos);                         
                        

                        if((usercliente.getVehiculos().size()!=0)){
                            exit = false;
                            op = "";

                            System.out.print("\nBienvenido Sr(a) "+usercliente.getTipo()+": "+usercliente.getNombre()+" "+usercliente.getApellido()); // muestra los datos del cliente al iniciar el sistema
                            while(!exit){                                
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Solicitar un mantenimiento\n4. Consultar mantenimiento\n5. Salir\n \nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){
                                    usercliente.consultarStock(vehiculos);    // llama a la lista de vehiculos (STOCK)                                      
                                }
                                else if(op.equals("2")){
                                    usercliente.solicitarCotizacion(vehiculos, usuarios, usercliente);
                                }else if(op.equals("3")){
                                    usercliente.solicitarMantenimiento(usercliente, usuarios);
                                }else if(op.equals("4")){
                                    usercliente.consultarMantenimiento();
                                }else if(op.equals("5")){
                                    exit = true;                                                                
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }
                        }else{
                            op = "";
                            exit = false;
                            while(!exit){
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Salir\nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){                                    
                                    usercliente.consultarStock(vehiculos);                                       
                                }else if(op.equals("2")){
                                    usercliente.solicitarCotizacion(vehiculos, usuarios, usercliente);                                                                                                                                              
                                }else if(op.equals("3")){
                                    exit = true;
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }                            
                        }                                                                        
                    }       
                    break;

                case "2":
                    System.out.println("\n************Vendedor************");
                    tipo = "Vendedor";
                    
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();
                    
                    user = login(usuario, password, tipo);    
                                                                                                    
                    if(user!=-1){
                        Usuario vd = usuarios.get(user);
                        Vendedor uservendedor = (Vendedor) vd;
                        op = "";

                        exit = false;
                        while(!exit){
                            System.out.print("\n1. Consultar Stock\n2. Solicitudes de cotizacion\n3. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            
                            if(op.equals("1")){                                                                   
                                uservendedor.consultarStock(vehiculos);                                 
                            }else if(op.equals("2")){                                                                    
                                uservendedor.mostrarCotizaciones();                                                                                                                                      
                            }else if(op.equals("3")){
                                exit = true;
                            }else{
                                System.out.println("\nEscoja una opcion correcta\n");
                            }
                        }
                    }
                    break;

                case "3":
                    System.out.println("\n************Supervisor************");
                    tipo = "Supervisor";
            
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
            
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();
                
                    user = login(usuario, password, tipo);  

                    if(user!=-1){
                        Usuario spv = usuarios.get(user);
                        Supervisor usersupervisor = (Supervisor) spv;
                        op = "";
                                         
                        usersupervisor.mostrarSolicitudes(usuarios, vehiculos);
                        
                        exit = false;
                        while(!exit){
                            System.out.print("\n1. Consultar Stock\n2. Adminitrar compras\n3. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            if(op.equals("1")){                                
                                usersupervisor.consultarStock(vehiculos);
                            }else if(op.equals("2")){
                                usersupervisor.mostrarSolicitudes(usuarios, vehiculos);                            
                            }else if(op.equals("3")){
                                exit = true;
                            }else{
                                System.out.println("\nElija una opcion valida\n");
                            }
                        }                                                                                                                     
                    }                                                                                                                         
                    break;

                case "4":
                    System.out.println("\n************Jefe de Taller************");
                    tipo = "Jefe de Taller";
                    
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();
                    
                    user = login(usuario, password, tipo);   
                    
                     if(user!=-1){
                        Usuario spv = usuarios.get(user);
                        JefedeTaller userjefetaller = (JefedeTaller) spv;
                        op = "";

                        exit = false;
                        while(!exit){

                            userjefetaller.verificarSolicitudes();
                            userjefetaller.verificarEntregas();

                            System.out.print("\n1. Mostrar entregas\n2. Admitir vehiculos para mantenimiento\n3. Administrar mantenimiento\n4. Salir\nElija una opcion: ");
                            op = entrada.nextLine();

                            if (op.equals("1")){
                                userjefetaller.mostrarEntregas(vehiculos);
                            }else if(op.equals("2")){
                                userjefetaller.admitirVehiculos(); 
                            }else if(op.equals("3")){
                                userjefetaller.administrarVehiculos();
                            }else if(op.equals("4")){
                                exit = true;
                            }else{
                                System.out.println("\nEscoja una opcion correcta\n");
                            }                            
                        }                         
                    }                                                         
                    break;

                case "9":
                    for(Usuario u: usuarios){
                        if(u.getTipo().equals("Vendedor")){
                            Vendedor v = (Vendedor) u;
                            System.out.println(v.getCotizaciones().size());
                        }
                    }
                    break;
                case "7":
                    for(Vehiculo vh : vehiculos){
                        System.out.println(vh.getDisponibilidad());
                        System.out.println(vh.getMantenimiento());
                        System.out.println(vh.getEstadoMantenimiento());
                    }
                    break;              
                case "k":
                    for(Usuario t: usuarios){
                        if(t instanceof Cliente){
                            Cliente cd = (Cliente) t;
                            System.out.println(cd.getVehiculos().size());
                            for(Vehiculo vh : cd.getVehiculos()){
                                System.out.println(vh.getDisponibilidad());
                                System.out.println(vh.getEstadoMantenimiento());
                                System.out.println(vh.getMantenimiento());
                            }
                        }
                    }
                    break;
                case "p":
                    for(Usuario t: usuarios){
                        if(t instanceof Cliente){
                            Cliente cd = (Cliente) t;
                            cd.cotizacionesAprobadas(new Automovil("Chevrolet", "Familiar", 2012, Motor.Gasolina, 4, true, false, 940));  
                            cd.cotizacionesAprobadas(new Motocicleta("Tuczoo", "Epica", 2008, Motor.Diesel, Categoria.Deportiva, 400));                
                        }
                    }
                    break;
                case "l":                    
                    for(Usuario a:usuarios){
                        if(a instanceof Supervisor){
                            Supervisor c = (Supervisor) a;
                            for(Vehiculo vh : c.getSolicitudes()){
                                vh.mostrarDatos();
                            }
                        }
                        System.out.println();            
                        System.out.println();
                    }                    
                    break;
                case "5":
                    salir = true;
                    break;

                default:
                    System.out.println("\nIngrese una opción valida\n");
            }
        }
    }  

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private static int login(String user, String password, String tipo){        
        Scanner rd = new Scanner(System.in);        
        int verificar=verificarLogin(user, password, tipo, usuarios);
        
        if(verificar != -1){
            System.out.println("\nHas iniciado sección\n");
            return verificar;
        }else{
            while((verificar == -1)){
                String op="";
                System.out.println("\n¿Quiere volver a intentarlo?");
                System.out.println("1. Reintentar");
                System.out.println("2. Salir\n");
                System.out.print("Elija una opcion: ");
                op = rd.nextLine();
    
                if(op.equals("1")){                                                
                    System.out.print("\nUsuario: ");
                    String usuario = rd.nextLine();
        
                    System.out.print("Contraseña: ");
                    String passw = rd.nextLine();
    
                    verificar=verificarLogin(usuario, passw, tipo, usuarios);

                    if(verificar != -1){
                        System.out.println("\nHas iniciado sección\n");
                        return verificar;
                    }
                }else if(op.equals("2")){
                    return -1;
                }else{
                    System.out.println("Elija una opción correcta");
                }
            }
        }
        return -1;
    }

    private static int verificarLogin(String user, String passw, String tipo, ArrayList<Usuario> usuarios){
        for(Usuario u : usuarios){
            if((u.getUsuario().equals(user)) & (u.getPassword().equals(passw)) & (u.getTipo().equals(tipo))){                        
                return usuarios.indexOf(u);
            }
        }
        System.out.println("\nCredenciales Incorrectas\n");
        return -1;        
    }

    private static void inicializarSistema(){
        usuarios.add(new Cliente("Marcos", "Veliz", "ca", "ca", "0123456789", "Administrador de empresas", 900));
        usuarios.add(new Vendedor("Alejandro", "Muñoz", "ta", "ta", 001));
        usuarios.add(new JefedeTaller("Jose", "Alvarez", "je", "je"));
        usuarios.add(new Supervisor("Michel", "Michelina", "mi", "mi"));        
        vehiculos.add(new Automovil("Chevrolet", "Familiar", 2012, Motor.Gasolina, 4, true, false, 940));        
        vehiculos.add(new Motocicleta("Tuczoo", "Epica", 2008, Motor.Diesel, Categoria.Deportiva, 400));
        usuarios.add(new Supervisor("juan","Maca", "ju","ju"));
        
    }          
}