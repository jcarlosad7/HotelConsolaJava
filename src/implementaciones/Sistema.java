package implementaciones;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import clases.Cliente;
import clases.Habitacion;
import clases.Hospedaje;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        //Variables globales
        Scanner lector=new Scanner(System.in);
        List<Cliente> clientes=new ArrayList();
        List<Habitacion> habitaciones=new ArrayList();
        habitaciones.add(new Habitacion(1,101,100.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(2,102,120.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(3,201,100.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(4,202,100.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(5,203,100.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(6,301,100.00,false,"Habitación simple"));
        habitaciones.add(new Habitacion(7,302,150.00,false,"Habitación simple"));

        List<Hospedaje> hospedajes=new ArrayList();
        int opcion=0;
        int idBuscar=0;
        boolean encuentra=false;
        do{
            System.out.println("OPCIONES" +
                    "\n1. Registrar Cliente" +
                    "\n2. CHECK IN" +
                    "\n3. CHECK OUT" +
                    "\n4. Listar Clientes" +
                    "\n5. Listar Habitaciones" +
                    "\n6.Listar Hospedajes" +
                    "\n7. Salir");
            opcion=lector.nextInt();
            lector.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("## REGISTRAR CLIENTE ##");
                    Cliente cliente=new Cliente();
                    System.out.println("Ingrese el ID:");
                    cliente.setId(lector.nextInt());
                    lector.nextLine();
                    System.out.println("Ingrese el nombre:");
                    cliente.setNombre(lector.nextLine());
                    System.out.println("Ingrese documento:");
                    cliente.setDocumento(lector.nextLine());
                    System.out.println("Ingrese email:");
                    cliente.setEmail(lector.nextLine());
                    System.out.println("Ingrese Teléfono:");
                    cliente.setTelefono(lector.nextLine());
                    clientes.add(cliente);
                    break;
                case 2:
                    System.out.println("## CHECK IN ##");
                    idBuscar=0;
                    encuentra=false;
                    Hospedaje hospedaje=new Hospedaje();
                    //Agregar cliente
                    Cliente cliHospedaje=new Cliente();
                    System.out.println("Ingrese ID de cliente: ");
                    idBuscar=lector.nextInt();
                    lector.nextLine();
                    for(Cliente cli:clientes){
                        if(idBuscar==cli.getId()){
                            encuentra=true;
                            cliHospedaje=cli;
                        }
                    }
                    if(!encuentra){
                        System.out.println("No existe ese cliente, por favor registralo.");
                        break;
                    }
                    //Agregar habitación
                    idBuscar=0;
                    encuentra=false;
                    Habitacion habHospedaje=new Habitacion();
                    System.out.println("Ingres ID de la Habitación");
                    idBuscar=lector.nextInt();
                    lector.nextLine();
                    for(Habitacion hab:habitaciones){
                        if(!hab.isEstado()){
                            if(idBuscar==hab.getId()){
                                encuentra=true;
                                habHospedaje=hab;
                            }
                        }
                    }
                    if(!encuentra){
                        System.out.println("No existe esa habitación, o esta ocupada.");
                        break;
                    }
                    System.out.println("Ingrese el ID del hospedaje: ");
                    hospedaje.setId(lector.nextInt());
                    lector.nextLine();
                    hospedaje.setCliente(cliHospedaje);
                    hospedaje.setHabitacion(habHospedaje);
                    System.out.println("Ingrese los días que se va a quedar: ");
                    hospedaje.setDias(lector.nextInt());
                    lector.nextLine();
                    System.out.println("Ingrese el total a Pagar: ");
                    hospedaje.setTotalPagar(lector.nextDouble());
                    lector.nextLine();
                    hospedajes.add(hospedaje);
                    //Poner la habitación como ocupada
                    for(Habitacion hab:habitaciones){
                        if(hab.getId()==habHospedaje.getId()){
                            hab.setEstado(true);
                        }
                    }
                    break;
                case 3:
                    System.out.println("## CHECK OUT ##");
                    encuentra=false;
                    Hospedaje hosCheckout=new Hospedaje();
                    System.out.println("Cuál es el código de su hospedaje? ");
                    idBuscar=lector.nextInt();
                    lector.nextLine();
                    for(Hospedaje hos:hospedajes){
                        if(hos.getId()==idBuscar){
                            encuentra=true;
                            hosCheckout=hos;
                        }
                    }
                    if(!encuentra){
                        System.out.println("No existe un hospedaje con ese ID.");
                    }else{
                        System.out.println("Total a pagar: "+ hosCheckout.getTotalPagar());
                        //Poner la habitación como libre
                        for(Habitacion hab:habitaciones){
                            if(hab.getId()==hosCheckout.getHabitacion().getId()){
                                hab.setEstado(false);
                            }
                        }

                    }
                    break;
                case 4:
                    System.out.println("## LISTAR CLIENTES ##");
                    for(Cliente cli:clientes){
                        System.out.println("ID: "+cli.getId()+" | Nombre: "+cli.getNombre()+" | Documento: "+cli.getDocumento()+" | Email: "+cli.getEmail());
                    }
                    break;
                case 5:
                    System.out.println("## LISTAR HABITACIONES ##");
                    for(Habitacion hab:habitaciones){
                        System.out.println("ID: "+hab.getId()+" | Número: "+hab.getNumero()+" | Precio: "+hab.getPrecio()+" | Estado: "+hab.isEstado());
                    }
                    break;
                case 6:
                    System.out.println("## LISTAR HOSPEDAJES ##");
                    for(Hospedaje hos:hospedajes){
                        System.out.println("ID: "+hos.getId()+" | Cliente: "+hos.getCliente().getNombre()+" | Habitación: "+hos.getHabitacion().getNumero()+" | Total a Pagar: "+hos.getTotalPagar());
                    }
                    break;
            }
        }while(opcion!=7);
    }
}
