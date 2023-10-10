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
        Conexion conexion= new Conexion();
        PreparedStatement ps = null;
        ResultSet rs=null;

        try (Connection connect = conexion.get_connection()){
            String query = "SELECT * FROM productos";
            ps = connect.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("Id producto: " + rs.getInt("Id"));
                System.out.println("Nombre del producto: " + rs.getString("nombre"));
                System.out.println("Descripcion del producto: " + rs.getString("despcripcion"));
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
        Conexion conexion = new Conexion();

        try(Connection connect = conexion.get_connection()){
            PreparedStatement ps=null;
            try {
                int opc = update.getOpc();
                System.out.println(opc);
                if(opc == 1){
                    String query = "UPDATE productos SET NOMBRE = ? WHERE id =?";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getNombreProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("El registro fue actualizado");
                } else if (opc == 2) {
                    String query = "UPDATE productos SET despcripcion = ? WHERE id =?";
                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getDescripcionProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("El registro fue actualizado");
                } else if (opc==3) {
                    String query = "UPDATE productos SET precio = ? WHERE id =?";
                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getPrecio());
                    ps.setInt(2, update.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("El registro fue actualizado");
                }else if (opc==4) {
                    String query = "UPDATE productos SET costo = ? WHERE id =?";
                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getCosto());
                    ps.setInt(2, update.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("El registro fue actualizado");
                }else if (opc==5) {
                    String query = "UPDATE productos SET cantidad = ? WHERE id =?";
                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getCantidad());
                    ps.setInt(2, update.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("El registro fue actualizado");
                }
            }catch (SQLException e){
                System.out.println("No fue posible actualizar el registro");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void eliminarProductoDB(int idProducto){
        Conexion conexion = new Conexion();
        try(Connection connect = conexion.get_connection()){
            PreparedStatement ps= null;
            try {
                String query = "DELETE FROM productos where productos.Id =?";
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
