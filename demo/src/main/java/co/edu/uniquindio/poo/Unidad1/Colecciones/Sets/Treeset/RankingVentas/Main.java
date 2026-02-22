package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.Treeset.RankingVentas;

/*
Crear clase Vendedor con id, nombre y ventasTotales, implementando Comparable<Vendedor> para ordenar por ventas en orden descendente. 
Usar TreeSet<Vendedor> para mantener el ranking automáticamente ordenado y mostrar el Top 3 y el mejor vendedor. 
Analizar qué ocurre cuando dos vendedores tienen las mismas ventas y cómo evitar que uno se elimine (comparando también por id).
*/

import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Tech Solutions");

        Vendedor vendedor1 = new Vendedor("Alice", "V001", 150);
        Vendedor vendedor2 = new Vendedor("Bob", "V002", 200);
        Vendedor vendedor3 = new Vendedor("Charlie", "V003", 180);
        Vendedor vendedor4 = new Vendedor("Diana", "V004", 220);
        Vendedor vendedor5 = new Vendedor("Eve", "V005", 170);
        Vendedor vendedor6 = new Vendedor("Frank", "V006", 220); // mismo numero de ventas que Diana para probar el
                                                                 // desempate por id

        empresa.agregarVendedor(vendedor1);
        empresa.agregarVendedor(vendedor2);
        empresa.agregarVendedor(vendedor3);
        empresa.agregarVendedor(vendedor4);
        empresa.agregarVendedor(vendedor5);
        empresa.agregarVendedor(vendedor6);

        System.out.println("Lista de vendedores:");
        empresa.consultarVendedores();

        System.out.println();
        empresa.obtenerMejorVendedor();

        System.out.println("\nMejores 3 vendedores:");
        empresa.consultarMejores3();

    }
}

class Vendedor implements Comparable<Vendedor> {
    private String nombre;
    private String id;
    private int numVentas;

    public Vendedor(String nombre, String id, int numVentas) {
        this.nombre = nombre;
        this.id = id;
        this.numVentas = numVentas;
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

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    @Override
    public String toString() {
        return "Vendedor [nombre=" + nombre + ", id=" + id + ", numVentas=" + numVentas + "]";
    }

    @Override
    public int compareTo(Vendedor vendedor) {
        int comparacion = Integer.compare(vendedor.getNumVentas(), this.numVentas);

        if (comparacion == 0) {
            return this.id.compareTo(vendedor.getId());
        }

        return comparacion;
    }

}

class Empresa {
    private String nombre;
    private TreeSet<Vendedor> vendedores = new TreeSet<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void obtenerMejorVendedor() {
        System.out.println("Mejor vendedor: " + vendedores.first());
    }

    public void consultarMejores3() {
        /*
         * el metodo desending iterator devuelve un iterador que recorre el TreeSet en
         * orden descendente, es decir, desde el vendedor con mas ventas hasta el que
         * tiene menos ventas. cabe aclarar que dicho metodo solo esta disponible en
         * TreeSet, no en HashSet.
         * 
         * este metodo se aplica cuando el orden natural sea de manera asendente, es
         * decir, del vendedor con menos ventas al que tiene mas ventas. en este caso,
         * el orden natural es descendente, por lo que se puede usar el iterador normal.
         * 
         * Iterator<Vendedor> it = vendedores.descendingIterator();
         * int cont = 0;
         * while (it.hasNext() && cont < 3) {
         * System.out.println(it.next()); cont++;
         * }
         */

        Iterator<Vendedor> it = vendedores.iterator();
        int cont = 0;
        while (it.hasNext() && cont < 3) {
            System.out.println(it.next());
            cont++;
        }

    }

    public void consultarVendedores() {
        Iterator<Vendedor> it = vendedores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
