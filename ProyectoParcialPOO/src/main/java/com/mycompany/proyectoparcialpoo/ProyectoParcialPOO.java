package com.mycompany.proyectoparcialpoo;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.SourceDataLine;

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
                        usercliente.agregarMensaje("PORUEEEEE");
                        usercliente.agregarMensaje("FASDFADFA");
                        usercliente.agregarMensaje("fasdasdfaF2323fafda");
                        usercliente.agregarMensaje("fasdfafda2331");
                        
                        //Quitar esto
                        usercliente.agregarCompra(new Automovil("Chevrolet", "Familiar", 2012, Motor.Gasolina, 4, true, false, 940));
                        usercliente.agregarCompra(new Motocicleta("Tuczoo", "Epica", 2008, Motor.Diesel, Categoria.Deportiva, 400));        

                        op = "";                        

                                                                       
                        usercliente.mostrarMensajes();

                        usercliente.mostrarCotizacionesAprobadas(usuarios, usercliente);                         
                        

                        if((usercliente.getVehiculos().size()!=0)){
                            op = "";
                            System.out.print("\nBienvenido Sr(a)"+" "+usercliente.getTipo()+": "+usercliente.getNombre()+" "+usercliente.getApellido()); // muestra los datos del cliente al iniciar el sistema
                            while(!op.equals("5")){
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Solicitar un mantenimiento\n4. Consultar mantenimiento\n5. Salir\n \nElija una opcion: ");
                                 op = entrada.nextLine();
                                if(op.equals("1")){
                                    String indvehiculo= "";
                                    System.out.print("************LISTA DE VEHICULOS************");
                                    usercliente.consultarStock(vehiculos);    // llama a la lista de vehiculos (STOCK)  
                                    /*
                                    System.out.print("\nElija un numero del stock de vehiculos o escriba (s) para salir: ");
                                    indvehiculo = entrada.nextLine(); 
                                    if(isNumeric(indvehiculo) ){    
                                            int ind = Integer.parseInt(indvehiculo);  
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviada\n");                                                                                                                
                                            }
                                           
                                            else{
                                                System.out.println("Elija un vehiculo de la lista");
                                            }
                                         }
                                    */
                                }
                                else if(op.equals("2")){
                                    String indvehiculo = "";                                                                                                                                                
                                    String indcoti = "";
                                    while(!indcoti.equals("s")){
                                        System.out.println("\nVehiculos disponibles para cotizar\n");
                                        usercliente.consultarStock(vehiculos);
                                        System.out.print("\nElija un numero del stock de vehiculos para cotizar o escriba (s) para salir: ");
                                        indcoti = entrada.nextLine();
                                        if(isNumeric(indcoti)){
                                            int indicoti = Integer.parseInt(indcoti);
                                            if((indicoti>0) & (indicoti<=vehiculos.size())){                                                    
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(indicoti, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviada\n");    
                                                break;                                                    
                                            }else{
                                                System.out.println("\nElija un vehiculo de la lista\n");
                                            }
                                        }else if(indcoti.equals("s")){
                                                
                                        }
                                        
                                        /*
                                        if(isNumeric(indvehiculo) && indvehiculo.equals("1")){
                                        usercliente.consultarStock(vehiculos); 
                                        System.out.print("\nElija un numero del stock de vehiculos o escriba (s) para salir: ");
                                        indcoti = entrada.nextLine(); // pide que ingrese el valor
                                           
                                               
                                            int ind = Integer.parseInt(indvehiculo);  
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviada Presione s para salir \n");                                                                                         
                                            }
                                           
                                            else{
                                                System.out.println("Elija un vehiculo de la lista");
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            
                                            
                                        }else if(indvehiculo.equals("2")){
                                            System.out.println("");
                                            System.out.println("Señor : "+usercliente.getNombre()+"  "+usercliente.getApellido()+"  "+"Por favor consulte primero el stock de vehiculo");
                                        }
                                        else{
                                            System.out.println("\nElija una opción correcta\n");
                                        }
                                         */
                                    }     
                                                                
                                }else if(op.equals("3")){
                                    String opc = "";
                                    while(!opc.equals("s")){                                        
                                        System.out.println("\nSus vehiculos son:\n");
                                        for(int i=0; i<usercliente.getVehiculos().size(); i++){
                                            System.out.println((i+1)+". "+usercliente.getVehiculos().get(i).toString());
                                        }
                                        System.out.print("\nElija una cotización para responder, escriba (s) para salir: ");
                                        opc = entrada.nextLine();    
                                        if(isNumeric(opc)){
                                            int indice = Integer.parseInt(opc);
                                            if((indice>0)&(indice<=usercliente.getVehiculos().size())){
                                                if(usercliente.getVehiculos().get(indice-1).getMantenimiento()==null){
                                                    usercliente.solicitarMantenimiento(usercliente, indice, usuarios);
                                                }else{
                                                    System.out.println("Su vehiculo ya ha sido adminitido en mantenimiento");
                                                }                                               
                                            } else{
                                                System.out.println("\nElija un numero de la lista de sus vehiculos\n");
                                            }                                           
                                        }else if(opc.equals("s")){
                                            
                                        }else{
                                            System.out.println("\nElija una opción correcta\n");
                                        }
                                    }
                                }else if(op.equals("4")){
                                    usercliente.consultarMantenimiento();
                                }else if(op.equals("5")){
                                                                
                                }else{
                                    System.out.println("\nEscoja una opcion correcta\n");
                                }
                            }
                        }else{
                            op = "";
                            while(!op.equals("3")){
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Salir\nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){                                    
                                    usercliente.consultarStock(vehiculos);                                       
                                }else if(op.equals("2")){
                                    String indvehiculo = "";
                                    while(!indvehiculo.equals("s")){
                                        System.out.println("\nSi no ha revisado el stock, le aconsejamos escribir s y elegir la opción 1");
                                        System.out.print("\nElija un numero del stock de vehiculos o escriba (s) para salir: ");
                                        indvehiculo = entrada.nextLine();                                        
                                        if(isNumeric(indvehiculo)){
                                            int ind = Integer.parseInt(indvehiculo);
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviado\n");                                                
                                            }else{
                                                System.out.println("Elija un vehiculo de la lista");
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            break;
                                        }else{
                                            System.out.println("\nElija una opción correcta\n");
                                        }                                      
                                    }
                                }else if(op.equals("3")){

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

                        while(!op.equals("3")){
                            System.out.print("\n1. Consultar Stock\n2. Solicitudes de cotizacion\n3. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            
                            if(op.equals("1")){   
                                System.out.println();
                                uservendedor.consultarStock(vehiculos); 

                            }else if(op.equals("2")){
                                if(uservendedor.getCotizaciones().size()>0){                               
                                    System.out.println();   
                                    uservendedor.mostrarCotizaciones();                                                                                                      
                                }else{
                                    System.out.println("\nPor ahora, no tiene cotizaciones solicitadas\n");
                                }
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

                        if(usersupervisor.getSolicitudes().size()>0){                           
                            usersupervisor.mostrarSolicitudes(usuarios, vehiculos);
                        }else{
                            System.out.println("\nPor ahora no tiene solicitudes de compra\n");
                        }

                        while(!op.equals("2")){
                            System.out.print("\n1. Consultar Stock\n2. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            if(op.equals("1")){
                                System.out.println();
                                usersupervisor.consultarStock(vehiculos);
                            }else if(op.equals("2")){

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
                        while(!op.equals("4")){
                            if(userjefetaller.getEntregarVehiculos().size()>0){
                                System.out.println("\nTiene vehiculos por entregar, escoja la opcion 1 para revisar la lista de entregas\n");    
                            }

                            System.out.print("\n1. Mostrar entregas\n2. Admitir vehiculos para mantenimiento\n3. Administrar mantenimiento\n4. Salir\nElija una opcion: ");
                            op = entrada.nextLine();

                            if (op.equals("1")){
                                userjefetaller.mostrarEntregas(vehiculos);
                            }else if(op.equals("2")){
                                userjefetaller.admitirVehiculos(); 
                            }else if(op.equals("3")){
                                userjefetaller.administrarVehiculos();
                            }else if(op.equals("4")){

                            }else{
                                System.out.println("\nEscoja una opcion correcta\n");
                            }

                            /*
                            if(userjfdetaller.getEntregarvehiculos().size()>0){
                               userjfdetaller.mostrarEntregas(vehiculos);
                            }
                            */
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
        usuarios.add(new Cliente("Marcos", "Veliz", "ca", "ca", "0123456789", "Administrador de empresas", 900));
        usuarios.add(new Vendedor("Alejandro", "Muñoz", "ta", "ta", 001));
        usuarios.add(new JefedeTaller("Jose", "Alvarez", "je", "je"));
        usuarios.add(new Supervisor("Michel", "Michelina", "mi", "mi"));        
        vehiculos.add(new Automovil("Chevrolet", "Familiar", 2012, Motor.Gasolina, 4, true, false, 940));        
        vehiculos.add(new Motocicleta("Tuczoo", "Epica", 2008, Motor.Diesel, Categoria.Deportiva, 400));
        usuarios.add(new Supervisor("juan","Maca", "ju","ju"));
        
    }          
}