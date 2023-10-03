package co.com.tienda_epica.test;

import co.com.tienda_epica.conexion.Conexion;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try (Connection connect = conexion.get_connection()){

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
