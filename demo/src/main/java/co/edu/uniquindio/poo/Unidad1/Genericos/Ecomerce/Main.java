package co.edu.uniquindio.poo.Unidad1.Genericos.Ecomerce;
/*
Un e-comerce necesita un carrito de compras generico donde :

se pueda agregar productos
Obtener el producto de mayor precio
Calcular el precio total
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CARRITO DE COMPRAS ===\n");

        // Crear un carrito de compras genérico
        CarritoCompras<Producto> carrito = new CarritoCompras<>();

        // Crear productos
        Producto laptop = new Producto("Laptop Dell", 1200000, "Electrónica");
        Producto mouse = new Producto("Mouse Logitech", 45000, "Accesorios");
        Producto teclado = new Producto("Teclado Mecánico", 180000, "Accesorios");
        Producto monitor = new Producto("Monitor LG 27\"", 650000, "Electrónica");
        Producto auriculares = new Producto("Auriculares Sony", 95000, "Audio");

        // Agregar productos al carrito
        System.out.println("--- Agregando productos al carrito ---");
        carrito.agregarProducto(laptop);
        carrito.agregarProducto(mouse);
        carrito.agregarProducto(teclado);
        carrito.agregarProducto(monitor);
        carrito.agregarProducto(auriculares);

        // Mostrar todos los productos
        carrito.mostrarProductos();

        // Obtener el producto de mayor precio
        System.out.println("\n--- Producto de mayor precio ---");
        Producto productoMasCaro = carrito.obtenerProductoMayorPrecio();
        if (productoMasCaro != null) {
            System.out.println("El producto más caro es: " + productoMasCaro.getNombre() +
                    " con un precio de $" + productoMasCaro.getPrecio());
        }

        // Calcular el precio total
        System.out.println("\n--- Precio total del carrito ---");
        double precioTotal = carrito.calcularPrecioTotal();
        System.out.println("Total a pagar: $" + precioTotal);
        System.out.println("Cantidad de productos: " + carrito.getCantidadProductos());

        // Simular otra compra
        System.out.println("\n\n=== NUEVA COMPRA ===\n");
        CarritoCompras<Producto> carrito2 = new CarritoCompras<>();

        carrito2.agregarProducto(new Producto("Smartphone", 850000, "Electrónica"));
        carrito2.agregarProducto(new Producto("Funda", 25000, "Accesorios"));
        carrito2.agregarProducto(new Producto("Cargador", 35000, "Accesorios"));

        carrito2.mostrarProductos();

        System.out.println("\n--- Resumen de compra ---");
        System.out.println("Producto más caro: " + carrito2.obtenerProductoMayorPrecio().getNombre());
        System.out.println("Total: $" + carrito2.calcularPrecioTotal());
    }
}
