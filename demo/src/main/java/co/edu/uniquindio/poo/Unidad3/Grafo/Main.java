package co.edu.uniquindio.poo.Unidad3.Grafo;

import co.edu.uniquindio.poo.Unidad3.Grafo.GrafoBase.*;

public class Main {
    public static void main(String[] args) {
        // se crea un grafo dirigido ponderado
        Graph<String> graph = new Graph<>();

        // se agregan vertices al grafo
        graph.addVertex("A", "Vertex A");
        graph.addVertex("B", "Vertex B");
        graph.addVertex("C", "Vertex C");

        // se agregan aristas al grafo
        Vertex<String> vertexA = graph.getVertex().get(0); // obtiene el vertice A
        Vertex<String> vertexB = graph.getVertex().get(1); // obtiene el vertice B
        Vertex<String> vertexC = graph.getVertex().get(2); // obtiene el vertice C

        Edge<String> edgeAB = new Edge<>("AB", vertexA, vertexB, "relation AB", 5);
        Edge<String> edgeAC = new Edge<>("AC", vertexA, vertexC, "relation AC", 3);
        Edge<String> edgeBC = new Edge<>("BC", vertexB, vertexC, "relation BC", 2);

        graph.getEdges().add(edgeAB);
        graph.getEdges().add(edgeAC);
        graph.getEdges().add(edgeBC);

        // se muestra la informacion del grafo
        System.out.println("Vertices:");
        for (Vertex<String> v : graph.getVertex()) {
            System.out.println(v.getId() + ": " + v.getData());
        }

        System.out.println("\nEdges:");
        for (Edge<String> e : graph.getEdges()) {
            System.out.println(e.getId() + ": from " + e.getFrom().getId() + " to " + e.getTo().getId() + ", type: " + e.getType() + ", weight: " + e.getWeight());
        }
    }
}
