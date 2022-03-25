package ticket;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeliculaTest {

    @Test
    public void añadirPeliculaTest() {
        Pelicula pelicula=new Pelicula();
        pelicula.añadirPelicula(15,"Doctor Strange",3,2,2);
    }
}