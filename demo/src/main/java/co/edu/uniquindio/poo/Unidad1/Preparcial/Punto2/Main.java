package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PairList<String, String> pairList = new PairList<>();

        pairList.agregarPar("A", "1");
        pairList.agregarPar("B", "2");
        pairList.agregarPar("C", "3");

        System.out.println("Pares después de agregar:");
        pairList.obtenerPares();

        pairList.eliminarPar("B", "2");

        System.out.println("\nPares después de eliminar:");
        pairList.obtenerPares();
    }
}

class PairList<K, V> {

    private Map<K, V> listaPares = new HashMap<>();

    public void agregarPar(K k, V v) {
        listaPares.put(k, v);
    }

    public void eliminarPar(K k, V v) {
        listaPares.remove(k, v);
    }

    public void obtenerPares() {
        for (Map.Entry<K, V> entry : listaPares.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
