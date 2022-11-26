    /*
    private static boolean login(String user, String password, String tipo){
        ArrayList<Usuario> usuarios = inicializarSistema();
        Scanner rd = new Scanner(System.in);
        String op="";
        boolean verificar=verificarLogin(user, password, tipo, usuarios);
        
        if(verificar){
            System.out.println("\nHas iniciado sección\n");
            return true;
        }else{
            while((!verificar)){
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
                    if(verificar){
                        System.out.println("\nHas iniciado sección\n");
                        return true;
                    }
                }else if(op.equals("2")){
                    return false;
                }else{
                    System.out.println("Elija una opción correcta");
                }
            }
        }
        return false;              
    }    

    private static boolean verificarLogin(String user, String passw, String tipo, ArrayList<Usuario> usuarios){
        for(Usuario u : usuarios){
            if((u.getUsuario().equals(user)) & (u.getPassword().equals(passw)) & (u.getTipo().equals(tipo))){                        
                return true;
            }
        }
        return false;
    }
    */
package com.mycompany.proyectoparcialpoo;

public class Errores {
    
}


    /*
    private static boolean login(String user, String password){
        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\usuarios.txt");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();                                           
            lectura = entrada.readLine(); 

            while (lectura != null){
                
                String[] datos = lectura.split(",");                

                if((datos[3].equals(user)) & (datos[4].equals(password))){                    
                    System.out.println("\nHas iniciado sección\n");
                    entrada.close();
                    return true;
                }                              
                lectura = entrada.readLine();
            }
            System.out.println("\nSu usuario o contraseña estan incorrectos\n");
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }                    
        return false;
    }


System.out.println("********Cliente********");
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();

                    verificar = login(usuario, password, "Cliente");

                    op = "";                   
    */

    /*
     case "2":
                    System.out.println("************Vendedor************");
                    tipo = "Vendedor";
                    
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();

                    user = login(usuario, password, tipo);

                    if(!user.equals(null)){
                        
                    }
                    break;
                    
                case "3":
                    System.out.println("************Supervisor************");
                    tipo = "Supervisor";  
                    
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();

                    user = login(usuario, password, tipo);

                    if(!user.equals(null)){
                    }
                    break;
                                        
                case "4":
                    System.out.println("***********Jefe de taller************");
                    tipo = "Jefe Taller";
                    System.out.print("Usuario: ");
                    usuario = entrada.nextLine();
                
                    System.out.print("Contraseña: ");
                    password = entrada.nextLine();

                    user = login(usuario, password, tipo);

                    if(!user.equals(null)){
                    }
                    break; 
    */




    /*
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
    */




    
    /*
    private static Usuario login(String user, String password, String tipo){
        ArrayList<Usuario> usuarios = inicializarSistema();
        Scanner rd = new Scanner(System.in);        
        Usuario verificar=verificarLogin(user, password, tipo, usuarios);
        
        if(verificar != null){
            System.out.println("\nHas iniciado sección\n");
            return verificar;
        }else{
            while((verificar == null)){
                String op="";
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
        File archivo = new File("ProyectoParcialPOO\\src\\main\\java\\com\\mycompany\\files\\usuarios.txt");        
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
    */