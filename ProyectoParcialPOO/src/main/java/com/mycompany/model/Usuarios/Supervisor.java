package com.mycompany.model.Usuarios;

import com.mycompany.model.Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class Supervisor extends Usuario{

    private String tipo = "Supervisor";
    private ArrayList<Vehiculo> solicitudes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    private ArrayList<String> certificaciones= new ArrayList<>();   

    
    public Supervisor(String nombre, String apellido, String usuario, String password){
        super(nombre, apellido,usuario, password); 
        
    }

    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }

    public String getTipo(){
        return tipo;
    }
    

    public ArrayList<Vehiculo> getSolicitudes() {
        return solicitudes;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public ArrayList<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(ArrayList<String> certificaciones) {
        this.certificaciones = certificaciones;
    }
    
    
  
     public void agregarSolicitud(Vehiculo vh, Cliente cl){  // agrega las solicitudes que son enviadas desde clientes en 
                                                             // el metodo  compra
        solicitudes.add(vh);
        clientes.add(cl);
    }

    /*
    public void mostrarSolicitudes(ArrayList<Usuario> usuarios){         
        Scanner sc = new Scanner ( System.in);

        String op= "";
        String opc= "";

        while(!op.equals("s")){
            if(solicitudes.size()>0){ 
                
                for( int i=0 ; i<solicitudes.size(); i++){
                    System.out.println((i+1)+ ". El cliente "+clientes.get(i).getNombre()+" ha solicitado comprar un vehiculo de la marca "+ solicitudes.get(i).getMarca()+" y modelo "+solicitudes.get(i).getModelo());
                    System.out.println(clientes.get(i).mostrarDatos());
                }   

                System.out.print("\nElija una solicitud para responder o escriba (s) para salir: ");
                op = sc.nextLine();

                if(isNumeric(op)){
                    int indice = Integer.parseInt(op);            
                    if((indice>0)&(indice<=solicitudes.size())){
                        opc = "";
                        while(!(opc.equals("3"))){
                            System.out.println("\n¿Aprobar o Rechazar la solicitud?");
                            System.out.print("\n1. Aprobar\n2. Rechazar\n3. Salir\nElija una opcion: ");
                            opc = sc.nextLine();
                            if(opc.equals("1")){
                                clientes.get(indice-1).agregarCompra(solicitudes.get(indice-1));
                                clientes.get(indice-1).agregarMensaje("Ha comprado el vehiculo: "+"\n"+solicitudes.get(indice-1).toString()+"\nPor favor, acerquese al taller para retirarlo");
                                for(Usuario us : usuarios){
                                    if(us instanceof JefedeTaller){
                                        JefedeTaller jdt = (JefedeTaller) us;
                                        jdt.agregarEntregas(solicitudes.get(indice-1), clientes.get(indice-1));
                                    }
                                }
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);
                            }else if(opc.equals("2")){
                                System.out.println("\nEstimado " + getNombre() +", escriba los motivos del rechazo de solicitud de la compra");
                                System.out.print("\nRespuesta: ");
                                String respuesta = sc.nextLine();
                                String mensaje = "Estimado "+clientes.get(indice-1).getNombre()+" la solicitud de compra del vehiculo de la marca "+solicitudes.get(indice-1).getMarca()+" y modelo "+solicitudes.get(indice-1).getModelo()+" ha sido rechazada debido a que: ";
                                clientes.get(indice-1).agregarMensaje(mensaje+respuesta);
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);                                
                            }else if(op.equals("3")){

                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }    
                    }else{
                    System.out.println("\nElija una opción de la lista de solicitudes\n");
                    }                
                }else if(op.equals("s")){
                    break;
                }else{
                    System.out.println("Elija una opcion correcta");
                }
            }else{            
                break;
            }
        }  
    }  
    */

    public void mostrarSolicitudes(ArrayList<Usuario> usuarios, ArrayList<Vehiculo> vehiculos){
        Scanner sc = new Scanner ( System.in);

        String op= "";
        String opc= "";

        while(!op.equals("s")){
            if(solicitudes.size()>0){                
                for( int i=0 ; i<solicitudes.size(); i++){
                    System.out.println((i+1)+ ". El cliente "+clientes.get(i).getNombre()+" ha solicitado comprar un vehiculo de la marca "+ solicitudes.get(i).getMarca()+" y modelo "+solicitudes.get(i).getModelo());
                }

                System.out.print("\nElija una solicitud para responder o escriba (s) para salir: ");
                op = sc.nextLine();

                if(isNumeric(op)){
                    int indice = Integer.parseInt(op);            
                    if((indice>0)&(indice<=solicitudes.size())){
                        opc = "";
                        while(!(opc.equals("3"))){
                            System.out.println("\n¿Aprobar o Rechazar la solicitud?");
                            System.out.print("\n1. Aprobar\n2. Rechazar\n3. Salir\nElija una opcion: ");
                            opc = sc.nextLine();
                            if(opc.equals("1")){                                
                                clientes.get(indice-1).agregarMensaje("Ha comprado el vehiculo: "+"\n"+solicitudes.get(indice-1).toString()+"\nPor favor, acerquese al taller para retirarlo");
                                if(vehiculos.contains(solicitudes.get(indice-1))){
                                    int i = vehiculos.indexOf(solicitudes.get(indice-1));
                                    vehiculos.get(i).setDisponibilidad(Estado.Solicitado);
                                }
                                for(Usuario us : usuarios){
                                    if(us instanceof JefedeTaller){
                                        JefedeTaller jdt = (JefedeTaller) us;
                                        jdt.agregarEntregas(solicitudes.get(indice-1), clientes.get(indice-1));
                                    }
                                }
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);
                            }else if(opc.equals("2")){
                                System.out.println("\nEstimado " + getNombre() +", escriba los motivos del rechazo de solicitud de la compra");
                                System.out.print("\nRespuesta: ");
                                String respuesta = sc.nextLine();
                                String mensaje = "Estimado "+clientes.get(indice-1).getNombre()+" la solicitud de compra del vehiculo de la marca "+solicitudes.get(indice-1).getMarca()+" y modelo "+solicitudes.get(indice-1).getModelo()+" ha sido rechazada debido a que: ";
                                clientes.get(indice-1).agregarMensaje(mensaje+respuesta);
                                if(vehiculos.contains(solicitudes.get(indice-1))){
                                    int indi = vehiculos.indexOf(solicitudes.get(indice-1));
                                    vehiculos.get(indi).setDisponibilidad(Estado.Disponible);
                                }
                                solicitudes.remove(indice-1);
                                clientes.remove(indice-1);                                
                            }else if(op.equals("3")){

                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }    
                    }else{
                    System.out.println("\nElija una opción de la lista de solicitudes\n");
                    }                
                }else if(op.equals("s")){
                    break;
                }else{
                    System.out.println("Elija una opcion correcta");
                }
            }else{            
                break;
            }
        }  
    }  
    public void consultarStock(ArrayList<Vehiculo> vehiculos){                
        for(Vehiculo vh : vehiculos){            
            System.out.println(vh.mostrarDatos());
            System.out.println();
        }
    }
    
        
   
   
   
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    

    @Override
    public String toString() {
        return "Supervisor{" + "Certificaciones=" + certificaciones + '}';
    }
    
    
   
     
}
       
        
        
    

