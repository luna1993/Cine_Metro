package usuarios;

import java.util.Scanner;
import com.Cine_Metro.Cine_Metro;
import ticket.Cartelera;
import ticket.Pelicula;

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
        System.out.println("***********  Bienvenido a Cine Metro  ************");
        System.out.println("1.Gestionar Cartelera.");
        System.out.println("2.Gestionar Productos.");
        System.out.println("3.Salir");
        System.out.println("**************************************************");
        System.out.println("Elige una opción: ");
        int opc=sc.nextInt();
        switch (opc){
            case 1:
                gestionCartelera();
                break;
            case 2:

                break;
            case 3:
                System.out.println("***********  Gracias por visitar Cine Metro  ************");
                user = null;
                return;

        }
    }

    public void gestionCartelera(){
        clearScreen();
        Scanner sc=new Scanner(System.in);
        System.out.println("***********Seleccione una opcion**************");
        System.out.println("1.Añadir Pelicula");
        System.out.println("2.Quitar pelicula");
        System.out.println("3.Salir");
        System.out.println("**********************************************");
        int opc=sc.nextInt();
        switch (opc){
            case 1:
                clearScreen();
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
                clearScreen();
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
        }
    }
}
