package co.com.tienda_epica.dao;

import co.com.tienda_epica.conexion.Conexion;
import co.com.tienda_epica.model.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {
    public static void crearProductoDB(Producto registro){
        Conexion connect = new Conexion();

        try(Connection conexion = connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query ="INSERT INTO producto(nombre, descripcion, precio, costo, cantidad)VALUES(?,?,?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,registro.getNombreProducto());
                ps.setString(2,registro.getDescripcionProducto());
                ps.setDouble(3,registro.getPrecio());
                ps.setDouble(4,registro.getCosto());
                ps.setDouble(5,registro.getCantidad());

                ps.executeUpdate();

                System.out.println("Registro de producto exitoso");
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

    }
    public static void listarProductosDB(){
        Conexion conexion= new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;

        try (Connection connect = conexion.get_connection()){
            String query = "SELECT * FROM producto";
            ps = connect.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("Id producto: " + rs.getInt("Id"));
                System.out.println("Nombre del producto: " + rs.getString("nombre"));
                System.out.println("Descripcion del producto: " + rs.getString("descripcion"));
                System.out.println("Costo del producto: " + rs.getDouble("costo"));
                System.out.println("Cantidad del producto: " + rs.getDouble("cantidad"));
                System.out.println("-------------------------------------------------------");
            }
        }catch (SQLException e){
            System.out.println("No se recuperaron registros");
            System.out.println(e);
        }
    }

    public static void modificarProductoDB(Producto update){

    }

    public static void eliminarProductoDB(int idProducto){
        Conexion conexion = new Conexion();

        try(Connection connect = conexion.get_connection()){
            PreparedStatement ps= null;
            try {
                String query = "DELETE FROM producto where producto.Id =?";
                ps = connect.prepareStatement(query);
                ps.setInt(1, idProducto);
                ps.executeUpdate();
                System.out.println("El registro ha sido eliminado");
            }catch (SQLException e){
                System.out.println("No se eliminó el regisro");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
