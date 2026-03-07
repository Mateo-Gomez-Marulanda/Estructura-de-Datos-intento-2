package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto1;

import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList; 
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaTareas<String> listaTareas = new ListaTareas<>();

        Tarea<String> tarea1 = new Tarea<>("Hacer la tarea de matemáticas", 2, Date.valueOf("2025-06-30"));
        Tarea<String> tarea2 = new Tarea<>("Preparar la presentación de historia", 1, Date.valueOf("2025-06-25"));
        Tarea<String> tarea3 = new Tarea<>("Estudiar para el examen de física", 3, null);

        listaTareas.agregarTarea(tarea1);
        listaTareas.agregarTarea(tarea2);
        listaTareas.agregarTarea(tarea3);

        System.out.println("Tareas ordenadas por prioridad:");
        listaTareas.obtenerTareasPrioridad();

        System.out.println("\nTareas ordenadas por fecha de vencimiento:");
        listaTareas.obtenerTareaFechaVencimiento();
    }
}

class Tarea<T> implements Comparable<Tarea<T>> {
    private String descripcion;
    private int prioridad;
    private Date fechaVencimiento;

    public Tarea(String descripcion, int prioridad, Date fechaVencimiento) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Tarea [descripcion=" + descripcion + ", prioridad=" + prioridad + ", fechaVencimiento="
                + fechaVencimiento + "]";
    }

    @Override
    public int compareTo(Tarea<T> o) {
        return Integer.compare(this.prioridad, o.getPrioridad());
    }
}

class ListaTareas<T> implements Comparator<Tarea<T>> {
    private List<Tarea<T>> tareas = new LinkedList<>();

    public ListaTareas() {
    }

    public void agregarTarea(Tarea<T> tarea) {
        tareas.add(tarea);
    }

    public void obtenerTareasPrioridad() {
        Collections.sort(tareas);

        for (Tarea<T> tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public void obtenerTareaFechaVencimiento() {

        // se usa sort(tareas, this) en el cual el atributo this hace referencia a la
        // instancia actual de la clase ListaTareas, que implementa la interfaz
        // Comparator<Tarea<T>>. Esto permite que el método sort utilice el método
        // compare definido en la clase ListaTareas para ordenar las tareas según su
        // fecha de vencimiento.
        Collections.sort(tareas, this);
        for (Tarea<T> tarea : tareas) {
            System.out.println(tarea);
        }
    }

    @Override
    public int compare(Tarea<T> o1, Tarea<T> o2) {
        if (o1.getFechaVencimiento() == null && o2.getFechaVencimiento() == null) {
            return 0;
        }

        if (o1.getFechaVencimiento() == null) {
            return 1; // Las tareas sin fecha van al final
        }
        if (o2.getFechaVencimiento() == null) {
            return -1;
        }
        return o1.getFechaVencimiento().compareTo(o2.getFechaVencimiento());
    }
}