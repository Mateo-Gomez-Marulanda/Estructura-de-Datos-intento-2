package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio.Punto3;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.List;
import java.util.Set;

/*
*Crear una lista de elementos que no permite duplicados e imprima el contenido de la lista usando iteradores.
*/

public class Punto3 {
    public static void main(String[] args) {

        // List<Integer> lista = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        set.add(5);
        set.add(55);
        set.add(53);
        set.add(35);
        set.add(5);

        Iterator<Integer> it = set.iterator();

        // imprimir mediante iterators
        while (it.hasNext()) {
            Integer x = it.next();
            System.out.println(x);
        }
    }
}
