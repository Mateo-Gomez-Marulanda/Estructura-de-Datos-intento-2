package co.edu.uniquindio.poo.Unidad1.Recursividad.Matriurska;

// solo se crean dos metodos con el mismo nombre en elixir NO CONFUNDIR 

public class Main {
    public static void main(String[] args) {
        abrirMuneca(5);
    }

    public static void abrirMuneca(int munecas) {
        // casp base
        if (munecas == 0) {
            System.out.println("ya no hay munecas");
            return; // se indica la parada de la recursividad
            
        }

        // aplicacion de recursividad
        System.out.println("abriando muneca " + munecas);
        abrirMuneca(munecas - 1); // llamado recursivo
        System.out.println("cerrando muneca " + munecas);
    }
}
