package usuarios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ticket.Ticket;

import java.util.Scanner;

import static utils.ClearScreen.clearScreen;

@Getter
@Setter
@ToString
public class Cliente implements icliente {

    private Usuario user = null;

    @Override
    public boolean iniciarSesion(String id){
        for (Usuario userT: Usuario.obtenerUsuarios()) {
            if(userT.getRol() == "cliente" && userT.getIdUsuario().contains(id)){
                user = userT;
            }
        }
        if (user != null){
            clearScreen();
            System.out.println("Bienvenido cliente");
            menu();
            return true;
        }else{
            return false;
        }
    }
    public void menu(){
        Ticket t=new Ticket();
        Cliente c=new Cliente();
        t.setCliente(user);
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("***********  Bienvenido a Cine Metro  ************");
            System.out.println("1.Ver Cartelera.");
            System.out.println("2.Ver Productos de Dulceria.");
            System.out.println("3.Finalizar compra");
            System.out.println("4.Salir");
            System.out.println("**************************************************");
            System.out.println("Elige una opción: ");
            int opc=sc.nextInt();
            switch (opc){
                case 1:
                    clearScreen();
                    t.seleccionarPelicula();
                    break;
                case 2:
                    clearScreen();
                    t.comprarProducto();
                    break;
                case 3:
                    clearScreen();
                    t.imprimirTicket();
                    t.enviarTicket();
                    sc.nextLine();
                    user = null;
                    return;
                case 4:
                    System.out.println("***********  Gracias por visitar Cine Metro  ************");
                    user = null;
                    return;
            }
        }
    }
}
