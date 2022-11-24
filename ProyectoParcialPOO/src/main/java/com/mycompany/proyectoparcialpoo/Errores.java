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