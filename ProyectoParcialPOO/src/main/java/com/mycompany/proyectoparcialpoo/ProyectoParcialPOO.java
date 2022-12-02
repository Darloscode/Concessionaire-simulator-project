package com.mycompany.proyectoparcialpoo;

import com.mycompany.proyectoparcialpoo.model.usuarios.*;
import com.mycompany.proyectoparcialpoo.model.vehiculos.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aaron Macias Catagua
 * @author Cristhian Rodriguez Villegas
 * @author Carlos Flores Gonzalez
 */

public class ProyectoParcialPOO {
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        inicializarSistema();     

        boolean salir = false;
        boolean exit;

        int user = -1;

        String opcion, usuario, password, tipo, op;
        

        while(!salir){
            System.out.println("\n************************************************");   
            System.out.println("------------------Bienvenido------------------");
            System.out.println("1. Cliente ");
            System.out.println("2. Vendedor");
            System.out.println("3. Supervisor");
            System.out.println("4. Jefe de taller");
            System.out.println("5. Salir\n");
            
            System.out.print("Elija una opcion: ");
            opcion = entrada.nextLine();            
            System.out.println("************************************************\n");   
            
            switch(opcion){
                case "1":              
                    System.out.println("\n******************Cliente******************");
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
                        System.out.println("\n------------------------------------------------------");
                        System.out.println("Bienvenido Sr(a) "+usercliente.getTipo()+": "+usercliente.getNombre()+" "+usercliente.getApellido());
                        System.out.println("------------------------------------------------------\n");

                        usercliente.mostrarMensajes();

                        usercliente.mostrarCotizacionesAprobadas(usuarios, usercliente, vehiculos);                         
                        
                        System.out.println("\n-------------------------------------------------------------------\n");

                        if((usercliente.getVehiculos().size()!=0)){
                            exit = false;
                            op = "";
                            
                            while(!exit){                                
                                System.out.print("\n1. Consultar Stock\n2. Solicitar cotizacion\n3. Solicitar un mantenimiento\n4. Consultar mantenimiento\n5. Salir\n \nElija una opcion: ");
                                op = entrada.nextLine();
                                if(op.equals("1")){
                                    usercliente.consultarStock(vehiculos);
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
                    System.out.println("\n******************Vendedor******************");
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

                        System.out.println("\n------------------------------------------------------");
                        System.out.println("Bienvenido Sr(a) "+uservendedor.getTipo()+": "+uservendedor.getNombre()+" "+uservendedor.getApellido());
                        System.out.println("------------------------------------------------------\n");
                      
                        uservendedor.consultarCotizaciones();
                        System.out.println("\n-------------------------------------------------------------------\n");
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
                    System.out.println("\n******************Supervisor******************");
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
                        System.out.println("\n------------------------------------------------------");
                        System.out.println("Bienvenido Sr(a) "+usersupervisor.getTipo()+": "+usersupervisor.getNombre()+" "+usersupervisor.getApellido());
                        System.out.println("------------------------------------------------------\n");
                                         
                        usersupervisor.mostrarSolicitudes(usuarios, vehiculos);

                        System.out.println("\n-------------------------------------------------------------------\n");
                        exit = false;
                        while(!exit){
                            System.out.print("\n1. Consultar Stock\n2. Adminitrar ventas\n3. Salir\nElija una opcion: ");
                            op = entrada.nextLine();                            
                            if(op.equals("1")){                                
                                usersupervisor.consultarStock(vehiculos);
                            }else if(op.equals("2")){
                                usersupervisor.mostrarSolicitudes(usuarios, vehiculos);                               
                            }else if (op.equals("3")){
                                exit = true;
                            }else{
                                System.out.println("\nElija una opcion valida\n");
                            }
                        }                                                                                                                     
                    }                                                                                                                         
                    break;

                case "4":
                    System.out.println("\n******************Jefe de Taller******************");
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
                        System.out.println("\n------------------------------------------------------");
                        System.out.println("Bienvenido Sr(a) "+userjefetaller.getTipo()+": "+userjefetaller.getNombre()+" "+userjefetaller.getApellido());
                        System.out.println("------------------------------------------------------\n");

                        userjefetaller.verificarSolicitudes();
                        userjefetaller.verificarEntregas();

                        exit = false;
                        while(!exit){
                            System.out.println("\n-------------------------------------------------------------------\n");

                            System.out.print("\n1. Mostrar entregas de vehiculos\n2. Admitir vehiculos a mantenimiento\n3. Administrar vehiculos en mantenimiento\n4. Consultar cantidad de vehiculos en REPARACION\n5. Salir\nElija una opcion: ");
                            op = entrada.nextLine();

                            if (op.equals("1")){
                                userjefetaller.mostrarEntregas(vehiculos);
                            }else if(op.equals("2")){
                                userjefetaller.admitirVehiculos(); 
                            }else if(op.equals("3")){
                                userjefetaller.administrarVehiculos();
                            }else if(op.equals("4")){
                                userjefetaller.consultarReparacion(usuarios);
                            }else if(op.equals("5")){
                                exit = true;
                            }else{
                                System.out.println("\nEscoja una opcion correcta\n");
                            }                            
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

    //Método que realiza una validación para verificar si los datos propocionados son los correcto
    //y tambien si el tipo de usuario correcto a las credenciales ingresadas
    private static int login(String user, String password, String tipo){        
        Scanner rd = new Scanner(System.in);        
        int verificar=verificarLogin(user, password, tipo, usuarios);
        
        if(verificar != -1){
            System.out.println("\n------------------------------");
            System.out.println("*Has iniciado sección*");
            System.out.println("------------------------------\n");
            return verificar;
        }else{
            while(verificar == -1){
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
                        System.out.println("\n------------------------------");
                        System.out.println("*Has iniciado sección*");
                        System.out.println("------------------------------\n");
                        return verificar;
                    }
                }else if(op.equals("2")){
                    return -1;
                }else{
                    System.out.println("\nElija una opción correcta");
                }
            }
        }
        return -1;
    }

    //Método que retornará el indice del usuario que desea iniciar sesión
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
        //El programa asigna de forma aleatoria un vendedor, supervisor y jefe de taller cuando 
        //se realiza una cotización, una compra o entrega de vehiculo, por ende se ha comentado algunos
        //usuarios para mayor facilidad de sustentación, cabe recalcar que agregar mas usuarios no afecta
        //el funcionamiento del programa.
        
        //Clientes
        usuarios.add(new Cliente("Marcos", "Rodriguez", "mar", "mar", "0123456789", "Administrador de empresas", 980));
        usuarios.add(new Cliente("Jose", "Solis", "jos", "jos", "0987654321", "Jefe de tienda", 1400));        
        //usuarios.add(new Cliente("Maria", "Michilena", "mar", "mar", "0875384927", "Abogado", 800));
        //usuarios.add(new Cliente("Daniel", "Lopez", "dan", "dan", "093716542", "Doctor", 1200));
        //usuarios.add(new Cliente("Benjamin", "Veliz", "ben", "ben", "024718276", "Enfermero", 900));

        //Vendedores
        usuarios.add(new Vendedor("Alejandro", "Muñoz", "ale", "ale", "850584"));
        //usuarios.add(new Vendedor("Manuel", "Guaman", "man", "man", "843324"));
        //usuarios.add(new Vendedor("Roberto", "Hulloa", "rob", "rob", "858912"));
        //usuarios.add(new Vendedor("Sebastian", "Figueroa", "seb", "seb", "889283"));

        //Jefes de talleres    
        ArrayList<String> certificacionestecnicas = new ArrayList<>();    
        certificacionestecnicas.add("Diplomado en hidráulica");
        certificacionestecnicas.add("Certificado en Seguridad Industrial");
        certificacionestecnicas.add("Certificado en Seguro Vehicular");
        certificacionestecnicas.add("Certificado en Capacitacion Tecnica Vehicular");       

        usuarios.add(new JefedeTaller("Aaron", "Macias", "aar", "aar", certificacionestecnicas));
        //usuarios.add(new JefedeTaller("Cristhian", "Rodriguez", "cri", "cri", certificacionestecnicas));
        //usuarios.add(new JefedeTaller("Carlos", "Flores", "car", "car", certificacionestecnicas));

        //Supervisores
        ArrayList<String> certificacionesacademicas = new ArrayList<>();
        certificacionesacademicas.add("Maestría en Administración de Empresas");
        certificacionesacademicas.add("Diplomado en Contaduría Pública");
        certificacionesacademicas.add("Certificado en Marketing");

        usuarios.add(new Supervisor("Genesis", "Michelina", "gen", "gen", certificacionesacademicas));
        //usuarios.add(new Supervisor("Gerald", "Salazar", "gel", "gel", certificacionesacademicas));        


        //Vehiculos
        vehiculos.add(new Automovil("Chevrolet", "Familiar", 2012, Motor.Gasolina, 4, false, true, 9400.00));
        vehiculos.add(new Automovil("Suzuki", "DRE1", 2016, Motor.Diesel, 4, true, false, 1230.00));
        vehiculos.add(new Automovil("Chevrolet", "Familiar-Grande", 2019, Motor.Gasolina, 6, false, true, 2331.00));
        vehiculos.add(new Tractor("Ebro", "TE52", 2010, false, Transmision.Hidraulica,23313.00));
        vehiculos.add(new Tractor("Kubota", "TE32", 2019, true, Transmision.Hidraulica,2331.00));
        vehiculos.add(new Tractor("Class", "TF22", 2003, false, Transmision.Mecanica, 32222.00));
        vehiculos.add(new Camion("Iveco", "E31", 2000, Motor.Gasolina, 4, 233.12, 8910.00));
        vehiculos.add(new Camion("Mercedez", "F91", 2009, Motor.Diesel, 8, 231.56, 3445.00));
        vehiculos.add(new Camion("Peterbilt", "G51", 2007, Motor.Diesel, 8, 120.23, 1345.00));
        vehiculos.add(new Motocicleta("Harley Davidson", "H4", 2019, Motor.Diesel, Categoria.Todo_Terreno, 231.00));
        vehiculos.add(new Motocicleta("Suzuki", "B5", 2003, Motor.Gasolina, Categoria.Scotter, 700.00));
        vehiculos.add(new Motocicleta("Kawasaki", "A7", 2010, Motor.Gasolina, Categoria.Deportiva, 690.00));
        
    }                                    
}
