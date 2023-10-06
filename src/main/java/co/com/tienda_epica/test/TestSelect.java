package co.com.tienda_epica.test;

import co.com.tienda_epica.service.ProductoService;

public class TestSelect {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();

        ProductoService.listarProductos();
    }
}
