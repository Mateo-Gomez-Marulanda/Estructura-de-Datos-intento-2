package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Camion camion1 = new Camion("ABC123", "Volvo"); // comprovacion para el uso de la wildacard '?'
        Vehiculo moto1 = new Moto("XYZ789", "Yamaha");
        Vehiculo auto1 = new Auto("DEF456", "Toyota");

        List<Vehiculo> vehiculos = List.of(camion1, moto1, auto1);
        alquilarVehiculos(vehiculos);
    }

    public static void alquilarVehiculos(List<? extends Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.alquilar();
        }
    }
}

abstract class Vehiculo {
    protected String placa;
    protected String modelo;

    public Vehiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public abstract void alquilar();
}

class Camion extends Vehiculo {

    public Camion(String placa, String modelo) {
        super(placa, modelo);
    }

    public void cargar() {
        System.out.println("el camion esta siendo cargado...");
    }

    @Override
    public void alquilar() {
        System.out.println("el camion de numero de placa " + placa + "fue laquilado");
    }
}

class Moto extends Vehiculo {
    public Moto(String placa, String modelo) {
        super(placa, modelo);
    }

    public void conducir() {
        System.out.println("se esta conduciendo la moto de placa " + placa);
    }

    @Override
    public void alquilar() {
        System.out.println("la moto de numero de placa " + placa + "fue laquilada");
    }
}

class Auto extends Vehiculo {
    public Auto(String placa, String modelo) {
        super(placa, modelo);
    }

    public void conducir() {
        System.out.println("se esta conduciendo el auto de placa " + placa);
    }

    @Override
    public void alquilar() {
        System.out.println("el auto de numero de placa " + placa + "fue laquilado");
    }
}