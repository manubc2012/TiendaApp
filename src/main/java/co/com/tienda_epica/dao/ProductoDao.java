package co.com.tienda_epica.dao;

import co.com.tienda_epica.conexion.Conexion;
import co.com.tienda_epica.model.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDao {
    public static void crearProductoDB(Producto registro){
        Conexion connect = new Conexion();

        try(Connection conexion = connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query ="INSERT INTO productos(NOMBRE, despcripcion, precio, costo, cantidad)VALUES(?,?,?,?,?)";
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

    }

    public static void modificarProductoDB(){

    }

    public static void eliminarProductoDB(){

    }
}
