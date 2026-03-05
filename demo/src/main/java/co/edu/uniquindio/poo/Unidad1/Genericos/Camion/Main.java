package co.edu.uniquindio.poo.Unidad1.Genericos.Camion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Camion<String> camionDeFrutas = new Camion<>("EPS-067");
        camionDeFrutas.cargar("Manzanas");
        camionDeFrutas.cargar("Naranjas");
        camionDeFrutas.cargar("Plátanos");

        System.out.println("Camión de frutas cargado.");

        camionDeFrutas.descargar();
        System.out.println("Naranjas descargadas del camión.");

        Iterator<String> it = camionDeFrutas.iterator();

        // imprimir mediante iterators
        while (it.hasNext()) {
            String x = it.next();
            System.out.println(x);
        }
    }
}

/*
 * se implementa la interfaz Iterable<T> con el fin de que se pueda recorrer
 * de manera eficiente, ademas de aprovechar los beneficios de los iteradores
 * 
 */

class Camion<T> implements Iterable<T> {
    private List<T> contenido = new ArrayList<>();
    private String placa;

    public Camion(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public T descargar() {
        if (!contenido.isEmpty()) {
            // alternativa remove(contenido.size()-1)
            return contenido.removeLast();
        } else {
            throw new IllegalStateException("El camión está vacío, no se puede descargar.");
        }
    }

    public void cargar(T elemento) {
        contenido.add(elemento);
    }

    // los iteradores no sirven para tipos genericos no definidos
    @Override
    public Iterator<T> iterator() {
        return contenido.iterator();
    }

    // public void mostrarCarga() {

    // for (T elemento : contenido) {
    // System.out.println(elemento);
    // }
    // }
}

