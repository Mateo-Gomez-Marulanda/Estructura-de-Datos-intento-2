package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear repositorio y agregar elementos
        Repositorio<String> repo = new Repositorio<>();
        repo.agregar("Primero");
        repo.agregar("Segundo");
        repo.agregar("Tercero");
        repo.agregar("Cuarto");

        // Recorrido normal con for-each
        System.out.println("Recorrido normal (for-each):");
        for (String elemento : repo) {
            System.out.println(elemento);
        }

        System.out.println("\nRecorrido inverso (iterador personalizado):");
        // Recorrido inverso con iterador personalizado
        Iterator<String> iteradorInverso = repo.iteradorInverso();
        while (iteradorInverso.hasNext()) {
            System.out.println(iteradorInverso.next());
        }
    }
}

class Repositorio<T> implements Iterable<T> {
    private List<T> lista = new ArrayList<>();

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public T obtener(int indice) {
        return lista.get(indice);
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }

    public void recorrer() {
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }

    /**
     * Iterador personalizado que recorre la lista de atrás hacia adelante
     * 
     * @return Iterator que recorre en orden inverso
     */
    public Iterator<T> iteradorInverso() {
        return new IteradorInverso();
    }

    /**
     * Clase interna que implementa un iterador inverso
     */
    private class IteradorInverso implements Iterator<T> {
        private int indiceActual = lista.size() - 1;

        @Override
        public boolean hasNext() {
            return indiceActual >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T elemento = lista.get(indiceActual);
            indiceActual--;
            return elemento;
        }
    }
}
