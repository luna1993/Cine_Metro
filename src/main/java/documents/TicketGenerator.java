package documents;

import lombok.Getter;
import lombok.Setter;
import ticket.Cartelera;
import ticket.Pelicula;
import ticket.Productos;
import ticket.Ticket;

import java.io.*;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

public class TicketGenerator implements ExportTXT{
    @Getter @Setter
    String ticketText;
    @Getter @Setter
    Ticket ticket;

    public TicketGenerator(Ticket ticketsent){
        ticket = ticketsent;
    }

    public void imprimir(){
        List<Cartelera> carte = Cartelera.obtenerCartelera();
        List<Pelicula> peli = Pelicula.obtenerPeliculas();
        List<Productos> product = Productos.obtenerProductos();

        ticketText = "***************C I N E  M E T R O**********************\n";
        ticketText+= "Cliente: " + ticket.getCliente().getIdUsuario() + "\n";
        ticketText+= "Fecha de compra: " + LocalDateTime.now() + "\n";
        ticketText+= "*******************************************************\n";
        if(ticket.getIdCartelera() != -1){
            ticketText+= "Pelicula: " + peli.get(carte.get(ticket.getIdCartelera()).getIdPelicula()).getNombrePelicula() + "\n";
            ticketText+= "Horario: " + carte.get(ticket.getIdCartelera()).getHorarioCartelera() + "\n";
        } else{
            ticketText+= "Pelicula no comprada\n";
        }
        ticketText+= "*******************************************************\n";
        if(ticket.getIdProducto() != -1){
            ticketText+= "Dulceria: " + product.get(ticket.getIdProducto()).getNombreProducto() + " - " + product.get(ticket.getIdProducto()).getTipoProducto() + "\n";
            ticketText+= "Precio: " + product.get(ticket.getIdProducto()).getPrecioProducto() + "\n";
        } else{
            ticketText+= "Dulceria no comprada\n";
        }

        System.out.println(ticketText);
    }

    public void sendTicket(){
        var filetoSend = new EmailSender();
        filetoSend.setFile(toTXT());
        if (filetoSend.sendEmail(ticket.getCliente().getCorreo(), "Cine Metro Ticket", "El ticket de su compra se encuentra adjuntado")){
            System.out.println("Ticket enviado a su correo");
        } else {
            System.err.println("El envio de ticket a fallado|");
        }
    }

    @Override
    public File toTXT() {
        String txt = System.getProperty("user.dir") + "\\Ticket.txt";
        File file = new File(txt);

        if (file.exists()) {
            file.delete();
        }

        try {
            PrintWriter writer = new PrintWriter(txt, "UTF-8");
            writer.println(ticketText);
            writer.close();

        } catch (IOException e){
            System.err.println("An error occurred.");
            e.printStackTrace();
        }

        return file;
    }
}
