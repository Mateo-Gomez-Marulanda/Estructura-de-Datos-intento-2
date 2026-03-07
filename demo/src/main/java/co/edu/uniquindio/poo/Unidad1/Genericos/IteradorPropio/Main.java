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

        // ejemplo de uso del iterador propio personalizado
        System.out.println("\n--- Usando Iterador Propio ---");
        Iterador<Integer> iteradorNumeros = new Iterador<>(numeros);
        System.out.println("Máximo con iterador propio: " + iteradorNumeros.getMaximo());

        // Usando el iterador directamente con foreach
        Iterador<String> iteradorPalabras = new Iterador<>(palabras);
        for (String max : iteradorPalabras) {
            System.out.println("Palabra máxima usando foreach: " + max);
        }

        // Con personas usando iterator manual
        Iterador<Persona> iteradorPersonas = new Iterador<>(personas);
        Iterator<Persona> iter = iteradorPersonas.iterator();
        if (iter.hasNext()) {
            System.out.println("Persona máxima: " + iter.next());
        }
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
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
}

/**
 * Iterador propio que implementa Iterable para obtener el mayor elemento
 * de una colección genérica
 */
class Iterador<T extends Comparable<T>> implements Iterable<T> {
    private Collection<? extends T> collection;

    public Iterador(Collection<? extends T> collection) {
        this.collection = collection;
    }

    @Override
    public Iterator<T> iterator() {
        return new MaxElementIterator<>(collection);
    }

    /**
     * Iterador personalizado que encuentra y devuelve solo el elemento máximo
     */
    private static class MaxElementIterator<T extends Comparable<T>> implements Iterator<T> {
        private T maxElement;
        private boolean hasReturned = false;

        public MaxElementIterator(Collection<? extends T> collection) {
            if (collection != null && !collection.isEmpty()) {
                // Encuentra el elemento máximo al crear el iterador
                Iterator<? extends T> iter = collection.iterator();
                maxElement = iter.next();

                while (iter.hasNext()) {
                    T current = iter.next();
                    if (current.compareTo(maxElement) > 0) {
                        maxElement = current;
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            // Solo devuelve true si aún no se ha retornado el máximo
            return maxElement != null && !hasReturned;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No hay más elementos");
            }
            hasReturned = true;
            return maxElement;
        }
    }

    /**
     * Método de conveniencia para obtener directamente el máximo
     * 
     * @return el elemento máximo de la colección o null si está vacía
     */
    public T getMaximo() {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return iterator().next();
    }
}

 