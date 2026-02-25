package co.edu.uniquindio.poo.Unidad1.Colecciones.Sets.Treeset.CustomOrder;

import java.sql.Date;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
* Crear clase Evento con id, nombre, fecha y prioridad. 
* Implementar Comparable para ordenar por fecha y un Comparator externo para ordenar por prioridad. 
* Crear dos TreeSet: uno ordenado por fecha y otro por prioridad, 
* analizando cómo el criterio de orden determina duplicados en TreeSet. 
* Se evalúa diferencia entre Comparable y Comparator.
 */

public class Main {
    public static void main(String[] args) {

        Set<Evento> eventosPorFecha = new TreeSet<>();
        Set<Evento> eventosPorPrioridad = new TreeSet<>(new GestiorEventos());

        Evento evento1 = new Evento("Evento 1", "E1", Date.valueOf("2024-07-01"), 2);
        Evento evento2 = new Evento("Evento 2", "E2", Date.valueOf("2024-06-15"), 1);
        Evento evento3 = new Evento("Evento 3", "E3", Date.valueOf("2024-07-01"), 3);
        Evento evento4 = new Evento("Evento 4", "E4", Date.valueOf("2024-04-27"), 2);
        Evento evento5 = new Evento("Evento 5", "E1", Date.valueOf("2024-12-24"), 1);

        eventosPorFecha.add(evento1);
        eventosPorFecha.add(evento2);
        eventosPorFecha.add(evento3);
        eventosPorFecha.add(evento4);
        eventosPorFecha.add(evento5); // evento5 será ignorado por TreeSet al tener mismo id (E1) que evento1

        eventosPorPrioridad.add(evento1);
        eventosPorPrioridad.add(evento2);
        eventosPorPrioridad.add(evento3);
        eventosPorPrioridad.add(evento4);
        eventosPorPrioridad.add(evento5);

        System.out.println("Eventos ordenados por fecha:");
        for (Evento evento : eventosPorFecha) {
            System.out.println(evento);
        }

        System.out.println("\nEventos ordenados por prioridad:");
        for (Evento evento : eventosPorPrioridad) {
            System.out.println(evento);
        }
    }
}

class Evento implements Comparable<Evento> {

    private String nombre;
    private final String id;
    private Date fecha;
    private int prioridad;

    public Evento(String nombre, String id, Date fecha, int prioridad) {
        this.nombre = nombre;
        this.id = id;
        this.fecha = fecha;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Evento [nombre=" + nombre + ", id=" + id + ", fecha=" + fecha + ", prioridad=" + prioridad + "]";
    }

    @Override
    public int compareTo(Evento o) {
        // PRIMERO comparar por ID (criterio de unicidad)
        int comparacionId = this.id.compareTo(o.getId());
        if (comparacionId == 0) {
            return 0; // Mismo ID = duplicado
        }
        
        // LUEGO ordenar por fecha
        int comparacionFecha = this.fecha.compareTo(o.getFecha());
        if (comparacionFecha != 0) {
            return comparacionFecha;
        }
        
        // Si misma fecha pero diferente ID, ordenar por ID
        return comparacionId;
    }
}

class GestiorEventos implements Comparator<Evento> {

    @Override
    public int compare(Evento o1, Evento o2) {
        // PRIMERO comparar por ID (criterio de unicidad)
        int comparacionId = o1.getId().compareTo(o2.getId());
        if (comparacionId == 0) {
            return 0; // Mismo ID = duplicado
        }
        
        // LUEGO ordenar por prioridad
        int comparacionPrioridad = o1.getPrioridad() - o2.getPrioridad();
        if (comparacionPrioridad != 0) {
            return comparacionPrioridad;
        }
        
        // Si misma prioridad pero diferente ID, ordenar por ID
        return comparacionId;
    }
}