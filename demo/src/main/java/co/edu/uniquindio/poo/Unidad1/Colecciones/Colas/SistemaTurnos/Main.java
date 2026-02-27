package co.edu.uniquindio.poo.Unidad1.Colecciones.Colas.SistemaTurnos;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Turnos turnos = new Turnos();

        Cliente cliente1 = new Cliente("Juan", "123456789", 1);
        Cliente cliente2 = new Cliente("Maria", "987654321", 2);
        Cliente cliente3 = new Cliente("Pedro", "456789123", 3);

        turnos.registrarCliente(cliente1);
        turnos.registrarCliente(cliente2);
        turnos.registrarCliente(cliente3);

        System.out.println("Siguiente cliente: " + turnos.verificarSiguiente());

        turnos.atenderCliente(cliente1);
        System.out.println("Cliente atendido: " + cliente1);

        System.out.println("Siguiente cliente: " + turnos.verificarSiguiente());

        System.out.println("Clientes en espera: " + turnos.clientesEspera());
    }
}

class Turnos {
    Queue<Cliente> turnos = new ArrayDeque<>();

    public void registrarCliente(Cliente cliente) {
        turnos.add(cliente);
    }

    public void atenderCliente(Cliente cliente) {
        turnos.remove(cliente);
    }

    public Cliente verificarSiguiente() {
        List<Cliente> lista = new LinkedList<>(turnos);
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

    public boolean verificarFilaVacia() {
        return turnos.isEmpty();
    }

    public int clientesEspera() {
        return turnos.size();
    }
}

class Cliente {
    private String nombre;
    private String cedula;
    private int turno;

    public Cliente(String nombre, String cedula, int turno) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", turno=" + turno + "]";
    }
}