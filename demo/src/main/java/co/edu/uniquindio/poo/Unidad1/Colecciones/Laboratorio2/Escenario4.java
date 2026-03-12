package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio2;

import java.util.*;

class Producto implements Comparable<Producto> {

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto p) {
        int cmp = Double.compare(this.precio, p.precio);
        if (cmp == 0) {
            return this.codigo.compareTo(p.codigo);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - $" + precio;
    }
}

class CatalogoProductos {

    private Map<String, Producto> indiceCodigo = new HashMap<>();
    private TreeSet<Producto> indicePrecio = new TreeSet<>();

    public void insertarProducto(Producto p) {

        indiceCodigo.put(p.getCodigo(), p);

        indicePrecio.add(p);
    }

    /**
     * Busca un producto por su código usando HashMap
     * Complejidad: O(1) - búsqueda directa en HashMap
     */
    public Producto buscarPorCodigo(String codigo) {
        return indiceCodigo.get(codigo);
    }

    /**
     * Retorna todos los productos ordenados por precio (y por código en caso de
     * empate)
     * Complejidad: O(n) - copia del TreeSet que mantiene el orden automáticamente
     */
    public List<Producto> mostrarOrdenadosPorPrecio() {
        return new ArrayList<>(indicePrecio);
    }
}

public class Escenario4 {

    public static void main(String[] args) {

        CatalogoProductos catalogo = new CatalogoProductos();

        catalogo.insertarProducto(new Producto("P01", "Laptop", 3500));
        catalogo.insertarProducto(new Producto("P02", "Mouse", 70));
        catalogo.insertarProducto(new Producto("P03", "Teclado", 150));
        catalogo.insertarProducto(new Producto("P04", "Monitor", 900));

        System.out.println("Busqueda por codigo:");
        System.out.println(catalogo.buscarPorCodigo("P02"));

        System.out.println("\nProductos ordenados por precio:");
        catalogo.mostrarOrdenadosPorPrecio().forEach(System.out::println);
    }
}
