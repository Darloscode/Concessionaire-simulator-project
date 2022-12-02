package com.mycompany.model.Usuarios;

import java.util.random.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mycompany.model.Vehiculos.Estado;
import com.mycompany.model.Vehiculos.EstadoMantenimiento;
import com.mycompany.model.Vehiculos.Mantenimiento;
import com.mycompany.model.Vehiculos.Vehiculo;


public class Cliente extends Usuario{ 

    private String tipo = "Cliente";
    private String cedula;
    private String ocupacion;
    private double ingresos;    
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<String> mensajes = new ArrayList<String>();
    private ArrayList<Vehiculo> cotizaciones = new ArrayList<>();
    

    //Constructor
    public Cliente(String nombre, String apellido, String usuario, String password, String cedula, String ocupacion, double ingresos){
        super(nombre, apellido,usuario, password);        
        this.cedula =cedula;
        this.ingresos = ingresos;
        this.ocupacion = ocupacion;                        
    }
               
    //Métodos getters
    public String getTipo(){
        return tipo;
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public ArrayList<String> getMensajes(){
        return mensajes;
    }
 
    public ArrayList<Vehiculo> getCotizaciones(){
        return cotizaciones;
    }


    //Métodos en uso
    public void mostrarMensajes(){
        Scanner rd = new Scanner(System.in);
        String continuar = "";

        if(mensajes.size()>0){                            
            System.out.println("\nTiene mensajes por leer\n");      
            int i = 1;
            for(String msj : mensajes){
                System.out.println(i+". "+msj);
                System.out.print("\nEscriba cualquier letra o numero para descartar: ");
                continuar = rd.nextLine();                
                i++;
                System.out.println();
            }
            mensajes.clear();
        }else{
            System.out.println("\nNo tiene notificaciones en su bandeja de entrada\n");
        }        
    }

    public void mostrarCotizacionesAprobadas(ArrayList<Usuario> usuarios, Cliente usercliente, ArrayList<Vehiculo> arreglovh){
        Scanner rd = new Scanner(System.in);       

        if(cotizaciones.size()>0){                      
            String op = "";
            boolean salir;

            System.out.println("\nTiene cotizaciones aprobadas\n");
            int i = 1;
            for(Vehiculo vh : cotizaciones){
                System.out.println("\n"+i+". Especificaciones del vehiculo:");
                System.out.println(vh.mostrarDatos());
              
          
                salir = false;
                while(!salir){
                    System.out.print("\n¿Quiere comprar el vehiculo?\n1. Si\n2. No\nElija una opcion: ");
                    op = rd.nextLine();
                    if(op.equals("1")){
                        Vehiculo compra = solicitarCompra(vh, arreglovh);
                        enviarCompra(compra, usuarios, usercliente);
                        System.out.println("\nSu solicitud de compra ha sido enviada\n");
                        salir = true;                                
                    }else if(op.equals("2")){
                        System.out.println("\nEl vehiculo sera eliminado de su lista de cotizaciones\n");                            
                        salir = true;
                    }else{
                        System.out.println("\nIngrese una opción valida\n");
                    }                    
                }
            }
            cotizaciones.clear();                               
        }else{
            System.out.println("\nNo tiene mensaje de cotizaciones\n");
        } 
    }

    public void solicitarCotizacion(ArrayList<Vehiculo> arreglo, ArrayList<Usuario> usuarios, Cliente usercliente){
        Scanner rd = new Scanner(System.in);
        String indcoti = "";
        boolean salir = false;
        
        System.out.println("\nVehiculos disponibles para cotizar");
        while(!salir){            
            consultarStock(arreglo);
            System.out.print("\nElija un numero del stock de vehiculos para cotizar o escriba (s) para salir: ");
            indcoti = rd.nextLine();
            if(isNumeric(indcoti)){
                int indicoti = Integer.parseInt(indcoti);
                if((indicoti>0) & (indicoti<=arreglo.size())){                                                    
                    Vehiculo vhcotiza = arreglo.get(indicoti-1);
                    enviarCotizacion(vhcotiza, usuarios, usercliente);
                    System.out.println("\nSu cotización ha sido enviada\n");
                    salir = true;
                }else{
                    System.out.println("\nElija un vehiculo de la lista\n");
                }
            }else if(indcoti.equals("s")){
                salir = true;                    
            }else{
                System.out.println("\nEscoja una opcion correcta\n");
            }                                      
        }           
    }
    
    public void consultarMantenimiento(){
        Scanner rd = new Scanner(System.in);
        ArrayList<Vehiculo> mantenimiento = new ArrayList<>();
        for(Vehiculo vh : vehiculos){
            if(vh.getEstadoMantenimiento()!=null){
                mantenimiento.add(vh);
            }
        }

        if(mantenimiento.size()>0){            
            String opc = "";
            boolean exit = false;

            while(!exit){
                System.out.println("\nSus vehiculos en mantenimiento son:\n");                
                for(int i=0; i<mantenimiento.size(); i++){
                    System.out.println((i+1)+". "+mantenimiento.get(i).toString());                         
                }
                System.out.print("\nElija un vehiculo para consultar mantenimiento o escriba (s) para salir: ");
                opc = rd.nextLine();
                if(isNumeric(opc)){
                    int indice = Integer.parseInt(opc);
                    if((indice>0) & (indice<=mantenimiento.size())){                    
                        System.out.println("\nSu vehiculo esta en mantenimiento "+vehiculos.get(indice-1).getMantenimiento()+" y se encuentra "+vehiculos.get(indice-1).getEstadoMantenimiento());                
                    }else{
                        System.out.println("\nElija una opcion de la lista\n");
                    }
                }else if(opc.equals("s")){
                    exit = true;
                }else{
                    System.out.println("\nElija una opcion correcta\n");
                }
            }
        }else{
            System.out.println("\nNo tiene vehiculos en mantenimiento admitidos\n");
        }        
    }

    public void solicitarMantenimiento(Cliente usercliente, ArrayList<Usuario> usuarios){
        Scanner rd = new Scanner(System.in);
        String opc = "";
        boolean exit = false;
        while(!exit){
            System.out.println("\nSus vehiculos son:\n");
            for(int i=0; i<vehiculos.size(); i++){
                System.out.println((i+1)+". "+vehiculos.get(i).toString());
            }
            System.out.print("\nElija un vehiculo para mandar a mantenimiento o escriba (s) para salir: ");
            opc = rd.nextLine();

            if(isNumeric(opc)){
                int indice = Integer.parseInt(opc);
                if((indice>0)&(indice<=vehiculos.size())){
                    if(vehiculos.get(indice-1).getMantenimiento()==Mantenimiento.Ninguno){                                                
                        String mant = "";
                        boolean salir = false;

                        while(!salir){                            
                            System.out.print("\n1. Solicitar mantenimiento preventivo\n2. Solicitar mantenimiento de emergencia\n3. Salir\nElija una opcion: ");
                            mant = rd.nextLine();
                            if(mant.equals("1")){
                                System.out.print("\nIngrese los km recorridos del vehiculo(cada km costara 10 centavos de dolar): ");
                                String km = rd.nextLine();
                                if(isNumeric(km)){
                                    int ikm = Integer.parseInt(km);
                                    double total = ikm*0.10;
                                    System.out.println("\nEl valor a pagar por mantenimiento preventido es de: $"+total);
                                    boolean ext = false;
                                    while(!ext){
                                        System.out.print("\n1. Aceptar\n2. Salir o Rechazar\nElija una opcion: ");
                                        String op = rd.nextLine();
                                        if(op.equals("1")){
                                            System.out.println("\nSu solicitud esta siendo enviada....");
                                            vehiculos.get(indice-1).setMantenimiento(Mantenimiento.Preventivo);
                                            Vehiculo vh = vehiculos.get(indice-1);                                            
                                            usercliente.enviarMantenimiento(vh, usuarios, usercliente);
                                            System.out.println("\nSolicitud ha sido envida con exito!!");
                                            salir = true;
                                            ext = true;
                                            exit = true;
                                        }else if(op.equals("2")){
                                            System.out.println("\nHa cancelado la solicitud\n");                                                                            
                                            ext = true;
                                        }else{                                                                            
                                            System.out.println("\nElija una opcion correcta\n");                                                                    
                                        }  
                                    }
                                }else{
                                    System.out.println("\nIngrese los km correctos\n");
                                }
                            }else if(mant.equals("2")){
                                System.out.println("\nEl costo del mantenimiento lo validará el jefe de taller, le llegará el costo a su bandeja de mensajes");
                                vehiculos.get(indice-1).setMantenimiento(Mantenimiento.Emergencia);
                                Vehiculo vh = vehiculos.get(indice-1);                
                                usercliente.enviarMantenimiento(vh, usuarios, usercliente);
                                System.out.println("\nSolicitud ha sido envida con exito!!");
                                salir = true;
                            }else if(mant.equals("3")){
                                salir = true;                              
                            }else{
                                System.out.println("Elija una opcion correcta");
                            }   
                        }
                    }else{
                        System.out.println("\nUsted ya ha solicitado mantenimiento a su vehiculo\n");
                    }                                               
                }else{
                    System.out.println("\nElija un numero de la lista de sus vehiculos\n");
                }                                           
            }else if(opc.equals("s")){
                exit = true;                
            }else{
                System.out.println("\nElija una opción correcta\n");
            }
        }  
    }

    public void enviarCotizacion(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        Random rnd = new Random();
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Vendedor")){                                
                Vendedor uservendedor = (Vendedor) arrayusuarios.get(indice);
                uservendedor.agregarCotizacion(vh, cl);                                
                verificar = true;
            }         
        }
    }

    public void consultarStock(ArrayList<Vehiculo> arreglovehiculos){
        System.out.print("\n*****************LISTA DE VEHICULOS*****************\n");        
        System.out.println();
        for(int i = 0; i<arreglovehiculos.size(); i++){
            if(arreglovehiculos.get(i).getDisponibilidad().equals(Estado.Disponible)){
                System.out.println((i+1)+". Marca: "+arreglovehiculos.get(i).getMarca()+", Modelo: "+arreglovehiculos.get(i).getModelo()+", Año: "+arreglovehiculos.get(i).getYear());                
            }
        }    
        System.out.print("\n*****************************************************\n");            
    }

    public void enviarCompra(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){   // envia desde el main la compra hacia l supervisor
        Random rnd = new Random();
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Supervisor")){                                
                Supervisor spvisor = (Supervisor)arrayusuarios.get(indice);
                spvisor.agregarSolicitud(vh, cl);                
                verificar = true;
            }         
        }        
    }

    public void enviarMantenimiento(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        Random rnd = new Random();
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Jefe de Taller")){                                
                JefedeTaller jdt = (JefedeTaller) arrayusuarios.get(indice);
                jdt.agregarMantenimientos(vh, cl);
                verificar = true;
            }         
        }        
    }

    public Vehiculo solicitarCompra(Vehiculo vh, ArrayList<Vehiculo> arreglo){
        int indice = arreglo.indexOf(vh);
        return arreglo.get(indice);
    }


    //Posible uso
    public void cotizacionesAprobadas(Vehiculo vh){
        cotizaciones.add(vh);
    }
    
    public void agregarMensaje(String mensaje){
        mensajes.add(mensaje);
    }

    public void agregarCompra (Vehiculo vh){  // agrega el vehiculo con las carateristicas de la solicitud de compra aceptada a la lista
        vh.setMantenimiento(Mantenimiento.Ninguno);
        vehiculos.add(vh);
    }
        
    //Método para mostrar información del vehiculo
    @Override
    public String mostrarDatos(){
        return "Usuario:\n " +tipo+super.mostrarDatos()+"\nCedula: "+cedula+"\nOcupacion: "+ocupacion+"\nIngresos: "+ingresos;
    }            
}
