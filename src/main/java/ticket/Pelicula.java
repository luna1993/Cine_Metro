package ticket;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
  @Getter @Setter
  private int idPelicula;
  @Getter @Setter
  private String nombrePelicula;
  @Getter @Setter
  private int idGenero;
  @Getter @Setter
  private double duracion;
  @Getter @Setter
  private int clasificacion;

  private static List<Pelicula> peliculasList = new ArrayList<>();

  public static List<Pelicula> obtenerPeliculas(){
    return peliculasList;
  }

  public void llenadoPelicula(){
    añadirPelicula(0,"Bajo el mismo cielo", 0, 2.8, 2);
    añadirPelicula(1, "Son como niños", 1, 3, 3);
    añadirPelicula(2, "Avengers", 2, 3.25, 2);
    añadirPelicula(3, "Anabel", 3, 2.75, 4);
    añadirPelicula(4, "No mires arriba", 4,1.47, 1);
  }

  public void añadirPelicula(int idPeli, String nombre, int idGenre, double length, int clasification){
    Pelicula peli = new Pelicula();
    peli.setIdPelicula(idPeli);
    peli.setNombrePelicula(nombre);
    peli.setIdGenero(idGenre);
    peli.setDuracion(length);
    peli.setClasificacion(clasification);
    peliculasList.add(peli);
  }
}
