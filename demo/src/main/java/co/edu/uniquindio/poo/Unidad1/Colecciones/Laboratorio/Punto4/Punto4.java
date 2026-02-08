package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio.Punto4;
/*
*Cree una cola (Queue) que almacene objetos de tipo "Tarea" que tengan una prioridad asociada. Implemente la cola usando un PriorityQueue y defina la prioridad de cada tarea según su importancia.
*/

import java.util.PriorityQueue;
import java.util.Queue;

class Tarea implements Comparable<Tarea> {
    private String nombre;
    private int prioridad;

    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea [nombre=" + nombre + ", prioridad=" + prioridad + "]";
    }

    @Override
    public int compareTo(Tarea tarea) {
        if (this.prioridad > tarea.getPrioridad()) {
            return 1;
        }

        if (this.prioridad < tarea.getPrioridad()) {
            return -1;
        }
        return 0;
    }
}

public class Punto4 {
    public static void main(String[] args) {

        Queue<Tarea> tareas = new PriorityQueue<>();

        tareas.add(new Tarea("Tarea 1", 2));
        tareas.add(new Tarea("Tarea 2", 1));
        tareas.add(new Tarea("Tarea 3", 3));
        tareas.add(new Tarea("Tarea 4", 1));
        tareas.add(new Tarea("Tarea 1", 2));

        while (!tareas.isEmpty()) {
            System.out.println(tareas.poll());
        }
    }
}
