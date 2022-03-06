import lombok.Getter;
import lombok.Setter;

public class Pelicula {
  @Getter @Setter
  private int idPelicula;
  @Getter @Setter
  private int idGenero;
  @Getter @Setter
  private int duracion;
  @Getter @Setter
  private int clasificacion;
}
