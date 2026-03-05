package co.edu.uniquindio.poo.Unidad1.Genericos.IteradorPropio;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ejemplo de uso del iterador maximo
        Collection<Integer> numeros = List.of(3, 1, 4, 1, 5, 9);
        MaxIterator<Integer> maxIterator = new MaxIterator<>(numeros);
        Integer maximo = maxIterator.getMax();
        System.out.println("El número máximo es: " + maximo);

        // ejemplo de uso del iterador maximo con cadenas
        Collection<String> palabras = List.of("manzana", "banana", "cereza", "durazno");
        MaxIterator<String> maxIteratorString = new MaxIterator<>(palabras);
        String maximoString = maxIteratorString.getMax();
        System.out.println("La palabra máxima es: " + maximoString);

        // ejemplo de uso del iterador maximo con objetos personalizados
        Collection<Persona> personas = List.of(new Persona("Alice", 30), new Persona("Bob", 25),
                new Persona("Charlie", 35));
        MaxIterator<Persona> maxIteratorPersona = new MaxIterator<>(personas);
        Persona maximoPersona = maxIteratorPersona.getMax();
        System.out.println("La persona con la edad máxima es: " + maximoPersona);
    }

}

class MaxIterator<T extends Comparable<T>> {
    private Collection<T> collection;

    public MaxIterator(Collection<T> collection) {
        this.collection = collection;
    }

    public T getMax() {

        // se encarga de ejecutar el metodo solo si existe una coleccion
        // o si la collecion no esta vacia
        if (collection == null || collection.isEmpty()) {
            return null;
        }

        // se implementa el iterator normalmente
        Iterator<T> iterator = collection.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            /*
             * se usa una variable de apoyo
             * 
             * @param current current con el fin de comparar tanto el elemento actual como
             * el siguiente, esto mediante el metodo compareTo()
             */
            T current = iterator.next();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}

class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona other) {
        return Integer.compare(this.edad, other.edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}