package ticket;

import documents.TicketGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import usuarios.Usuario;
import java.util.Scanner;

import static utils.ClearScreen.clearScreen;

@Getter
@Setter
@ToString
public class Ticket {

    private String id;
    private Usuario Cliente;
    private int idCartelera;
    private int idProducto;
    private TicketGenerator Generator = null;

    public Ticket() {
        idCartelera = -1;
        idProducto = -1;
    }

    public void seleccionarPelicula(){
        Scanner sc = new Scanner(System.in);
        Cartelera carte = new Cartelera();
        System.out.println("Seleccione la pelicula que le gustaria (0 para salir)");
        carte.imprimirPantalla();
        int idTemp = sc.nextInt();
        boolean idEstablecido = false;
        for (Cartelera disponible : Cartelera.obtenerCartelera()) {
            if (disponible.getIdProgramacion() == idTemp - 1) {
                idCartelera = idTemp-1;
                idEstablecido = true;
            }
        }
        if(idEstablecido == false && idTemp != 0){
            System.out.println("Pelicula seleccionada no existe");
            seleccionarPelicula();
        }
        clearScreen();
    }

    public void comprarProducto() {
        Scanner sc = new Scanner(System.in);
        Productos prod = new Productos();
        System.out.println("Seleccione el producto que le gustaria (0 para salir)");
        prod.imprimirProductos();
        int idProductoTemp = sc.nextInt();
        boolean idEstablecido = false;
        for (Productos producto : prod.obtenerProductos()) {
            if (producto.getIdProducto() == idProductoTemp - 1) {
                idProducto = idProductoTemp-1;
                idEstablecido = true;
            }
        }
        if(idEstablecido == false && idProductoTemp != 0){
            System.out.println("Producto seleccionada no existe");
            comprarProducto();
        }
        clearScreen();
    }

    public void imprimirTicket(){
        if(Generator == null){
            Generator = new TicketGenerator(this);
        }
        Generator.imprimir();
    }

    public void enviarTicket(){
        if(Generator == null){
            Generator = new TicketGenerator(this);
            Generator.imprimir();
        }
        Generator.sendTicket();
    }
}

