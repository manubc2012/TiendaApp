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
        ProductoDao.listarProductosDB();
    }

    public static void modificarProducto(){
        System.out.println("Indique para modificar 1. Nombre \n 2. Descripcióm \n 3.Precio \n 4. Costo \n 5. Cantiad");
        int opc = sc.nextInt();
        sc.skip("\n");
        int id;
        Producto update =new Producto();

        switch (opc){
            case 1:
                System.out.println("Modificar nombre");
                System.out.println("Ingrese el nuevo valor");
                String nombre = sc.next();
                System.out.println("Indique el id del producto a actualizar");
                id = sc.nextInt();
                sc.skip("\n");
                opc=1;
                update.setOpc(opc);
                update.setNombreProducto(nombre);
                update.setIdProducto(id);
                ProductoDao.modificarProductoDB(update);
                break;
            case 2:
                System.out.println("Modificar descripción");
                System.out.println("Ingrese el nuevo valor");
                String descripcion = sc.nextLine();
                System.out.println("Indique el id del producto a actualizar");
                id = sc.nextInt();
                opc=2;
                update.setOpc(opc);
                update.setDescripcionProducto(descripcion);
                update.setIdProducto(id);
                ProductoDao.modificarProductoDB(update);
                break;
            case 3:
                System.out.println("Modificar Precio");
                System.out.println("Ingrese el nuevo valor");
                double precio = sc.nextDouble();
                System.out.println("Indique el id del producto a actualizar");
                id = sc.nextInt();

                opc=3;
                update.setOpc(opc);
                update.setPrecio(precio);
                update.setIdProducto(id);
                ProductoDao.modificarProductoDB(update);
                break;
            case 4:
                System.out.println("Modificar Costo");
                System.out.println("Ingrese el nuevo valor");
                double costo = sc.nextDouble();
                System.out.println("Indique el id del producto a actualizar");
                id = sc.nextInt();

                opc=4;
                update.setOpc(opc);
                update.setCosto(costo);
                update.setIdProducto(id);
                ProductoDao.modificarProductoDB(update);
                break;
            case 5:
                System.out.println("Modificar Cantidad");
                System.out.println("Ingrese el nuevo valor");
                double cantidad = sc.nextDouble();
                System.out.println("Indique el id del producto a actualizar");
                id = sc.nextInt();

                opc=5;
                update.setOpc(opc);
                update.setCantidad(cantidad);
                update.setIdProducto(id);
                ProductoDao.modificarProductoDB(update);
                break;
            default:
                System.out.println("Opción no válida");
        }

    }

    public static void eliminarProducto(){
        System.out.println("Indique el id del producto a borrar");
        int idProducto=sc.nextInt();
        ProductoDao.eliminarProductoDB(idProducto);
    }
}
