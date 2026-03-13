package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.PlayListDinamica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        PlayList<String> playList = new PlayList<>();

        playList.agregarFinal("Cancion 1");
        playList.agregarFinal("Canción 2");
        playList.agregarInicio("Canción 3");

        System.out.println(playList);
        playList.insertarDespues("Cancion 1", "Canción 4");
        System.out.println(playList);
        System.out.println(playList.ultimosReproduciodos(2));

    }
}

class PlayList<T> {
    private List<T> listaReproduccion;

    public PlayList() {
        this.listaReproduccion = new LinkedList<>();
    }

    public void agregarInicio(T elemento) {
        listaReproduccion.addFirst(elemento);
    }

    public void agregarFinal(T elemento) {
        listaReproduccion.addLast(elemento);
    }

    public void insertarDespues(T referencia, T elemento) {
        ListIterator<T> it = listaReproduccion.listIterator();
        while (it.hasNext()) {
            T actual = it.next();
            if (actual.equals(referencia)) {
                it.add(elemento);
                return;
            }
        }
        System.out.println("Referencia no encontrada: " + referencia);
    }

    public void eliminar(T elemento) {
        listaReproduccion.remove(elemento);
    }

    public List<T> ultimosReproduciodos(int n) {
        ListIterator<T> it = listaReproduccion.listIterator(listaReproduccion.size());
        List<T> ultimosReproduciodos = new ArrayList<>();
        int cont = 0;
        while (it.hasPrevious() && cont < n) {
            ultimosReproduciodos.add(it.previous());
            cont++;
        }
        return ultimosReproduciodos;
    }

    @Override
    public String toString() {
        return listaReproduccion.toString();
    }
}
