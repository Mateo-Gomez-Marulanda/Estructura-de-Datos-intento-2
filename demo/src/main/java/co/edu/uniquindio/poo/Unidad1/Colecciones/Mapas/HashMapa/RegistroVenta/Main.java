package co.edu.uniquindio.poo.Unidad1.Colecciones.Mapas.HashMapa.RegistroVenta;

/*
* Registro de Ventas Diarias
* Una tienda desea desarrollar un programa en Java para registrar las ventas realizadas durante el día.
* Cada venta tiene:
*   - Código del producto (String)
*   - Nombre del producto
*   - Cantidad vendida
*   - Valor total de la venta
* El sistema debe permitir:
*   - Registrar ventas usando el código del producto como identificador.
*   - Consultar la información de un producto por su código.
*   - Mostrar todas las ventas registradas.
*   - Mostrar las ventas ordenadas por código de producto.
*   - Mostrar las ventas en el orden exacto en que fueron registradas.
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        RegistroVenta registro = new RegistroVenta();

        Venta venta1 = new Venta("001", "Producto A", 10, 100);
        Venta venta2 = new Venta("004", "Producto B", 5, 50);
        Venta venta3 = new Venta("002", "Producto C", 20, 200);
        Venta venta4 = new Venta("001", "Producto A", 15, 150); // mismo código que venta1
        Venta venta5 = new Venta("003", "Producto D", 8, 80);
        Venta venta6 = new Venta("007", "Producto E", 12, 120);
        Venta venta7 = new Venta("005", "Producto F", 7, 70);

        registro.registrarVenta(venta1);
        registro.registrarVenta(venta2);
        registro.registrarVenta(venta3);
        registro.registrarVenta(venta4); // sobrescribe venta1 por tener el mismo código
        registro.registrarVenta(venta5);
        registro.registrarVenta(venta6);
        registro.registrarVenta(venta7);

        System.out.println();
        registro.consultarVenta("001");

        System.out.println("Ventas registradas:");
        registro.mostrarVentas();

        System.out.println("\nVentas ordenadas por código:");
        registro.ordenarCodigo();

        System.out.println("\nVentas en orden de inserción:");
        registro.ordenarInsercion();
    }
}

class RegistroVenta {
    Map<String, Venta> ventas = new HashMap<>();

    public void registrarVenta(Venta venta) {
        ventas.put(venta.getCodigoProducto(), venta);
    }

    public void consultarVenta(String codigo) {
        ventas.get(codigo);
    }

    public void mostrarVentas() {
        for (Venta venta : ventas.values()) {
            System.out.println(venta);
        }
    }

    public void ordenarCodigo() {
        Map<String, Venta> ventasOrdenadas = new TreeMap<>(ventas);
        for (Venta venta : ventasOrdenadas.values()) {
            System.out.println(venta);
        }
    }

    public void ordenarInsercion() {
        Map<String, Venta> ventasInsercion = new LinkedHashMap<>(ventas);
        for (Venta venta : ventasInsercion.values()) {
            System.out.println(venta);
        }
    }
}

class Venta {
    private String codigoProducto;
    private String nombreProducto;
    private int cantidadVendida;
    private int valorTotal;

    public Venta(String codigoProducto, String nombreProducto, int cantidadVendida, int valorTotal) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
        this.valorTotal = valorTotal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public String toString() {
        return "Venta [codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", cantidadVendida="
                + cantidadVendida + ", valorTotal=" + valorTotal + "]";
    }

    @Override
    public int hashCode() {
        return codigoProducto.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venta other = (Venta) obj;
        if (codigoProducto == null) {
            if (other.codigoProducto != null)
                return false;
        } else if (!codigoProducto.equals(other.codigoProducto))
            return false;
        return true;
    }
}