package ticket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Productos {

    private int idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private double precioProducto;
    private static List<Productos> productosList = new ArrayList<>();

    public static List<Productos> obtenerProductos(){
        return productosList;
    }

    public void llenadoProductos() {
        añadirProducto(0, "Palomitas Saladas", "Comida Individual", 3.75);
        añadirProducto(1, "Palomitas Dulces", "Comida Individual", 4.00);
        añadirProducto(2, "Palomitas Dulces + sodas", "Combo", 6.00);
        añadirProducto(3, "Palomitas Saladas + sodas", "Combo", 5.75);
        añadirProducto(4, "Gaseosa", "Bebida Individual", 2.25);
        añadirProducto(5, "Frozen", "Bebida Individual", 3.75);
    }
    
    public void añadirProducto(int IdProducto, String NombreProducto, String TipoProducto, double Precio) {
        Productos producto = new Productos();
        producto.setIdProducto(IdProducto);
        producto.setNombreProducto(NombreProducto);
        producto.setTipoProducto(TipoProducto);
        producto.setPrecioProducto(Precio);
        productosList.add(producto);
    }
    
    public void imprimirProductos(){
        System.out.println("************* DULCERIA ***********");
        for (Productos producto : productosList
             ) {
            System.out.println("* " + (producto.getIdProducto()+1) + " - " + producto.getNombreProducto() + " - " + producto.getTipoProducto() + " - " + producto.getPrecioProducto());
        }
    }
}

