import lombok.Setter;
import lombok.Getter;

public class Cartelera {

  @Getter @Setter
  private int idProgramacion;
  @Getter @Setter
  private int idPelicula;
  @Getter @Setter
  private int horarioCartelera;

  public void imprimirPantalla() {}
}
