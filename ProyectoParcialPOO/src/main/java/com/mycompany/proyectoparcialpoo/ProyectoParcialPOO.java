package com.mycompany.proyectoparcialpoo;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import com.mycompany.model.Usuarios.*;
import com.mycompany.model.Vehiculos.*;

public class ProyectoParcialPOO {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        boolean salir = false;

        Usuario user = null;

        String opcion = "", usuario, password, tipo = "", op ="";

        boolean cotizar=false;

        ArrayList<Vehiculo> vehiculos = cargarVehiculos();
        ArrayList<Usuario> usuarios = inicializarSistema();

        /*
        ArrayList<Usuario> usuarios = inicializarSistema();
        for(Usuario a:usuarios){
            System.out.println(a.mostrarDatos());
            System.out.println(a.getTipo());
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

                    if(user != null){
                        Cliente usercliente = (Cliente) user;  
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
                                    String indvehiculo = "1";
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

                    if(user != null){                        
                        Vendedor uservendedor = (Vendedor) user;
                        if((uservendedor.getCotizaciones().size())>0){
                            System.out.println(uservendedor.getCotizaciones().size());
                        }
                        
                        
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

    private static void enviarCotizacion(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        Random rnd = new Random();            
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Vendedor")){                                
                Vendedor uservendedor = (Vendedor) arrayusuarios.get(indice);
                uservendedor.agregarCotizacion(vh, cl);
                //uservendedor.getVehiculos().add(vh); PUEDES USAR ESTO SIN NECESIDAD DEL METODO AGREGARVEHICULO                          
                verificar = true;
            }         
        }
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private static Usuario login(String user, String password, String tipo){
        ArrayList<Usuario> usuarios = inicializarSistema();
        Scanner rd = new Scanner(System.in);
        String op="";
        Usuario verificar=verificarLogin(user, password, tipo, usuarios);
        
        if(!(verificar == null)){
            System.out.println("\nHas iniciado sección\n");
            return verificar;
        }else{
            while((verificar == null)){
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

                    if(!(verificar == null)){
                        System.out.println("\nHas iniciado sección\n");
                        return verificar;
                    }
                }else if(op.equals("2")){
                    return null;
                }else{
                    System.out.println("Elija una opción correcta");
                }
            }
        }
        return null;
    }

    private static Usuario verificarLogin(String user, String passw, String tipo, ArrayList<Usuario> usuarios){
        for(Usuario u : usuarios){
            if((u.getUsuario().equals(user)) & (u.getPassword().equals(passw)) & (u.getTipo().equals(tipo))){                        
                return u;
            }
        }
        System.out.println("\nCredenciales Incorrectas\n");
        return null;
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
                }else if(datos[0].equals("Vendedor")){                    
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
}