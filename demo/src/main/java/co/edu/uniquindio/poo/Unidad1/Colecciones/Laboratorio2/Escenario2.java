package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Escenario2 {
    public static void main(String[] args) {
        System.out.println("uwu");
        Platarformaventas plataforma = new Platarformaventas();
        Producto producto1 = new Producto("Laptop", "P001", 1500.0, "Electronica");
        Producto producto2 = new Producto("Smartphone", "P002", 800.0, "Electronica");
        Producto producto3 = new Producto("Camiseta", "P003", 20.0, "Ropa");
        Producto producto4 = new Producto("Pantalon", "P004", 30.0, "Ropa");
        Producto producto5 = new Producto("Audifonos", "P005", 100.0, "Electronica");

        plataforma.agregarProducto(producto1);
        plataforma.agregarProducto(producto2);
        plataforma.agregarProducto(producto3);
        plataforma.agregarProducto(producto4);
        plataforma.agregarProducto(producto5);

        System.out.println("\nBuscar producto por código:");
        System.out.println(plataforma.buscarCodigoProducto("P002"));

        System.out.println("\nProductos filtrados por categoria:");
        System.out.println("\nElectronica:");
        plataforma.filtrarCategoria("Electronica");
        System.out.println("\nRopa:");
        plataforma.filtrarCategoria("Ropa");

        System.out.println("\nProductos ordenados por precio:");
        plataforma.mostrarOrdenPrecio();
    }
}

/*
 * orden precio: treemap / treeset
 * busqueda y filtrar categoria: hashmap
 * insertar: list
 */
class Platarformaventas {
    private List<Producto> productos = new ArrayList<>();

    public Platarformaventas() {
    }

    public void agregarProducto(Producto producto) {
        productos.addFirst(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Producto buscarCodigoProducto(String id) {
       // Map<String, Producto> busquedaCodigo = new HashMap<>();

        for (Producto producto : productos) {
            if (producto.getId().toLowerCase().equals(id.toLowerCase())) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarOrdenPrecio() {
        //Set<Producto> ordenPrecio = new TreeSet<>(productos);

        productos.sort(Producto::compareTo);

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void filtrarCategoria(String categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
                System.out.println(producto);
            }
        }
    }
}

class Producto implements Comparable<Producto> {
    private String nombre;
    private String id;
    private double precio;
    private String categoria;

    public Producto(String nombre, String id, double precio, String categoria) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", categoria=" + categoria + "]";
    }

    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.precio, o.getPrecio());
    }
}