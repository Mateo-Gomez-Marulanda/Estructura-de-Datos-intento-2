package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }
}

class Repositorio<T> implements Iterable<T>{
    private List<T> lista = new ArrayList<>();

    public void agregar(T elemento){
        lista.add(elemento);
    }

    public T obtener(int indice){
        return lista.get(indice);
    }

    public Iterator<T> iterator(){
        
    }

    

}
