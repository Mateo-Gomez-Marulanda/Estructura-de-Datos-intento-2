package co.edu.uniquindio.poo.Unidad1.Genericos.Ecomerce;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica para manejar un carrito de compras
 * T debe extender de Producto para garantizar que tiene el método getPrecio()
 */
public class CarritoCompras<T extends Producto> {
    private List<T> productos;

    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agregar un producto al carrito
     * 
     * @param producto El producto a agregar
     */
    public void agregarProducto(T producto) {
        if (producto != null) {
            productos.add(producto);
            System.out.println("Producto agregado: " + producto.getNombre());
        }
    }

    /**
     * Obtiene el producto de mayor precio en el carrito
     * 
     * @return El producto con el precio más alto, o null si el carrito está vacío
     */
    public T obtenerProductoMayorPrecio() {
        if (productos.isEmpty()) {
            return null;
        }

        T productoMasCaro = productos.get(0);
        for (T producto : productos) {
            if (producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        return productoMasCaro;
    }

    /**
     * Calcula el precio total de todos los productos en el carrito
     * 
     * @return La suma de los precios de todos los productos
     */
    public double calcularPrecioTotal() {
        double total = 0;
        for (T producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    /**
     * Muestra todos los productos en el carrito
     */
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }

        System.out.println("\n=== Productos en el carrito ===");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    /**
     * Obtiene la cantidad de productos en el carrito
     * 
     * @return El número de productos
     */
    public int getCantidadProductos() {
        return productos.size();
    }

    /**
     * Limpia todos los productos del carrito
     */
    public void vaciarCarrito() {
        productos.clear();
        System.out.println("Carrito vaciado");
    }

    public List<T> getProductos() {
        return new ArrayList<>(productos);
    }
}
