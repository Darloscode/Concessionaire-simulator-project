package com.mycompany.model.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.model.Vehiculos.Vehiculo;


public class Vendedor extends Usuario{

    private String tipo = "Vendedor";
    private int id;
    private ArrayList<Vehiculo> cotizaciones = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    public Vendedor(String nombre, String apellido, String usuario, String password, int id){
        super(nombre, apellido,usuario, password);
        this.id=id;
    }

    @Override
    public String mostrarDatos(){
        return "Usuario: "+tipo+super.mostrarDatos()+"\nID: "+id;
    }

    public String getTipo(){
        return tipo;
    }

    public ArrayList getCotizaciones(){
        return cotizaciones;
    }

    public void agregarCotizacion(Vehiculo auto, Cliente cl){        
        cotizaciones.add(auto);
        clientes.add(cl);
    }

    public void consultarStock(ArrayList<Vehiculo> vehiculos){                
        for(Vehiculo vh : vehiculos){            
            System.out.println(vh.mostrarDatos());
        }
    }

    public void mostrarCotizaciones(){
        Scanner rd = new Scanner(System.in);
        System.out.println();
        for(int i=0; i<cotizaciones.size(); i++){
            System.out.println((i+1)+". "+clientes.get(i).getNombre()+" ha solicitado una cotazación del vehiculo de la marca " + cotizaciones.get(i).getMarca()+" y modelo "+cotizaciones.get(i).getModelo());
        }
        String op = "";
        String opc = "";

        while(!op.equals("s")){

            System.out.print("Elija una cotización para responder, escriba (s) para salir: ");
            op = rd.nextLine();

            if(isNumeric(op)){
                int indice = Integer.parseInt("op");
                if((indice>0)&(indice<=cotizaciones.size())){
                    System.out.println("¿Aprobar o Rechazar la solicitud?");
                    System.out.println("1. Aprobar\n2. Rechazar");
                    if(opc.equals("1")){
                        System.out.println("Todo bien");

                    }else if(opc.equals("2")){
                        System.out.println("Estimado " + getNombre() +", escriba los motivos del rechazo de la solicitud");
                        System.out.print("Respuesta: ");
                        String respuesta = rd.nextLine();
                    }

                }
            }            
        }
        rd.close();        
    }

    
    /*
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "ID=" + ID + '}';
    }
     */
    
}
