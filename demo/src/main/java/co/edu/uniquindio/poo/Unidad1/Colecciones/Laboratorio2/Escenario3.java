package co.edu.uniquindio.poo.Unidad1.Colecciones.Laboratorio2;

import java.util.LinkedList;
import java.util.Queue;

public class Escenario3 {
    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        for (int size : sizes) {

            PlataformTaxi p = new PlataformTaxi();

            Runtime runtime = Runtime.getRuntime();
             // Limpia memoria aproximada
            runtime.gc();

            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            long start = System.nanoTime();

            // Registrar solicitudes
            for (int i = 0; i < size; i++) {
                p.addRequest(new Request(String.valueOf(i), "Origen" + i, "Destino" + i));
            }

            // Atender algunas solicitudes
            for (int i = 0; i < size / 2; i++) {
                p.attendRequest();
            }

            long end = System.nanoTime();
            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long time = end - start;
            long memoryUsed = memoryAfter - memoryBefore;

            System.out.println("Tamaño de datos: " + size);
            System.out.println("Tiempo de ejecución (ns): " + time);
            System.out.println("Memoria usada aproximada (bytes): " + memoryUsed);
            System.out.println("-----------------------------------");
        }
    }
}

class PlataformTaxi {
    Queue<Request> requests = new LinkedList<>();

    public void addRequest(Request request){
        requests.add(request);
    }

    public Request attendRequest(){
        return requests.poll();
    }

    public void showRequests(){
        for (Request request : requests) {
            System.out.println(request);
        }
    }

    public void cancelRequest(Request request){
        requests.remove(request);
    }
}

class Request {
    private String id;
    private String destination;
    private String arrival;
    
    public Request(String id, String destination, String arrival) {
        this.id = id;
        this.destination = destination;
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", destination=" + destination + ", arrival=" + arrival + "]";
    }

    
}