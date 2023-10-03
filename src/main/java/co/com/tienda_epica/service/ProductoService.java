package co.com.tienda_epica.service;

import co.com.tienda_epica.dao.ProductoDao;
import co.com.tienda_epica.model.Producto;

import java.util.Scanner;

public class ProductoService {
    static Scanner sc = new Scanner(System.in);

    public static void crearProducto(){
        System.out.println("Ingrese el nombre del producto");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la descripción del producto");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el precio del producto");
        double precio = sc.nextDouble();
        System.out.println("Ingrese el costo del producto");
        double costo = sc.nextDouble();
        System.out.println("Ingrese la cantidad del producto");
        double cantidad = sc.nextDouble();

        Producto registro = new Producto();

        registro.setNombreProducto(nombre);
        registro.setDescripcionProducto(descripcion);
        registro.setPrecio(precio);
        registro.setCosto(costo);
        registro.setCantidad(cantidad);

        ProductoDao.crearProductoDB(registro);
    }
    public static void listarProductos(){

    }

    public static void modificarProducto(){

    }

    public static void eliminarProducto(){

    }
}
