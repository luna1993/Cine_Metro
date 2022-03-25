package ticket;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarteleraTest {

    @Test
    public void añadirCarteleraTest() {
        Cartelera ca=new Cartelera();
        ca.añadirCartelera(1,5,"2022-10-10","15:00");
    }
    @Test(expected = Error.class)
    public void verCarteleraTest(){
        Cartelera ca=new Cartelera();
        ca.llenadoCartelera();
        int idrecibido=ca.getIdPelicula();
        int idesperado=3;
        assertEquals(idesperado,idrecibido);
    }
}