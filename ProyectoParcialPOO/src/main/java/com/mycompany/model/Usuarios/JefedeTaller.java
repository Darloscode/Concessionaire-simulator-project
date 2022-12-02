package com.mycompany.model.Usuarios;
import java.util.ArrayList;

import com.mycompany.model.Vehiculos.*; 
import java.util.Scanner;


public class JefedeTaller extends Usuario{

    private String tipo = "Jefe de Taller";

    private ArrayList<String> certifiacionestecnicas = new ArrayList<>();

    private ArrayList<Vehiculo> mantenimientovehiculos = new ArrayList<>();
    private ArrayList<Cliente> clientesmantenimiento = new ArrayList<>();

    private ArrayList<Vehiculo> entregarvehiculos = new ArrayList<>();
    private ArrayList<Cliente> clientesentregar = new ArrayList<>();

             
    //Constructor
    public JefedeTaller(String nombre, String apellido, String usuario, String password, ArrayList<String> crttecnicas){
        super(nombre, apellido, usuario, password);        
        this.certifiacionestecnicas = crttecnicas;
    }

    //Método para mostrar informacion del jefe de taller
    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos();
    }
    
    //Métodos getters
    public String getTipo(){
        return tipo;
    }
    
    public ArrayList<String> getCertificacionesTecnicas(){
        return certifiacionestecnicas;
    }

    public ArrayList<Vehiculo> getEntregarVehiculos(){
        return entregarvehiculos;
    }
    public ArrayList<Vehiculo> getMantenimientoVehiculos(){
        return mantenimientovehiculos;
    }
        
    //Métodos en uso
    public void agregarEntregas(Vehiculo auto, Cliente cl){        
        entregarvehiculos.add(auto);
        clientesentregar.add(cl);
    }

    public void agregarMantenimientos(Vehiculo auto, Cliente cl){
        mantenimientovehiculos.add(auto);
        clientesmantenimiento.add(cl);
    }

    public void verificarSolicitudes(){
        int i = 0;
        for(Vehiculo vh : mantenimientovehiculos){
            if(vh.getEstadoMantenimiento()==null){
                i++;
            }
        }
        if(i>0){
            System.out.println("\nTiene solicitudes de mantenimiento, elija la opcion 2 para admitir vehiculos a mantenimiento\n");
        }else{
            System.out.println("\nNo tiene solicitudes de mantenimiento\n");
        }
    }

    public void verificarEntregas(){
        if(entregarvehiculos.size()>0){
            System.out.println("\nTiene vehiculos por entregar, escoja la opcion 1 para entregar vehiculos\n");
        }else{
            System.out.println("\nNo tiene solicitudes de entrega\n");
        }
    }
       
    public void mostrarEntregas(ArrayList<Vehiculo>vehiculos){
        Scanner sc = new Scanner ( System.in);        

        String opc = "";
        boolean salir = false;
        boolean exit;

        if(clientesentregar.size()>0){
            while(!salir){
                for( int i=0 ; i<clientesentregar.size(); i++){
                    System.out.println("\n"+(i+1)+ ". Al cliente "+clientesentregar.get(i).getNombre()+" se le ha aprobado la compra del siguiente vehiculo: ");
                    System.out.println("   "+entregarvehiculos.get(i).toString());
                    exit = false;
                    while(!exit){
                        System.out.print("\n1. Entregar vehiculo\n2. Salir\nElija una opcion: ");
                        opc = sc.nextLine();
                        if(opc.equals("1")){
                            Vehiculo vh = entregarvehiculos.get(i);
                            clientesentregar.get(i).agregarCompra(entregarvehiculos.get(i)); 
                            int ivh = clientesentregar.get(i).getVehiculos().indexOf(vh);
                            clientesentregar.get(i).getVehiculos().get(ivh).setMantenimiento(Mantenimiento.Ninguno);
                            System.out.println("\nEl vehiculo ha sido entregado\n");
                            
                            
                            System.out.println(vehiculos.contains(vh));
                            vehiculos.remove(vh); 
                            
                            entregarvehiculos.remove(i);
                            clientesentregar.remove(i);
                            exit = true;                            
                        }else if(opc.equals("2")){
                            exit = true;
                            salir = true;
                        }else{
                            System.out.println("\nElija una opcion correcta\n");
                        }
                    }
                }
                salir = true;
            }                   
        }else{
            System.out.println("\nNo tiene entregas que realizar\n");
        }
    }

    public void admitirVehiculos(){
        Scanner sc = new Scanner ( System.in);

        String opc = "";
        boolean salir = false;
                

        ArrayList<Vehiculo> enespera = new ArrayList<>();
        ArrayList<Usuario> userespera = new ArrayList<>();

        for(int j=0; j<mantenimientovehiculos.size(); j++){
            if(mantenimientovehiculos.get(j).getEstadoMantenimiento() == null){
                enespera.add(mantenimientovehiculos.get(j));
                userespera.add(clientesmantenimiento.get(j));
            }
        }        

        if(enespera.size()>0){
            for(int i=0; i<enespera.size(); i++){
                System.out.println("\n"+(i+1)+". El cliente "+userespera.get(i).getNombre()+" solicita un mantenimiento "+enespera.get(i).getMantenimiento()+" del vehiculo :");
                System.out.println("-"+enespera.get(i).toString());
                salir = false;
                while(!salir){
                    System.out.print("\n1. Aceptar\n2. Salir\nElija una opcion: ");
                    opc = sc.nextLine();
                    if(opc.equals("1")){
                        int buscar = mantenimientovehiculos.indexOf(enespera.get(i));
                        mantenimientovehiculos.get(buscar).setEstadoMantenimiento(EstadoMantenimiento.Admitido);
                        salir = true;
                    }else if(opc.equals("2")){
                        System.out.println("\nSaliendo de mantenimiento de vehiculos\n");
                        salir = true;
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
        String adm;
        boolean salir = false;

        
        ArrayList<Vehiculo> vhman = new ArrayList<>();
        ArrayList<Usuario> userman = new ArrayList<>();

        for(int j=0; j<mantenimientovehiculos.size(); j++){
            if(mantenimientovehiculos.get(j).getEstadoMantenimiento() == EstadoMantenimiento.Admitido){
                vhman.add(mantenimientovehiculos.get(j));
                userman.add(clientesmantenimiento.get(j));
            }
        }    

        if(vhman.size()>0){            
            while(!salir){
                int i = 1;
                for(Vehiculo vh : mantenimientovehiculos){
                    System.out.println("\n"+i+". "+vh.toString()+" - Designado como: "+vh.getEstadoMantenimiento());
                    i++;
                }
                System.out.print("\nElija un vehiculo para cambiar estado de mantenimiento o esciba (s) para salir: ");
                opc = sc.nextLine();

                if(isNumeric(opc)){                    
                    int indice = Integer.parseInt(opc);
                    if((indice>0) & (indice<=mantenimientovehiculos.size())){
                        boolean exit = false;                        
                        while(!exit){
                            System.out.print("\n1. En reparacion\n2. En etapa de prueba\n3. Dar de alta\n4. Salir\nElija una opcion: ");
                            adm = sc.nextLine();
                            if(adm.equals("1")){
                                mantenimientovehiculos.get(indice-1).setEstadoMantenimiento(EstadoMantenimiento.En_Reparacion);
                                System.out.println("\nEl vehiculo esta siendo revisado\n");
                                exit = true;
                            }else if(adm.equals("2")){
                                mantenimientovehiculos.get(indice-1).setEstadoMantenimiento(EstadoMantenimiento.En_Etapa_De_Prueba);
                                System.out.println("\nRevisando correcto funcionamiento del vehiculo\n");
                                exit = true;
                                
                            }else if(adm.equals("3")){
                                mantenimientovehiculos.get(indice-1).setMantenimiento(Mantenimiento.Ninguno);
                                clientesmantenimiento.get(indice-1).agregarMensaje("Su vehiculo ha sido reparado, puede acercarse a retirar su vehiculo: \n"+mantenimientovehiculos.get(indice-1).mostrarDatos());
                                mantenimientovehiculos.get(indice-1).setEstadoMantenimiento(null);
                                clientesmantenimiento.remove(indice-1);
                                mantenimientovehiculos.remove(indice-1);
                                exit = true;
                                salir = true;
                            }else if(adm.equals("4")){                                
                                exit = true;
                            }else{
                                System.out.println("\nElija una opcion correcta\n");
                            }
                        }
                    }
                }else if(opc.equals("s")){
                    System.out.println("\nSaliendo....\n");
                    salir = true;                    
                }else{
                    System.out.println("\nElija un vehiculo de la lista\n");
                }
            }           
        }else{
            System.out.println("\nNo tiene vehiculos en mantenimiento\n");
        }
    }

    public void consultarReparacion(ArrayList<Usuario> usuarios){
        int i = 0;
        for(Usuario us : usuarios){
            if(us instanceof JefedeTaller){
                JefedeTaller jdt = (JefedeTaller) us;
                for(Vehiculo vh : jdt.getMantenimientoVehiculos()){
                    if(vh.getEstadoMantenimiento()==EstadoMantenimiento.En_Reparacion){
                        i++;
                    }
                }
            }
        }
        System.out.println("\nEn la concesionaria hay "+i+" vehiculos que se encuentran en REPARACION\n");
    }

}