package com.mycompany.model.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.model.Vehiculos.Vehiculo;


public class Vendedor extends Usuario{

    private String tipo = "Vendedor";
    private int id;
    private ArrayList<Vehiculo> cotizaciones = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    //Constructor
    public Vendedor(String nombre, String apellido, String usuario, String password, int id){
        super(nombre, apellido,usuario, password);
        this.id=id;
    }
    
    //Métodos getters
    public String getTipo(){
        return tipo;
    }

    public ArrayList<Vehiculo> getCotizaciones(){
        return cotizaciones;
    }
    
    //Métodos en uso
    public void consultarStock(ArrayList<Vehiculo> vehiculos){    
        System.out.println("\n*************************************");            
        for(Vehiculo vh : vehiculos){            
            System.out.println(vh.mostrarDatos());
            System.out.println();
        }
        System.out.println("*************************************");
    }

    public void mostrarCotizaciones(){
        Scanner rd = new Scanner(System.in);        

        String op = "";
        String opc = "";
        boolean salir = false;

        System.out.println();
        if(cotizaciones.size()>0){
            while(!salir){
                for(int i=0; i<cotizaciones.size(); i++){
                    System.out.println((i+1)+". "+clientes.get(i).getNombre()+" ha solicitado una cotazación del vehiculo del siguiente vehiculo: ");
                    System.out.println(cotizaciones.get(i).toString());                    
                }
                System.out.print("\nElija una cotización para responder, escriba (s) para salir: ");
                op = rd.nextLine();
                if(isNumeric(op)){
                    int indice = Integer.parseInt(op);
                    if((indice>0)&(indice<=cotizaciones.size())){
                        opc = "";
                        boolean exit = false;
                        while(!exit){
                            System.out.println("\n¿Aprobar o Rechazar la solicitud?");
                            System.out.print("1. Aprobar\n2. Rechazar\n3. Salir\nElija una opcion: ");
                            opc = rd.nextLine();
                            
                            if(opc.equals("1")){
                                clientes.get(indice-1).cotizacionesAprobadas(cotizaciones.get(indice-1));
                                cotizaciones.remove(indice-1);
                                clientes.remove(indice-1);
                                System.out.println("\nSe ha enviado la cotizacion al cliente");
                                salir = true;
                                exit = true;                                         
                            }else if(opc.equals("2")){
                                System.out.println("\nEstimado vendendor " + getNombre() +", escriba los motivos del rechazo de la solicitud");
                                System.out.print("\nRespuesta: ");
                                String respuesta = rd.nextLine();
                                String mensaje = "Estimado cliente "+clientes.get(indice-1).getNombre()+" su cotización del vehiculo "+cotizaciones.get(indice-1).getMarca()+" ha sido rechazada debido a que: ";
                                clientes.get(indice-1).agregarMensaje(mensaje+respuesta);                                
                                cotizaciones.remove(indice-1);
                                clientes.remove(indice-1);
                                System.out.println("\nSe ha enviado el mensaje al cliente");
                                salir = true;
                                exit = true;
                            }else if(opc.equals("3")){
                                salir = true;
                                exit = true;
                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }                        
                    }else{
                        System.out.println("\nElija una opción de la lista de cotizaciones\n");
                    }
                }else if(op.equals("s")){
                    salir = true;
                }else{
                    System.out.println("\nEscoja una opcion correta\n");
                }
            }
        }else{
            System.out.println("\nNo tiene solicitudes de cotizacon\n");
        }                             
    }

    //Métodos posible uso
    public void agregarCotizacion(Vehiculo auto, Cliente cl){        
        cotizaciones.add(auto);
        clientes.add(cl);
    }

    //Método para mostrar informacion del usuario
    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos()+"\nID: "+id;
    }
}
