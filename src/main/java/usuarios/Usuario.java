package usuarios;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Usuario {
    private String idUsuario;
    private String correo;
    private String contrasena;
    private String nombre;
    private String rol;
    private static List<Usuario> usuarioList = new ArrayList<>();

    public static List<Usuario> obtenerUsuarios(){
        return usuarioList;
    }

    public void crearUsuario(String idUsuario, String correo, String contrasena, String nombre, String rol){
        Usuario usu= new Usuario();
        usu.setIdUsuario(idUsuario);
        usu.setCorreo(correo);
        usu.setContrasena(contrasena);
        usu.setNombre(nombre);
        usu.setRol(rol);
        usuarioList.add(usu);
    }
    public  void llenadoUsuario(){
        crearUsuario("kodigo001","eladmin@gmail.com","admin123","Juanito","admin");
        crearUsuario("kodigo002","eluser@gmail.com","user123","pedro","cliente");
    }
}
