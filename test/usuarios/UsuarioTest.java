package usuarios;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test()
    public void llenadoErroneoUsuarioTest() {
        Usuario usu=new Usuario();
        usu.crearUsuario("Kodigo003","correo@gmail.com","contraseña","prueba","admin");
    }
}