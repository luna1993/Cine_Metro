package usuarios;

import java.util.Scanner;
import com.Cine_Metro.Cine_Metro;
import org.testng.annotations.Test;
import ticket.Cartelera;
import ticket.Pelicula;
import ticket.Productos;

import static utils.AdminMenu.*;
import static utils.ClearScreen.clearScreen;

public class Administrador implements iAdministrador {
    private Usuario user = null;

    @Override
    public boolean iniciarSesion(String id){
        for (Usuario userT: Usuario.obtenerUsuarios()) {
            if(userT.getRol() == "admin" && userT.getIdUsuario().contains(id)){
                user = userT;
            }
        }
         if (user != null){
            System.out.println("Bienvenido Admin");
            menu();
            return true;
        }else{
            return false;
        }
    }

    public void menu(){
        Scanner sc=new Scanner(System.in);
        Usuario u=new Usuario();
        u.llenadoUsuario();
        menuAdmin();
        int opc=sc.nextInt();
        switch (opc){
            case 1:
                gestionCartelera();
                break;
            case 2:
                gestionarProducto();
                break;
            case 3:
                System.out.println("***********  Gracias por visitar Cine Metro  ************");
                user = null;
                return;
        }clearScreen();
    }

    public void gestionCartelera(){
        Scanner sc=new Scanner(System.in);
        menupelicula();
        int opc=sc.nextInt();
        switch (opc){
            case 1:
                System.out.println("Nombre de la pelicula:");
                String nombre = sc.next();
                System.out.println("ID de genero:");
                int idGen = sc.nextInt();
                System.out.println("Duracion pelicula:");
                Double duracion = sc.nextDouble();
                System.out.println("Clasificacion:");
                int clasificacion = sc.nextInt();
                System.out.println("Fecha en cartelera: (AAAA-MM-dd)");
                String fecha= sc.next();
                System.out.println("Hora en cartelera: (HH:mm)");
                String hora = sc.next();

                int idPeli = Pelicula.obtenerPeliculas().size();
                new Pelicula().añadirPelicula(idPeli, nombre, idGen, duracion, clasificacion);
                new Cartelera().añadirCartelera(Cartelera.obtenerCartelera().size(), idPeli, fecha, hora);

                System.out.println("Pelicula añadida");
                break;
            case 2:
                System.out.println("Seleccione pelicula a quitar");
                new Cartelera().imprimirPantalla();
                int idTemp = sc.nextInt();
                boolean idEstablecido = false;
                for (Cartelera disponible : Cartelera.obtenerCartelera()) {
                    if (disponible.getIdProgramacion() == idTemp - 1) {
                        idEstablecido = true;
                    }
                }
                if(idEstablecido == false && idTemp != 0){
                    System.out.println("Pelicula seleccionada no existe");
                } else{
                    Cartelera.obtenerCartelera().remove(idTemp-1);
                    System.out.println("Pelicula eliminada");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Opcion no disponible");
                break;
        } clearScreen();
    }
    public void gestionarProducto(){
        Scanner sc=new Scanner(System.in);
        menuproducto();
        int opc=sc.nextInt();
        switch (opc){
            case 1:
                System.out.println("Nombre del producto:");
                String nombrep = sc.next();
                System.out.println("Tipo de producto:");
                String tipo = sc.nextLine();
                System.out.println("Precio del producto:");
                Double precio = sc.nextDouble();
                int idProducto = Productos.obtenerProductos().size();
                new Productos().añadirProducto(idProducto,nombrep,tipo,precio);
                System.out.println("Producto añadido");
                break;
            case 2:
                System.out.println("Seleccione Producto a quitar");
                new Productos().imprimirProductos();
                int idTemp = sc.nextInt();
                boolean idEstablecido = false;
                for (Productos disponible : Productos.obtenerProductos()) {
                    if (disponible.getIdProducto() == idTemp - 1) {
                        idEstablecido = true;
                    }
                }
                if(idEstablecido == false && idTemp != 0){
                    System.out.println("Producto seleccionado no existe");
                } else{
                    Productos.obtenerProductos().remove(idTemp-1);
                    System.out.println("Producto eliminado");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Opcion no disponible");
                break;
        } clearScreen();
    }
}
