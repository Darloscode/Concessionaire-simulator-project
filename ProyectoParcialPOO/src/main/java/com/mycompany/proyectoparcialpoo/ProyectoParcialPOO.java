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

        int user = -1;

        String opcion = "", usuario, password, tipo = "", op ="";

        boolean cotizar=false;

        
        //ArrayList<Usuario> usuarios = inicializarSistema();

        /*
        //ArrayList<Usuario> usuarios = inicializarSistema();
        for(Usuario a:usuarios){
            System.out.println(a.getClass());            
            System.out.println();
        }

        
        ArrayList<Vehiculo> vehiculos = cargarVehiculos();
        for(Vehiculo v:vehiculos){
            System.out.println(v.mostrarDatos());
            System.out.println(v.getDisponible());
        } 
        */   

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
                    System.out.println("************Cliente************");
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
                        if((usercliente.getVehiculos()!=null)){
                            while(!op.equals("3")){
                                System.out.print("1. Consultar Stock\n2. Solicitar cotizacion\n3. Solicitar compra\n4. solicitar un mantenimiento preventivo o de emergencia\n5. Consultar mantenimiento\n6. Salir\nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){                                    
                                    usercliente.consultarStock(vehiculos);                                    
                                }else if(op.equals("2")){                                   
                                    String indvehiculo = "1";
                                    while(!indvehiculo.equals("s")){                                        
                                        System.out.print("\nElija un numero de la lista de vehiculos o escriba (s) para salir: ");
                                        indvehiculo = entrada.nextLine();                                        
                                        if(isNumeric(indvehiculo)){
                                            int ind = Integer.parseInt(indvehiculo);
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo cotiza = usercliente.solicitarCotizacion(ind, vehiculos);
                                                enviarCotizacion(cotiza, usuarios, usercliente);
                                                break;                    
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            break;
                                        }                                        
                                    }    
                                }else if(op.equals("3")){

                                }else if(op.equals("4")){

                                }else if(op.equals("5")){

                                }else if(op.equals("6")){
                                    break;
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }
                        }else if(cotizar){
                            op = "";
                            while(!op.equals("3")){
                                System.out.print("1. Consultar Stock\n2. Solicitar cotizacion\n3. Solicitar compra\n4. Salir\nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){
                                    usercliente.consultarStock(vehiculos);    
                                }else if(op.equals("2")){
                                    String indvehiculo = "1";
                                    while(!indvehiculo.equals("s")){                                        
                                        System.out.print("\nElija un numero de la lista de vehiculos o escriba (s) para salir: ");
                                        indvehiculo = entrada.nextLine();                                        
                                        if(isNumeric(indvehiculo)){
                                            int ind = Integer.parseInt(indvehiculo);
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo cotiza = usercliente.solicitarCotizacion(ind, vehiculos);
                                                enviarCotizacion(cotiza, usuarios, usercliente);
                                                break;                    
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            break;
                                        }                                        
                                    }    
                                }else if(op.equals("3")){

                                }else if(op.equals("4")){
                                    break;
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }
                        }else{
                            while(!op.equals("3")){
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Salir\nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){                                    
                                    usercliente.consultarStock(vehiculos);                                       
                                }else if(op.equals("2")){
                                    String indvehiculo = "";
                                    while(!indvehiculo.equals("s")){                                        
                                        System.out.print("\nElija un numero de la lista de vehiculos o escriba (s) para salir: ");
                                        indvehiculo = entrada.nextLine();                                        
                                        if(isNumeric(indvehiculo)){
                                            int ind = Integer.parseInt(indvehiculo);
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                enviarCotizacion(vhcotiza, usuarios, usercliente);  
                                                break;                                                                 
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            break;
                                        }else{
                                            System.out.println("\nElija una opción correcta");
                                        }                                      
                                    }
                                }else if(op.equals("3")){
                                    break;
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }
                        }                                                                        
                    }       
                    break;

                case "2":
                    System.out.println("************Vendedor************");
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

                        while(!op.equals("3")){
                            System.out.print("\n1. Consultar Stock\n2. Solicitudes de cotizacion\n3. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            
                            if(op.equals("1")){   
                                System.out.println();
                                uservendedor.consultarStock(vehiculos); 

                            }else if(op.equals("2")){
                                if(uservendedor.getCotizaciones().size()>0){                                  
                                    uservendedor.mostrarCotizaciones();                                                                     
                                }else{
                                    System.out.println("Por ahora, no tiene cotizaciones solicitadas");
                                }
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
                        System.out.println(vh.mostrarDatos());
                    }
                    break;              
                case "k":
                    for(Usuario t: usuarios){
                        if(t instanceof Cliente){
                            Cliente cd = (Cliente) t;
                            cd.setCedula("AVER");
                        }
                    }

                    Cliente ddf = (Cliente) usuarios.get(0);
                    ddf.setCedula("NUEVO");

                    break;
                case "l":                    
                    for(Usuario a:usuarios){
                        System.out.println(a.mostrarDatos());            
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

    private static int validarUsuario(Usuario us, String tipo){       
        return 0;
    }

    private static void enviarCotizacion(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        Random rnd = new Random();            
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Vendedor")){                                
                Vendedor uservendedor = (Vendedor) arrayusuarios.get(indice);
                uservendedor.agregarCotizacion(vh, cl);
                vh.setDisponible(Estado.Solicitado);
                //uservendedor.getVehiculos().add(vh); PUEDES USAR ESTO SIN NECESIDAD DEL METODO AGREGARVEHICULO                          
                verificar = true;
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
                    System.out.print("Usuario: ");
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
        usuarios.add(new Cliente(null, null, "ca", "ca", null, null, 0));
        usuarios.add(new Vendedor(null, null, "ta", "ta", 0));        
        vehiculos.add(new Tractor("ASDFADF", null, 0, false, null, 0));
        vehiculos.add(new Vehiculo("SDAF", "ADS", 0, null, 0, 0));
    }
}