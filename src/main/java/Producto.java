import lombok.Getter;
import lombok.Setter;

public class Producto {
    @Getter @Setter
    private int IdProducto;
    @Getter @Setter
    private String NombreProducto;
    @Getter @Setter
    private String TipoProducto;
    @Getter @Setter
    private double Precio;

    public void MostrarProductos(){
        System.out.println("* "+getIdProducto()+"*"+getNombreProducto()+"*"+getTipoProducto()+"*"+getPrecio());
    }
    public void MostrarProductos(int IdProducto, String NombreProducto, String TipoProducto, double Precio){

        System.out.println("* "+IdProducto+" - "+NombreProducto+" - "+TipoProducto+" - "+Precio);
    }
    public void GenerarMenu(){
        Producto p=new Producto();
        System.out.println("************* DULCERIA ***********");
        p.MostrarProductos(1,"Palomitas Saladas","Comida Individual",3.75);
        p.MostrarProductos(2,"Palomitas Dulces","Comida Individual",4.00);
        p.MostrarProductos(3,"Palomitas Dulces + sodas","Combo",6.00);
        p.MostrarProductos(4,"Palomitas Saladas + sodas","Combo",5.75);
        p.MostrarProductos(5,"Gaseosa","Bebida Individual",2.25);
        p.MostrarProductos(6,"Frozen","Bebida Individual",3.75);
    }


    public static void main(String []args){
        Producto p=new Producto();
        p.GenerarMenu();
    }
}

