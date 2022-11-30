package com.mycompany.model.Usuarios;
import java.util.ArrayList;

import com.mycompany.model.Vehiculos.*; 
import java.util.Scanner;

public class JefedeTaller extends Usuario{

    private String tipo = "Jefe de Taller";

    ArrayList<String>CertifiacionesTecnicas;


    ArrayList<Vehiculo> mantenimientoVehiculos = new ArrayList<>();
    ArrayList<Cliente> clientesmantenimiento = new ArrayList<>();

    ArrayList<Vehiculo> entregarvehiculos = new ArrayList<>();
    ArrayList<Cliente> clientesentregar = new ArrayList<>();

                            
    public JefedeTaller(String nombre, String apellido, String usuario, String password){
        super(nombre, apellido, usuario, password);        
    }

    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }
    
    public String getTipo(){
        return tipo;
    }
    

    public ArrayList<Vehiculo> getEntregarVehiculos(){
        return entregarvehiculos;
    }
    

    public void agregarEntregas(Vehiculo auto, Cliente cl){        
        entregarvehiculos.add(auto);
        clientesentregar.add(cl);
    }

    public void agregarMantenimientos(Vehiculo auto, Cliente cl){
        mantenimientoVehiculos.add(auto);
        clientesmantenimiento.add(cl);
    }
    
    /*
    public void mostrarEntregas( ArrayList<Vehiculo>vehiculos){
         Scanner sc = new Scanner ( System.in);

        String op= "";
        String opc= "";

        while(!op.equals("s")){
            if(clientesentregar.size()>0){                
                for( int i=0 ; i<clientesentregar.size(); i++){
                
                    
                    System.out.println((i+1)+ ". a El cliente "+clientesentregar.get(i).getNombre()+" "+clientesentregar.get(i).getApellido() +" Se le ha aprobado la comprar un vehiculo  "+ entregarvehiculos.get(i).mostrarDatos() ) ;
                    
                    while(!(opc.equals("2"))){
                
                            System.out.print("\n1. entregar vehiculo\n2. Salir\nElija una opcion: ");
                            opc = sc.nextLine();
                            if(opc.equals("1")){
                            System.out.println("El vehiculo ha sido entregado");
                            
                            for( int a=0 ; a<vehiculos.size(); a++){
                                if (vehiculos.get(a).equals(entregarvehiculos.get(i))){
                                    vehiculos.remove(a);
                                }
                            }       
                            break;
                            }
                            
                    
                    
                         }   
        
                  } break;
            }
        }
    }
    */
    public void mostrarEntregas( ArrayList<Vehiculo>vehiculos){

        Scanner sc = new Scanner ( System.in);
        
        String opc= "";
        
        if(clientesentregar.size()>0){                
            for( int i=0 ; i<clientesentregar.size(); i++){
                System.out.println((i+1)+ ". El cliente "+clientesentregar.get(i).getNombre()+" se le ha aprobado la compra del vehiculo de la marca "+ entregarvehiculos.get(i).getMarca()+" y modelo "+entregarvehiculos.get(i).getModelo());
                while(!(opc.equals("2"))){
                    System.out.print("\n1. Entregar vehiculo\n2. Salir\nElija una opcion: ");
                    opc = sc.nextLine();
                    if(opc.equals("1")){
                        System.out.println("\nEl vehiculo ha sido entregado\n");
                        clientesentregar.get(i).agregarCompra(entregarvehiculos.get(i));
                        if(vehiculos.contains(entregarvehiculos.get(i))){
                            vehiculos.remove(entregarvehiculos.get(i));                            
                        }
                        entregarvehiculos.remove(i);
                        clientesentregar.remove(i);
                    }else if(opc.equals("2")){
                        System.out.println("\nSaliendo de la entrega de vehiculos\n");
                    }else{
                        System.out.println("\nElija una opcion correcta\n");
                    }
                }
            }
        }else{
            System.out.println("\nNo tiene entregas que realizar\n");
        }
    }

    public void admitirVehiculos(){
        Scanner sc = new Scanner ( System.in);
        String opc = "";
        if(mantenimientoVehiculos.size()>0){
            for(int i=0; i<mantenimientoVehiculos.size(); i++){
                System.out.println((i+1)+". El cliente "+clientesmantenimiento.get(i).getNombre()+" solicita un mantenimiento "+mantenimientoVehiculos.get(i).getMantenimiento()+" del vehiculo :");
                System.out.println("-"+mantenimientoVehiculos.get(i).toString());
                while(!opc.equals("2")){
                    System.out.print("\n1. Aceptar\n2. Salir\nElija una opcion: ");
                    opc = sc.nextLine();
                    if(opc.equals("1")){                                                
                        mantenimientoVehiculos.get(i).setEstadoMantenimiento(EstadoMantenimiento.Reparacion);

                    }else if(opc.equals("2")){
                        System.out.println("\nSaliendo de mantenimiento de vehiculos\n");
                    }else{
                        System.out.println("\nElija una opcion correcta\n");
                    }
                }
            }            
        }else{
            System.out.println("\nNo tiene solicitudes de mantenimiento\n");
        }
    }

    public void administrarVehiculos(){
        Scanner sc = new Scanner ( System.in);
        String opc = "";
        if(mantenimientoVehiculos.size()>0){
            
            while(!opc.equals("s")){
                int i = 1;
                for(Vehiculo vh : mantenimientoVehiculos){
                    System.out.println(i+vh.toString()+" - Designado como: "+vh.getEstadoMantenimiento());
                }
                System.out.print("\nElija un vehiculo para administrar: ");
                opc = sc.nextLine();
                if(isNumeric(opc)){                    
                    int indice = Integer.parseInt(opc);
                    if((indice>0) & (indice<=mantenimientoVehiculos.size())){
                        String adm = "";
                        while(!adm.equals("4")){
                            System.out.println("\n1. En reparacion\n2. En etapa de prueba\n3. Dar de alta\n4. Salir\nElija una opcion: ");
                            adm = sc.nextLine();
                            if(adm.equals("1")){
                                mantenimientoVehiculos.get(indice-1).setEstadoMantenimiento(EstadoMantenimiento.Reparacion);
                                System.out.println("\nEl vehiculo esta siendo revisado\n");                                
                            }else if(adm.equals("2")){
                                mantenimientoVehiculos.get(indice-1).setEstadoMantenimiento(EstadoMantenimiento.Prueba);
                                System.out.println("\nRevisando correcto funcionamiento del vehiculo\n");
                            }else if(adm.equals("3")){
                                clientesmantenimiento.get(indice-1).agregarMensaje("Su vehiculo ha sido reparado, puede acercarse a retirar su vehiculo: \n"+mantenimientoVehiculos.get(indice-1).mostrarDatos());
                                mantenimientoVehiculos.get(indice-1).setMantenimiento(Mantenimiento.Ninguno);
                                mantenimientoVehiculos.get(indice-1).setEstadoMantenimiento(null);
                                clientesmantenimiento.remove(indice-1);
                                mantenimientoVehiculos.remove(indice-1);
                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }

                    }
                }else{
                    System.out.println("\nElija un vehiculo de la lista\n");
                }
            }            
        }else{
            System.out.println("\nNo tiene vehiculos en mantenimiento\n");
        }
    }

    public void verificarSolicitudes(){
        int i = 0;
        for(Vehiculo vh : mantenimientoVehiculos){
            if(vh.getEstadoMantenimiento()==null){
                i++;
            }
        }
        if(i>0){
            System.out.println("\nTiene solicitudes de mantenimiento, elija la opcion 2 para admitir vehiculos a mantenimiento\n");
        }
    }

    


    


       
    

    /*
    public ArrayList<JefedeTaller> getMantenimientoVehiculos() {
        return MantenimientoVehiculos;
    }

    public ArrayList<JefedeTaller> getCertifiacionesTecnicas() {
        return CertifiacionesTecnicas;
    }

    public ArrayList<JefedeTaller> getEntregarVehiculos() {
        return EntregarVehiculos;
    }

    public void setMantenimientoVehiculos(ArrayList<JefedeTaller> MantenimientoVehiculos) {
        this.MantenimientoVehiculos = MantenimientoVehiculos;
    }

    public void setCertifiacionesTecnicas(ArrayList<JefedeTaller> CertifiacionesTecnicas) {
        this.CertifiacionesTecnicas = CertifiacionesTecnicas;
    }

    public void setEntregarVehiculos(ArrayList<JefedeTaller> EntregarVehiculos) {
        this.EntregarVehiculos = EntregarVehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JefedeTaller other = (JefedeTaller) obj;
        if (!Objects.equals(this.MantenimientoVehiculos, other.MantenimientoVehiculos)) {
            return false;
        }
        if (!Objects.equals(this.CertifiacionesTecnicas, other.CertifiacionesTecnicas)) {
            return false;
        }
        return Objects.equals(this.EntregarVehiculos, other.EntregarVehiculos);
    }
    */   
}