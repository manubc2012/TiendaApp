package co.com.tienda_epica.test;

import co.com.tienda_epica.service.ProductoService;

public class TestUpdate {
    public static void main(String[] args) {
        ProductoService ps= new ProductoService();
        ProductoService.listarProductos();
        ProductoService.modificarProducto();
    }
}
