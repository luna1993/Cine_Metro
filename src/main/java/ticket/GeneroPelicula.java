package ticket;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GeneroPelicula {

  @Getter @Setter
  private int idGeneroPelicula;
  @Getter @Setter
  private String nombreGenero;

  private static List<GeneroPelicula> generosList = new ArrayList<>();

  public static List<GeneroPelicula> obtenerGeneros() {
    return generosList;
  }

  public void llenadoGeneroPelicula(){
    añadirGenero(0, "Romance");
    añadirGenero(1, "Comedia");
    añadirGenero(2, "Accion");
    añadirGenero(3, "Terror");
    añadirGenero(4, "Ciencia Ficcion");
  }

  public void añadirGenero(int idGenre, String name){
    GeneroPelicula genPeli = new GeneroPelicula();
    genPeli.setIdGeneroPelicula(idGenre);
    genPeli.setNombreGenero(name);
    generosList.add(genPeli);
  }
}
