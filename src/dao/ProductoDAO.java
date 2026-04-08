package dao;

import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoDAO {
    private String url = "jdbc:sqlite:activity.sqlite3";

    public void insertarProducto(Producto p) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getCategoria());
            pstmt.setDouble(3, p.getPrecio());
            pstmt.setInt(4, p.getStock());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarProducto(Producto p, int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getCategoria());
            pstmt.setDouble(3, p.getPrecio());
            pstmt.setInt(4, p.getStock());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productos;
    }

    public Map<String, Double> obtenerNombreYPrecio() {
        Map<String, Double> nombrePrecio = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT nombre, precio FROM productos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                nombrePrecio.put(nombre, precio);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return nombrePrecio;
    }

    public List<Producto> obtenerProductosElectronica() {
        List<Producto> productosElectronica = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos WHERE categoria = 'Electrónica'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productosElectronica.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productosElectronica;
    }

    public List<Producto> obtenerProdPrecio100() {
        List<Producto> productosPrecio100 = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos WHERE precio > 100.00";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productosPrecio100.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productosPrecio100;
    }

    public List<Producto> obtenerProdStock10() {
        List<Producto> productosStock10 = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos WHERE stock < 10";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productosStock10.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productosStock10;
    }

    public List<Producto> obtenerProdA() {
        List<Producto> productosA = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos WHERE nombre LIKE '%a%'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productosA.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productosA;
    }

    public List<Producto> obtenerProdPrecioOrden() {
        List<Producto> productosPrecioOrden = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM productos ORDER BY precio ASC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Producto p = new Producto(nombre, categoria, precio, stock);
                productosPrecioOrden.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productosPrecioOrden;
    }


}
