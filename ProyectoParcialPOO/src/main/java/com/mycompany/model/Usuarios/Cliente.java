package com.mycompany.model.Usuarios;

import java.util.random.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mycompany.model.Vehiculos.Estado;
import com.mycompany.model.Vehiculos.Mantenimiento;
import com.mycompany.model.Vehiculos.Vehiculo;

public class Cliente extends Usuario{ 

    private String tipo = "Cliente";
    private String cedula;
    private String ocupacion;
    private double ingresos;    
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public ArrayList<String> mensajes = new ArrayList<>();
    private ArrayList<Vehiculo> cotizaciones = new ArrayList<>();
    
    public Cliente(String nombre, String apellido, String usuario, String password, String cedula, String ocupacion, double ingresos){
        super(nombre, apellido,usuario, password);        
        this.cedula =cedula;
        this.ingresos = ingresos;
        this.ocupacion = ocupacion;                        
    }

    @Override
    public String mostrarDatos(){
        return "Usuario:\n " +tipo+super.mostrarDatos()+"\nCedula: "+cedula+"\nOcupacion: "+ocupacion+"\nIngresos: "+ingresos;
    }
       

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public String getTipo(){
        return tipo;
    }

    public void setCedula(String cedula){
        this.cedula = cedula; 
    }

   
    
     public ArrayList<String> getMensajes(){
        return mensajes;
    }

 
    public ArrayList<Vehiculo> getCotizaciones(){
        return cotizaciones;
    }

    public void cotizacionesAprobadas(Vehiculo vh){
        cotizaciones.add(vh);
    }
    
     public void agregarMensaje(String mensaje){
        mensajes.add(mensaje);
    }

    public void agregarCompra (Vehiculo vh){  // agrega el vehiculo con las carateristicas de la solicitud de compra aceptada a la lista
        vehiculos.add(vh);
    }
    
    
     public void consultarStock(ArrayList<Vehiculo> vehiculos){
        int i = 1;
        System.out.println();
        for(Vehiculo vh : vehiculos){
            if(vh.getDisponibilidad().equals(Estado.Disponible)){
                System.out.println(i+". Marca: "+vh.getMarca()+", Modelo: "+vh.getModelo()+", Año: "+vh.getYear());
            }
            i++;
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
                //uservendedor.getVehiculos().add(vh); PUEDES USAR ESTO SIN NECESIDAD DEL METODO AGREGARVEHICULO                          
                verificar = true;
            }         
        }
    }

    public void enviarCompra(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){   // envia desde el main la compra hacia l supervisor
        for(Usuario us : arrayusuarios){
            if(us.getTipo().equals("Supervisor")){
                Supervisor spvisor = (Supervisor) us;                
                spvisor.agregarSolicitud(vh, cl);
            }
        }
    }

    public void enviarMantenimiento(Vehiculo vh, ArrayList<Usuario> arrayusuarios, Cliente cl){
        for(Usuario us : arrayusuarios){
            if(us instanceof JefedeTaller){
                JefedeTaller jft = (JefedeTaller) us;
                jft.agregarMantenimientos(vh, cl);
            }
        }
    }

    public Vehiculo solicitarCotizacion(int indice, ArrayList<Vehiculo> arreglo){        
        return arreglo.get(indice-1);
    }
    
    public Vehiculo solicitarCompra(Vehiculo vh, ArrayList<Vehiculo> arreglo){
        int indice = arreglo.indexOf(vh);
        return arreglo.get(indice);
    }
    
    
    public void mostrarMensajes(){
        Scanner rd = new Scanner(System.in);
        if(mensajes.size()>0){                            
            System.out.println("\nTiene mensajes por leer\n");                                                    
            for(int i = 0; i<mensajes.size(); i++){
                System.out.println((i+1)+". "+mensajes.get(i));
                String continuar = "";
                while(!(continuar.equals("c"))){
                    System.out.print("\nEscriba (c) para continuar y eliminar mensaje: ");
                    continuar = rd.nextLine();                                                                        
                    if(continuar.equals("c")){
                        mensajes.remove(i);                                                               
                    }else{
                        System.out.println("\nEscriba la letra correcta\n");
                    }
                }
                System.out.println();                                                                     
            } 
        }else{
            System.out.println("\nNo tiene notificaciones en su bandeja de entrada\n");
        }        
    }

    public void mostrarCotizacionesAprobadas(ArrayList<Usuario> usuarios, Cliente usercliente){
        Scanner rd = new Scanner(System.in);       

        if(cotizaciones.size()>0){                      
            String op = "";
            boolean salir;

            System.out.println("\nTiene cotizaciones aprobadas\n");   
            
            for(int i = 0; i<cotizaciones.size(); i++){

                System.out.println((i+1)+". Especificaciones del vehiculo:");
                System.out.println(cotizaciones.get(i).mostrarDatos());
                op = "";   
                salir = false;                             
                while(!salir){
                    System.out.print("¿Quiere comprar el vehiculo?\n1. Si\n2. No\n3. Salir\nElija una opcion: ");
                    op = rd.nextLine();
                    switch(op){
                        case "1":
                            System.out.println("todo bien");
                            salir = true;
                            break;
    
                        case "2":
                            cotizaciones.remove(i);
                            salir = true;
                            break;

                        case "3":
                            System.out.println("Saliendo....");
                            salir = true;
                            break;

                        default:
                            System.out.println("\nIngrese una opción valida\n");
                    }
                }                                            
            }
                /*
                int i = 1;
                System.out.println();
                for(Vehiculo vh : cotizaciones){
                    System.out.println(i+". "+vh.toString());
                    i++;
                }
                System.out.print("\nElija el vehiculo que quiere comprar, para salir escriba (s): ");
                indi = rd.nextLine();
                if(isNumeric(indi)){
                    int indicoti = Integer.parseInt(indi);
                    if((indicoti>0)&(indicoti<=cotizaciones.size())){                                                                                                                                                                                                        
                        Vehiculo compra = solicitarCompra(cotizaciones.get(indicoti-1), vehiculos);
                        usercliente.enviarCompra(compra, usuarios, usercliente);
                        System.out.println("\nSu solicitud de compra ha sido enviada\n");

                    }else{
                        System.out.println("\nElija un vehiculo de la lista\n");
                    }                                    
                }else if(op.equals("s")){
                    break;
                    
                }else{
                    System.out.println("\nElija una opcion correcta\n");
                }
            }
             */
            
            /*
            String indi = "";
            System.out.println("\nTiene cotizaciones aprobadas");
            while(!indi.equals("s")){
                int i = 1;
                System.out.println();
                for(Vehiculo vh : cotizaciones){
                    System.out.println(i+". "+vh.toString());
                    i++;
                }
                System.out.print("\nElija el vehiculo que quiere comprar, para salir escriba (s): ");
                indi = rd.nextLine();
                if(isNumeric(indi)){
                    int indicoti = Integer.parseInt(indi);
                    if((indicoti>0)&(indicoti<=cotizaciones.size())){                                                                                                                                                                                                        
                        Vehiculo compra = solicitarCompra(cotizaciones.get(indicoti-1), vehiculos);
                        usercliente.enviarCompra(compra, usuarios, usercliente);
                        System.out.println("\nSu solicitud de compra ha sido enviada\n");

                    }else{
                        System.out.println("\nElija un vehiculo de la lista\n");
                    }                                    
                }else if(op.equals("s")){
                    break;
                    
                }else{
                    System.out.println("\nElija una opcion correcta\n");
                }
            }
             */
            
        }else{
            System.out.println("\nNo tiene mensaje de cotizaciones\n");
        } 
    }

    /*
    public void solicitarMantenimiento(Cliente usercliente, int indice, ArrayList<Usuario> usuarios){
        Scanner rd = new Scanner(System.in);
        String mant = "";
        while(!mant.equals("3")){
            System.out.print("\n1. Solicitar mantenimiento preventivo\n2. Solicitar mantenimiento de emergencia\n3. Salir\nElija una opcion: ");
            mant = rd.nextLine();
            if(mant.equals("1")){
                boolean exit = true;
                while(exit){
                    System.out.print("\nIngrese los km recorridos del vehiculo(cada km costara 10 centavos): ");
                    String km = rd.nextLine();
                    if(isNumeric(km)){
                        int ikm = Integer.parseInt(km);
                        double total = ikm*0.10;
                        System.out.println("\nEl valor a pagar por mantenimiento preventido es de: $"+total);
                        String ext = "";
                        while(!(ext.equals("2"))){
                            System.out.print("\n1. Aceptar\n2. Salir\nElija una opcion: ");
                            ext = rd.nextLine();
                            if(ext.equals("1")){
                                System.out.println("\nSu solicitud esta siendo enviada....");
                                Vehiculo vh = usercliente.getVehiculos().get(indice-1);
                                vh.setMantenimiento(Mantenimiento.Preventivo);
                                usercliente.enviarMantenimiento(vh, usuarios, usercliente);
                                System.out.println("\nSolicitud ha sido envida con exito!!");                                                                            
                                exit = false;                                                                            
                                break;                                                                                                                                                    
                            }else if(ext.equals("2")){                                                                            
                                System.out.println("\nHa cancelado la solicitud\n");                                                                            
                                exit = false;                                                                        
                            }else{                                                                            
                                System.out.println("\nElija una opcion correcta\n");                                                                    
                            }                                                                
                        }                                                            
                    }else{                                                                    
                        System.out.println("\nIngrese los km correctos\n");                                                                                      
                    }                                                                                                                                        
                }                                                                                                                                        
            }else if(mant.equals("2")){
                System.out.println("El costo del mantenimiento lo validará el jefe de taller, le llegará el costo a su bandeja de mensajes");
                Vehiculo vh = usercliente.getVehiculos().get(indice-1);
                vh.setMantenimiento(Mantenimiento.Emergencia);
                usercliente.enviarMantenimiento(vh, usuarios, usercliente);                
            }else if(mant.equals("3")){                
                
            }else{
                System.out.println("Elija una opcion correcta");
            }   
        }
    }
    */

    public void solicitarMantenimiento(Cliente usercliente, int indice, ArrayList<Usuario> usuarios){
        Scanner rd = new Scanner(System.in);
        String mant = "";
        while(!mant.equals("3")){
            System.out.print("\n1. Solicitar mantenimiento preventivo\n2. Solicitar mantenimiento de emergencia\n3. Salir\nElija una opcion: ");
            mant = rd.nextLine();
            if(mant.equals("1")){
                boolean exit = true;
                while(exit){
                    System.out.print("\nIngrese los km recorridos del vehiculo(cada km costara 10 centavos): ");
                    String km = rd.nextLine();
                    if(isNumeric(km)){
                        int ikm = Integer.parseInt(km);
                        double total = ikm*0.10;
                        System.out.println("\nEl valor a pagar por mantenimiento preventido es de: $"+total);
                        String ext = "";
                        while(!(ext.equals("2"))){
                            System.out.print("\n1. Aceptar\n2. Salir\nElija una opcion: ");
                            ext = rd.nextLine();
                            if(ext.equals("1")){
                                System.out.println("\nSu solicitud esta siendo enviada....");
                                Vehiculo vh = usercliente.getVehiculos().get(indice-1);
                                vh.setMantenimiento(Mantenimiento.Preventivo);
                                usercliente.enviarMantenimiento(vh, usuarios, usercliente);
                                System.out.println("\nSolicitud ha sido envida con exito!!");                                                                            
                                exit = false;                                                                            
                                break;                                                                                                                                                    
                            }else if(ext.equals("2")){                                                                            
                                System.out.println("\nHa cancelado la solicitud\n");                                                                            
                                exit = false;                                                                        
                            }else{                                                                            
                                System.out.println("\nElija una opcion correcta\n");                                                                    
                            }                                                                
                        }                                                            
                    }else{                                                                    
                        System.out.println("\nIngrese los km correctos\n");                                                                                      
                    }                                                                                                                                        
                }                                                                                                                                        
            }else if(mant.equals("2")){
                System.out.println("El costo del mantenimiento lo validará el jefe de taller, le llegará el costo a su bandeja de mensajes");
                Vehiculo vh = usercliente.getVehiculos().get(indice-1);
                vh.setMantenimiento(Mantenimiento.Emergencia);
                usercliente.enviarMantenimiento(vh, usuarios, usercliente);                
            }else if(mant.equals("3")){                
                
            }else{
                System.out.println("Elija una opcion correcta");
            }   
        }
    }
    
    public void consultarMantenimiento(){
        Scanner rd = new Scanner(System.in);
        ArrayList<Vehiculo> mantenimiento = new ArrayList<>();
        for(Vehiculo vh : vehiculos){
            if(vh.getMantenimiento()!=Mantenimiento.Ninguno){
                mantenimiento.add(vh);
            }
        }

        if(mantenimiento.size()>0){            
            String opc = "";
            while(!opc.equals("s")){
                System.out.println("\nSus vehiculos en mantenimiento son:\n");
                for(int i=0; i<mantenimiento.size(); i++){                
                    System.out.println((i+1)+mantenimiento.get(i).toString());                         
                }
                System.out.print("Elija un vehiculo para consultar mantenimiento: ");
                opc = rd.nextLine();
                if(isNumeric(opc)){
                    int indice = Integer.parseInt(opc);
                    if((indice>0) & (indice<=mantenimiento.size())){                    
                        System.out.println("Su vehiculo esta en mantenimiento "+vehiculos.get(indice-1).getMantenimiento()+" y se encuentra "+vehiculos.get(indice-1).getEstadoMantenimiento());                
                    }else{
                        System.out.println("\nElija una opcion de la lista\n");
                    }
                }else{
                    System.out.println("\nElija una opcion correcta\n");
                }
            }
        }else{
            System.out.println("\nNo tiene vehiculos en mantenimiento\n");
        }        
    }
    
   
    

    /*
    public String getCategoria() {
        return Categoria;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public double getIngresos() {
        return Ingresos;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setOcupacion(String Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public void setIngresos(int Ingresos) {
        this.Ingresos = Ingresos;
    }
    */
    
    
}
