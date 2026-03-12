package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio2;

import java.util.*;

class Producto implements Comparable<Producto> {

    private String codigo;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public int compareTo(Producto o) {
        int cmp = Double.compare(this.precio, o.precio);
        if (cmp == 0) {
            return this.codigo.compareTo(o.codigo);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return codigo + " , " + nombre + " , $" + precio + " , " + categoria;
    }
}

class PlataformaVentas {

    private Map<String, Producto> indiceCodigo = new HashMap<>();
    private TreeSet<Producto> indicePrecio = new TreeSet<>();
    private LinkedList<Producto> listaRecientes = new LinkedList<>();
    private Map<String, List<Producto>> indiceCategoria = new HashMap<>();

    public void insertarProducto(Producto p) {

        indiceCodigo.put(p.getCodigo(), p);

        indicePrecio.add(p);

        listaRecientes.addFirst(p);

        indiceCategoria
                .computeIfAbsent(p.getCategoria(), k -> new ArrayList<>())
                .add(p);
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

    public List<Producto> productosRecientes() {
        return listaRecientes;
    }

    /**
     * Filtra productos por categoría usando HashMap de índices
     * Complejidad: O(1) - acceso directo a la lista de productos de la categoría
     */
    public List<Producto> filtrarPorCategoria(String categoria) {
        return indiceCategoria.getOrDefault(categoria, new ArrayList<>());
    }
}

public class Escenario2 {

    public static void main(String[] args) {

        PlataformaVentas sistema = new PlataformaVentas();

        sistema.insertarProducto(new Producto("A1", "Laptop", 3200, "Tecnologia"));
        sistema.insertarProducto(new Producto("A2", "Mouse", 80, "Tecnologia"));
        sistema.insertarProducto(new Producto("B1", "Silla", 450, "Hogar"));
        sistema.insertarProducto(new Producto("B2", "Mesa", 700, "Hogar"));

        System.out.println("Busqueda por codigo:");
        System.out.println(sistema.buscarPorCodigo("A1"));

        System.out.println("\nOrdenados por precio:");
        sistema.mostrarOrdenadosPorPrecio().forEach(System.out::println);

        System.out.println("\nInsertados recientemente:");
        sistema.productosRecientes().forEach(System.out::println);

        System.out.println("\nFiltrar por categoria:");
        sistema.filtrarPorCategoria("Tecnologia").forEach(System.out::println);
    }
}
