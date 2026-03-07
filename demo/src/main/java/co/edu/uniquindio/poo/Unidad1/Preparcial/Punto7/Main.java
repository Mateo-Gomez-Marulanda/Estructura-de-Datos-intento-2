package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto7;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        Comparador<Integer> comparador = new ImplementacionComparador<>();
        int resultado = comparador.comparar(a, b);
        System.out.println(resultado );

        String str1 = "Hola";
        String str2 = "Mundo";
        Comparador<String> comparadorString = new ImplementacionComparador<>();
        int resultadoString = comparadorString.comparar(str1, str2);
        System.out.println(resultadoString);

        double d1 = 3.14;
        double d2 = 2.71;
        Comparador<Double> comparadorDouble = new ImplementacionComparador<>();
        int resultadoDouble = comparadorDouble.comparar(d1, d2);
        System.out.println(resultadoDouble);
    }
}

interface Comparador<T> {
    int comparar(T t1, T t2);
}

class ImplementacionComparador<T extends Comparable<T>> implements Comparador<T> {

    @Override
    public int comparar(T t1, T t2) {
        return t1.compareTo(t2);
    }
}
