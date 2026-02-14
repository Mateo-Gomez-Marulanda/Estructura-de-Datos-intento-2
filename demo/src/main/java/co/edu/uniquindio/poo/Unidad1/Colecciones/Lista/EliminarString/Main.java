package co.edu.uniquindio.poo.Unidad1.Colecciones.Lista.EliminarString;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("mondongo");
        lista.add("rata");
        lista.add("robinson");
        lista.add("zapayo");

        eliminarElementoR(lista);

        System.out.println(lista);
        // luego de eliminar los elementos
        eliminarR(lista);
        System.out.println(lista);
    }

    // version senior (chatgpt xd)
    private static void eliminarR(ArrayList<String> lista) {
        lista.removeIf(e -> e.startsWith("r"));
    }

    // metodo creando una lista nueva
    private static void eliminarElementoR(ArrayList<String> lista) {

        ArrayList<String> listaSinR = new ArrayList<>();

        // dato curioso un foreach no deja eliminar elementos mientras se ejecuta, pero
        // un for normal si deja
        
        for (String elemento : lista) {
            if (!elemento.startsWith("r")) {
                listaSinR.add(elemento);
            }
        }
        System.out.println(listaSinR);
    }

    // metodo con iteradores

}