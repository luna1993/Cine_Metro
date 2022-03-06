import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.Random;
import java.util.Scanner;

public class Ticket {
    @Getter @Setter
    private String IdTicket;
    @Getter @Setter
    private String IdCliente;
    @Getter @Setter
    private int IdCartelera;
    @Getter @Setter
    private int IdProducto;

    public static void main(String[] args){
        Ticket t=new Ticket();
        t.GenerarTicket();
    }
    public void GenerarTicket(){
        Ticket t=new Ticket();
        Cliente c=new Cliente();
        t.Aleatorio();
        c.GuardarCliente();
        t.CrearOrden();
        t.CrearTicket(t.getIdTicket(),c.getIdCliente(), t.getIdCartelera(), t.getIdProducto());
    }
    public void CrearOrden(){
        Cliente c=new Cliente();
        Scanner sc=new Scanner(System.in);
        Ticket t=new Ticket();

        System.out.println("Seleccione Funcion: ");
        this.IdCartelera=sc.nextInt();
        System.out.println("LLeva producto de la dulceria: 1.si 2.No");
        int opc=sc.nextInt();
        if(opc==1){
            System.out.println("Seleccione El producto que desea ordenar");
            this.IdProducto=sc.nextInt();
        }else{
            this.IdProducto=0;
        }
    }

    public void CrearTicket(String IdTicket, String IdCliente, int IdCartelera, int IdProducto){
        System.out.println("Su ticket es: "+IdTicket);
        System.out.println("El cliente: "+IdCliente);
        System.out.println("La funcion seleccionada es: "+IdCartelera);
        System.out.println("Producto de Dulceria: "+IdProducto);
    }

    public void Aleatorio(){
        int min=1;
        int max=30;
        Random r=new Random();
        int value=r.nextInt(max+min)+min;
        String codigo="Kod"+value;
        this.IdTicket= codigo;
    }


}
