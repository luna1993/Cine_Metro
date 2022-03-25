package ticket;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneroPeliculaTest {

    @Test()
    public void añadirGeneroTest() {
        GeneroPelicula gp=new GeneroPelicula();
        gp.añadirGenero(6,"Documental");
    }
}