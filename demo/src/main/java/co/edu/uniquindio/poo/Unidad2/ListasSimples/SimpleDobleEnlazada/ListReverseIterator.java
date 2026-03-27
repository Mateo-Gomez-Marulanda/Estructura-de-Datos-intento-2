package co.edu.uniquindio.poo.Unidad2.ListasSimples.SimpleDobleEnlazada;

import java.util.Iterator;

public class ListReverseIterator<T> implements Iterator<T> {
    private Node<T> aux;

    public ListReverseIterator(Node<T> aux) {
        this.aux = aux;
    }

    @Override
    public boolean hasNext() {
        return aux != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        T data = aux.getdata();
        aux = aux.getPreviousNode();  // ← Ir al anterior, no al siguiente
        return data;
    }
}
