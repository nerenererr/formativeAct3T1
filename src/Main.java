import dao.ProductoDAO;
import modelo.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main  {
    public static void main(String[] args) {

        ProductoDAO pdao = new ProductoDAO();
        System.out.println(pdao.obtenerProdPrecioOrden());





    }
}