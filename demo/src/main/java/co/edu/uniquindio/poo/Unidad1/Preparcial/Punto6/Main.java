package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto6;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 1, 4, 1, 5, 9);
        Integer maximo = maximo(numeros);
        System.out.println("El elemento máximo es: " + maximo);

        List<String> palabras = List.of("manzana", "banana", "cereza", "durazno");
        String maximoString = maximo(palabras);
        System.out.println("La palabra máxima es: " + maximoString);

        List<Persona> personas = List.of(new Persona("Alice", 30), new Persona("Bob", 25),
                new Persona("Charlie", 35));
        Persona maximoPersona = maximo(personas);
        System.out.println("La persona con la edad máxima es: " + maximoPersona);
    }

    public static <T extends Comparable<T>> T maximo(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }

        T max = lista.getFirst();
        for (T elemento : lista) {
            if (elemento.compareTo(max) > 0) {
                max = elemento;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }

    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad);
    }
}