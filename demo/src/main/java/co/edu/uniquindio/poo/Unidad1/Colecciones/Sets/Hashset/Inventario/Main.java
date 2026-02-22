package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.Hashset.Inventario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Crear clase Producto con codigo, nombre y precio, definiendo igualdad basada únicamente en codigo. 
Usar HashSet<Producto> para evitar productos duplicados, implementar búsqueda y eliminación por código, 
y recorrer con Iterator para eliminar productos cuyo precio sea menor a un valor dado usando Iterator.remove(). 
Se evalúa manejo correcto de eliminación en colecciones.
*/

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Producto producto1 = new Producto("Laptop", "001", 1500.00);
        Producto producto2 = new Producto("Smartphone", "002", 800.00);
        Producto producto3 = new Producto("Tablet", "003", 400.00);
        Producto producto4 = new Producto("movile", "004", 1500.00);
        Producto producto5 = new Producto("alexa", "005", 500.00);

        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.agregarProducto(producto4);
        inventario.agregarProducto(producto5);

        System.out.println("\nInventario actual:");
        inventario.consultarInventario();

        System.out.println("\nEliminando producto con código 002:");
        inventario.eliminarProducto("002");

        System.out.println("\nInventario después de eliminar el producto con código 002:");
        inventario.consultarInventario();

        inventario.eliminarProductoMenorPrecio(1000.00);
        System.out.println("\nInventario después de eliminar productos con precio menor a 1000.00:");
        inventario.consultarInventario();
    }
}

class Producto {
    private String nombre;
    private final String codigo;
    private double precio;

    public Producto(String nombre, String codigo, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
    }

    @Override
    public int hashCode() {
        return codigo.hashCode(); // permite generar el codigo hash del atributo en especifico
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // se encarga de verificar si son el mismo objeto
        if (obj == null || getClass() != obj.getClass())
            return false; // verifica que no sea null y del mismo tipo
        Producto that = (Producto) obj; // se indica que obj sea del tipo Producto para evitar errores
        return codigo.equals(that.codigo); // compara el atributo id
    }
}

class Inventario {
    private Set<Producto> productos = new HashSet<>();

    public Producto consultarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String codigo) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.getCodigo().equals(codigo)) {
                it.remove(); // elimina el producto actual del set
                return; // salir después de eliminar el producto
            }
        }
    }

    public void eliminarProductoMenorPrecio(double precio) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.getPrecio() < precio) {
                it.remove(); // elimina el producto actual del set
            }
        }
    }

    public void consultarInventario() {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
