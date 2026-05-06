package co.edu.uniquindio.poo.Unidad3.Grafo;

import co.edu.uniquindio.poo.Unidad2.ListasSimples.SimpleEnlazada.SimpleLinkedList;

//grafo dirigido ponderado

public class Graph<T> {
    private SimpleLinkedList<Vertex<T>> vertex; // lista de vertices del grafo
    private SimpleLinkedList<Edge<T>> edges; // lista de aristas del grafo

    public Graph() {
        this.vertex = new SimpleLinkedList<>();
        this.edges = new SimpleLinkedList<>();
    }

    public void addVertex(Vertex<T> vertex){
        
    }
}