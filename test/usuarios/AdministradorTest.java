package usuarios;

import static org.junit.Assert.*;

public class AdministradorTest {

    @org.junit.Test
    public void testiniciarSesion() {
        Administrador adtest= new Administrador();
        Usuario usu=new Usuario();
        usu.llenadoUsuario();
        assertEquals("true",adtest.iniciarSesion("Kodigo001"));
    }

}