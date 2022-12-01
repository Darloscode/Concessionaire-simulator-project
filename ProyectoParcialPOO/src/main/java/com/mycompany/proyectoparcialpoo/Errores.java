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



    /*
                                    System.out.print("\nElija un numero del stock de vehiculos o escriba (s) para salir: ");
                                    indvehiculo = entrada.nextLine(); 
                                    if(isNumeric(indvehiculo) ){    
                                            int ind = Integer.parseInt(indvehiculo);  
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviada\n");                                                                                                                
                                            }
                                           
                                            else{
                                                System.out.println("Elija un vehiculo de la lista");
                                            }
                                         }
                                    */






    
                                        /*
                                        if(isNumeric(indvehiculo) && indvehiculo.equals("1")){
                                        usercliente.consultarStock(vehiculos); 
                                        System.out.print("\nElija un numero del stock de vehiculos o escriba (s) para salir: ");
                                        indcoti = entrada.nextLine(); // pide que ingrese el valor
                                           
                                               
                                            int ind = Integer.parseInt(indvehiculo);  
                                            if((ind>0)&(ind<=vehiculos.size())){
                                                Vehiculo vhcotiza = usercliente.solicitarCotizacion(ind, vehiculos);                                                
                                                usercliente.enviarCotizacion(vhcotiza, usuarios, usercliente);                                                 
                                                System.out.println("\nSu cotización ha sido enviada Presione s para salir \n");                                                                                         
                                            }
                                           
                                            else{
                                                System.out.println("Elija un vehiculo de la lista");
                                            }
                                        }else if(indvehiculo.equals("s")){
                                            
                                            
                                        }else if(indvehiculo.equals("2")){
                                            System.out.println("");
                                            System.out.println("Señor : "+usercliente.getNombre()+"  "+usercliente.getApellido()+"  "+"Por favor consulte primero el stock de vehiculo");
                                        }
                                        else{
                                            System.out.println("\nElija una opción correcta\n");
                                        }
                                         */









    /*    
    public void eliminarMensaje(String mensaje){
        mensajes.remove(mensaje);
    }

    public void eliminarCotizacion(Vehiculo vh){
        cotizaciones.remove(vh);
    }

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




/*

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
     */









     
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