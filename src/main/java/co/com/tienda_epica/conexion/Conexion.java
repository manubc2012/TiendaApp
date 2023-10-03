package co.com.tienda_epica.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection(){
        Connection connect = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_epica", "root", "");

            if(connect != null){
                System.out.println("La conexion ha sido exitosa");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return connect;
    }
}
