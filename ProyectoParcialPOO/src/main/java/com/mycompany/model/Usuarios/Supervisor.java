package com.mycompany.model.Usuarios;

import com.mycompany.model.Vehiculos.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Supervisor extends Usuario{

    private String tipo = "Supervisor";
    private ArrayList<Vehiculo> solicitudes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();    
    private ArrayList<String> certificacionesacademicas = new ArrayList<>();   
    
    //Constructor
    public Supervisor(String nombre, String apellido, String usuario, String password, ArrayList<String> crtacademicas){
        super(nombre, apellido,usuario, password);         
        this.certificacionesacademicas = crtacademicas;
    }

    //Método para mostar informacion del supervisor
    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }    

    //Métodos getters
    public String getTipo(){
        return tipo;
    }
    
    public ArrayList<Vehiculo> getSolicitudes() {
        return solicitudes;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public ArrayList<String> getCertificacionesAcademicas(){
        return certificacionesacademicas;
    }
         
    //Métodos en uso
    public void agregarSolicitud(Vehiculo vh, Cliente cl){  // agrega las solicitudes que son enviadas desde clientes en el metodo  compra                                                             
        solicitudes.add(vh);
        clientes.add(cl);
    }

    public void consultarStock(ArrayList<Vehiculo> vehiculos){    
        System.out.println("\n*************************************");            
        for(Vehiculo vh : vehiculos){            
            System.out.println(vh.mostrarDatos());
            System.out.println();
        }
        System.out.println("*************************************");
    }
 
    public void mostrarSolicitudes(ArrayList<Usuario> usuarios, ArrayList<Vehiculo> vehiculos){       
        Scanner sc = new Scanner ( System.in);

        String op= "";
        String opc= "";
        boolean salir = false;
        boolean exit = false;

        if(solicitudes.size()>0){

            while(!salir){
                System.out.println();
                for(int i=0 ; i<solicitudes.size(); i++){
                    System.out.println((i+1)+ ". El cliente "+clientes.get(i).getNombre()+" ha solicitado comprar el siguiente vehiculo");
                    System.out.println("   "+solicitudes.get(i)+"\n");
                }
                System.out.print("\nElija una solicitud para responder o escriba (s) para salir: ");
                op = sc.nextLine();
                if(isNumeric(op)){
                    int indice = Integer.parseInt(op);            
                    if((indice>0)&(indice<=solicitudes.size())){
                        exit = false;
                        while(!exit){
                            System.out.println("\n¿Aprobar o Rechazar la solicitud?");
                            System.out.print("\n1. Aprobar\n2. Rechazar\n3. Salir\nElija una opcion: ");
                            opc = sc.nextLine();
                            if(opc.equals("1")){
                                clientes.get(indice-1).agregarMensaje("Ha comprado el vehiculo: "+"\n"+solicitudes.get(indice-1).toString()+"\nPor favor, acerquese al taller para retirarlo");
                                System.out.println("\nLe llegará un mensaje al cliente de su compra");
                                System.out.println("\nSe enviará la aprobación de entrega al jefe de taller");
                                int i = vehiculos.indexOf(solicitudes.get(indice-1));
                                vehiculos.get(i).setDisponibilidad(Estado.Solicitado);                                
                                enviarVehiculo(usuarios, solicitudes.get(indice-1), clientes.get(indice-1));                                
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);
                                exit = true;
                                salir = true;
                            }else if(opc.equals("2")){
                                System.out.println("\nEstimado supervisor " + getNombre() +", escriba los motivos del rechazo de solicitud de la compra");
                                System.out.print("\nRespuesta: ");
                                String respuesta = sc.nextLine();                                
                                String mensaje = "Estimado cliente "+clientes.get(indice-1).getNombre()+" la solicitud de compra del vehiculo de la marca "+solicitudes.get(indice-1).getMarca()+" y modelo "+solicitudes.get(indice-1).getModelo()+" ha sido rechazada debido a que: ";
                                clientes.get(indice-1).agregarMensaje(mensaje+respuesta);
                                System.out.println("\nEl mensaje se enviado al comprador"); 
                                if(vehiculos.contains(solicitudes.get(indice-1))){
                                    int indi = vehiculos.indexOf(solicitudes.get(indice-1));
                                    vehiculos.get(indi).setDisponibilidad(Estado.Disponible);
                                }
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);
                                exit = true;
                            }else if(op.equals("3")){
                                exit = true;
                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }
                    }else{
                        System.out.println("\nElija una opción de la lista de solicitudes\n");
                    }
                }else if(op.equals("s")){
                    salir = true;
                }else{
                    System.out.println("\nElija un opcion correcta\n");
                }
            }
        }else{
            System.out.println("\nPor ahora no tiene solicitudes de compra\n");
        }                                
    }      
    public void enviarVehiculo(ArrayList<Usuario> arrayusuarios, Vehiculo vh, Cliente cl){
        Random rnd = new Random();
        boolean verificar = false;
        while(!verificar){
            int indice = rnd.nextInt(arrayusuarios.size());
            if(arrayusuarios.get(indice).getTipo().equals("Jefe de Taller")){
                JefedeTaller uservendedor = (JefedeTaller) arrayusuarios.get(indice);
                uservendedor.agregarEntregas(vh, cl);
                verificar = true;
            }         
        }
    }   
}
       
        
        
    

