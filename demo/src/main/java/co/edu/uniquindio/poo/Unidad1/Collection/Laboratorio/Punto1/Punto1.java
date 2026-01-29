package co.edu.uniquindio.poo.Unidad1.Collection.Laboratorio.Punto1;

import java.util.TreeSet;

/*
Crear la lista de productos en una clase empresa utilizando treeset, se debe realizar un método que busque un producto por su código.

*/
class Producto implements Comparable<Producto> {
    private String nombre;
    private int id;
    private String cantidad;

    public Producto(String nombre, int id, String cantidad) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto [nombre: " + nombre + ", id: " + id + ", cantidad: " + cantidad + "]";
    }

    @Override
    public int compareTo(Producto o) {
        if (this.id > o.id) {
            return 1;
        }

        if (this.id < o.id) {
            return -1;
        }
        return 0;
    }
}

class Empresa {
    private String nombre;
    private TreeSet<Producto> productos = new TreeSet<>();

    public Empresa(String nombre, TreeSet<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean busquedaProducto(int id) {
        boolean flag = false;

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                flag = true;
                System.out.println(producto);
            }
        }

        return flag;
    }
}

public class Punto1 {
    public static void main(String[] args) {

        TreeSet<Producto> productos = new TreeSet<>();

        Empresa empresa = new Empresa("Empresa 1", productos);

        Producto producto1 = new Producto("Producto 1", 1, "10");
        Producto producto2 = new Producto("Producto 2", 2, "20");
        Producto producto3 = new Producto("Producto 3", 3, "30");

        empresa.agregarProducto(producto1);
        empresa.agregarProducto(producto2);
        empresa.agregarProducto(producto3);

        empresa.busquedaProducto(2);

    }
}