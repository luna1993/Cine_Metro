package ticket;

import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cartelera {

  @Getter @Setter
  private int idProgramacion;
  @Getter @Setter
  private int idPelicula;
  @Getter @Setter
  private LocalDateTime horarioCartelera;

  private static List<Cartelera> carteleraList = new ArrayList<>();

  public static List<Cartelera> obtenerCartelera(){
    return carteleraList;
  }

  public void llenadoCartelera(){
    añadirCartelera(0, 0, "2022-03-07", "11:00");
    añadirCartelera(1, 2, "2022-03-07", "15:00");
    añadirCartelera(2, 1, "2022-03-08", "11:00");
    añadirCartelera(3, 0, "2022-03-08", "15:00");
    añadirCartelera(4, 2, "2022-03-09", "11:00");
    añadirCartelera(5, 4, "2022-03-09","15:00");
    añadirCartelera(6, 2, "2022-03-10", "11:00");
    añadirCartelera(7, 3, "2022-03-10", "15:00");
    añadirCartelera(8, 4, "2022-03-11", "11:00");
    añadirCartelera(9, 3, "2022-03-11", "15:00");
  }

  public void añadirCartelera(int idC, int idPeli, String fecha, String hora){
    Cartelera carte = new Cartelera();
    carte.setIdProgramacion(idC);
    carte.setIdPelicula(idPeli);
    carte.setHorarioCartelera(LocalDateTime.parse(fecha +" " + hora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    carteleraList.add(carte);
  }

  public void imprimirPantalla() {
    System.out.println("*****************C A R T E L E R A*********************");
    List<Pelicula> pelis = Pelicula.obtenerPeliculas();
    for (Cartelera carte: obtenerCartelera()) {
      Pelicula peliActual = pelis.get(carte.getIdPelicula());
      System.out.println("* " + (carte.getIdProgramacion()+1) + " - " + peliActual.getNombrePelicula() + " - " + GeneroPelicula.obtenerGeneros().get(peliActual.getIdGenero()).getNombreGenero() + " - " + peliActual.getDuracion() + " horas - " + carte.getHorarioCartelera());
    }
  }
}
