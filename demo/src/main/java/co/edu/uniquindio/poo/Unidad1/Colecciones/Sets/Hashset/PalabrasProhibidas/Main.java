package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.Hashset.PalabrasProhibidas;

import java.util.HashSet;
import java.util.Set;

/*
Implementar un Set<String> con palabras prohibidas y un método contienePalabraProhibida(String mensaje)
 que divida el mensaje y valide usando contains(). Se evalúa comprensión de búsquedas en tiempo constante O(1)
y aplicación práctica de conjuntos para validación eficiente.
*/

public class Main {
    public static void main(String[] args) {

        String mensaje = "pinches policias pendejos de mierda";
        // filtrar: pinches, pendejos, mierda

        Set<String> palabrasProhibidas = new HashSet<>();
        palabrasProhibidas.add("pinches");
        palabrasProhibidas.add("pendejos");
        palabrasProhibidas.add("mierda");
        palabrasProhibidas.add("putos");

        boolean contienePalabraProhibida = contienePalabraProhibida(mensaje, palabrasProhibidas);
        System.out.println("el mensaje: " + mensaje + " continene palabras prohibidad? : " + contienePalabraProhibida);
    }

    public static boolean contienePalabraProhibida(String mensaje, Set<String> palabrasProhibidas) {

        /*
         * hay varias formas de separar las palabras de un mensaje y evitar que se
         * cuelen caracteres especiales, pero esta es una forma sencilla de hacerlo
         * usando expresiones regulares para dividir el mensaje por espacios en blanco,
         * ademas se dividir signos de exclamacion, interrogacion, comas, puntos, etc. y
         * convertir todo a minusculas para evitar problemas de mayusculas y minusculas
         * al comparar las palabras con el set de palabras prohibidas.
         * 
         * [\\s,\\.\\?!]+ ]
         * 
         */
        
        String[] palabras = mensaje.toLowerCase().split("\\s+");

        for (String palabra : palabras) {
            if (palabrasProhibidas.contains(palabra)) {
                return true;
            }
        }
        return false;
    }
}
