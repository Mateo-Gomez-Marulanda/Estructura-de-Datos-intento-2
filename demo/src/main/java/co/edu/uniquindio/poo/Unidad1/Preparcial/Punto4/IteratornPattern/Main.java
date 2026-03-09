package co.edu.uniquindio.poo.Unidad1.Preparcial.Punto4.IteratornPattern;
 
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * PATRÓN ITERATOR - Ejemplos Prácticos y Completos
 * 
 * Este archivo demuestra cómo crear iteradores personalizados en Java mediante
 * el patrón Iterator.
 * 
 * CONCEPTOS CLAVE:
 * - Iterator<T>: Interfaz que define hasNext(), next() y remove()
 * - Iterable<T>: Interfaz que permite usar for-each loops
 * - Separación entre colección y forma de recorrerla
 * 
 * CASOS DE USO DEMOSTRADOS:
 * 1. Iterador básico sobre un arreglo
 * 2. Iterador que filtra elementos (solo pares)
 * 3. Iterador inverso
 * 4. Iterador para encontrar el máximo
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== DEMO DE ITERADORES PROPIOS ===\n");

        // ============================================
        // CASO 1: Iterador Básico sobre Arreglo
        // ============================================
        System.out.println("1. ITERADOR BÁSICO SOBRE ARREGLO");
        System.out.println("-".repeat(50));

        String[] nombres = { "Ana", "Carlos", "María", "Pedro", "Lucía" };
        ColeccionArreglo<String> coleccionNombres = new ColeccionArreglo<>(nombres);

        // Forma 1: Usando for-each (posible porque implementa Iterable)
        System.out.println("Usando for-each:");
        for (String nombre : coleccionNombres) {
            System.out.println("  - " + nombre);
        }

        // Forma 2: Usando iterator explícitamente
        System.out.println("\nUsando iterator explícito:");
        Iterator<String> iteradorNombres = coleccionNombres.iterator();
        while (iteradorNombres.hasNext()) {
            System.out.println("  - " + iteradorNombres.next());
        }

        // ============================================
        // CASO 2: Iterador con Filtro (Solo Pares)
        // ============================================
        System.out.println("\n\n2. ITERADOR CON FILTRO (SOLO NÚMEROS PARES)");
        System.out.println("-".repeat(50));

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IteradorPares iteradorPares = new IteradorPares(numeros);

        System.out.println("Números originales: " + numeros);
        System.out.println("Números pares:");
        for (Integer par : iteradorPares) {
            System.out.println("  - " + par);
        }

        // ============================================
        // CASO 3: Iterador Inverso
        // ============================================
        System.out.println("\n\n3. ITERADOR INVERSO");
        System.out.println("-".repeat(50));

        Integer[] numerosArray = { 10, 20, 30, 40, 50 };
        IteradorInverso<Integer> iteradorInverso = new IteradorInverso<>(numerosArray);

        System.out.println("Orden normal: 10, 20, 30, 40, 50");
        System.out.println("Orden inverso:");
        for (Integer num : iteradorInverso) {
            System.out.println("  - " + num);
        }

        // ============================================
        // CASO 4: Iterador para Encontrar Máximo
        // ============================================
        System.out.println("\n\n4. ITERADOR PARA ENCONTRAR EL MÁXIMO");
        System.out.println("-".repeat(50));

        List<Producto> productos = List.of(
                new Producto("Laptop", 1200.50),
                new Producto("Mouse", 25.99),
                new Producto("Teclado", 75.00),
                new Producto("Monitor", 350.00),
                new Producto("Webcam", 89.99));

        IteradorMaximo<Producto> iteradorMax = new IteradorMaximo<>(productos);

        System.out.println("Productos:");
        for (Producto p : productos) {
            System.out.println("  - " + p);
        }

        System.out.println("\nProducto más caro:");
        for (Producto productoMax : iteradorMax) {
            System.out.println("  >>> " + productoMax);
        }

        // También se puede obtener directamente
        System.out.println("\nUsando método de conveniencia:");
        System.out.println("  >>> " + iteradorMax.obtenerMaximo());

        // ============================================
        // CASO 5: Comparación de Múltiples Iteradores
        // ============================================
        System.out.println("\n\n5. MÚLTIPLES ITERADORES SIMULTÁNEOS");
        System.out.println("-".repeat(50));

        Integer[] datos = { 1, 2, 3, 4, 5, 6 };
        ColeccionArreglo<Integer> coleccion = new ColeccionArreglo<>(datos);

        Iterator<Integer> it1 = coleccion.iterator();
        Iterator<Integer> it2 = coleccion.iterator();

        System.out.println("Iterador 1 - Primeros 3 elementos:");
        for (int i = 0; i < 3 && it1.hasNext(); i++) {
            System.out.println("  - " + it1.next());
        }

        System.out.println("\nIterador 2 - Todos los elementos:");
        while (it2.hasNext()) {
            System.out.println("  - " + it2.next());
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}

// ============================================
// CASO 1: ITERADOR BÁSICO SOBRE ARREGLO
// ============================================

/**
 * ColeccionArreglo: Wrapper sobre un arreglo que implementa Iterable
 * 
 * PROPÓSITO:
 * - Encapsular un arreglo y proporcionar iteración personalizada
 * - Demostrar los conceptos básicos del patrón Iterator
 * 
 * COMPONENTES:
 * - Implementa Iterable<T> para permitir for-each loops
 * - Retorna un IteradorArreglo personalizado
 * 
 * @param <T> Tipo de elementos en el arreglo
 */
class ColeccionArreglo<T> implements Iterable<T> {
    private T[] elementos;

    /**
     * Constructor que recibe el arreglo a iterar
     * 
     * @param elementos Arreglo de elementos
     */
    public ColeccionArreglo(T[] elementos) {
        this.elementos = elementos;
    }

    /**
     * Método requerido por Iterable<T>
     * Retorna un nuevo iterador cada vez que se llama
     * 
     * NOTA: Esto permite tener múltiples iteradores simultáneos
     * sobre la misma colección sin interferencia
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorArreglo<>(elementos);
    }
}

/**
 * IteradorArreglo: Implementación personalizada de Iterator
 * 
 * RESPONSABILIDADES:
 * - Mantener el estado de la iteración (posición actual)
 * - Verificar si hay más elementos (hasNext)
 * - Proporcionar el siguiente elemento (next)
 * 
 * @param <T> Tipo de elementos a iterar
 */
class IteradorArreglo<T> implements Iterator<T> {
    private T[] elementos;
    private int posicionActual = 0;

    /**
     * Constructor que recibe el arreglo a iterar
     */
    public IteradorArreglo(T[] elementos) {
        this.elementos = elementos;
    }

    /**
     * Verifica si quedan elementos por iterar
     * 
     * @return true si hay más elementos, false en caso contrario
     */
    @Override
    public boolean hasNext() {
        return posicionActual < elementos.length;
    }

    /**
     * Retorna el siguiente elemento y avanza la posición
     * 
     * @return El siguiente elemento
     * @throws NoSuchElementException si no hay más elementos
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en el arreglo");
        }
        return elementos[posicionActual++];
    }

    /**
     * Método opcional para remover elementos
     * En este caso no está implementado porque modificar arreglos es complejo
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Esta operación no está soportada");
    }
}

// ============================================
// CASO 2: ITERADOR CON FILTRO (SOLO PARES)
// ============================================

/**
 * IteradorPares: Iterador que filtra y retorna solo números pares
 * 
 * VENTAJAS:
 * - Separa la lógica de filtrado de la colección original
 * - Iteración eficiente sin crear una nueva colección
 * - Lazy evaluation: solo procesa elementos cuando se solicitan
 * 
 * LÓGICA:
 * - En hasNext(), busca el siguiente número par disponible
 * - Almacena el índice del siguiente par para next()
 */
class IteradorPares implements Iterable<Integer> {
    private List<Integer> numeros;

    public IteradorPares(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int indiceActual = 0;
            private Integer siguientePar = null;

            /**
             * Busca el siguiente número par disponible
             * Actualiza siguientePar con el valor encontrado
             */
            @Override
            public boolean hasNext() {
                // Buscar el siguiente par si aún no lo hemos encontrado
                while (indiceActual < numeros.size()) {
                    int numero = numeros.get(indiceActual);
                    if (numero % 2 == 0) {
                        siguientePar = numero;
                        return true;
                    }
                    indiceActual++;
                }
                return false;
            }

            /**
             * Retorna el par encontrado por hasNext()
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más números pares");
                }
                indiceActual++; // Avanzar para la próxima búsqueda
                return siguientePar;
            }
        };
    }
}

// ============================================
// CASO 3: ITERADOR INVERSO
// ============================================

/**
 * IteradorInverso: Itera elementos en orden inverso
 * 
 * APLICACIONES:
 * - Procesar elementos en orden inverso sin modificar la colección
 * - Navegación hacia atrás en estructuras de datos
 * - Deshacer operaciones (undo)
 * 
 * IMPLEMENTACIÓN:
 * - Comienza desde el último índice
 * - Decrementa la posición en cada next()
 * 
 * @param <T> Tipo de elementos
 */
class IteradorInverso<T> implements Iterable<T> {
    private T[] elementos;

    public IteradorInverso(T[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int posicion = elementos.length - 1;

            @Override
            public boolean hasNext() {
                return posicion >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos");
                }
                return elementos[posicion--];
            }
        };
    }
}

// ============================================
// CASO 4: ITERADOR PARA ENCONTRAR MÁXIMO
// ============================================

/**
 * IteradorMaximo: Encuentra y retorna solo el elemento máximo
 * 
 * CONCEPTO:
 * - Procesa toda la colección una vez al crear el iterador
 * - Retorna un solo elemento (el máximo)
 * - Usa Comparable para comparar elementos
 * 
 * VENTAJAS:
 * - Encapsula la lógica de búsqueda del máximo
 * - Compatible con el patrón Iterator
 * - Reutilizable para cualquier tipo Comparable
 * 
 * @param <T> Tipo de elementos que implementan Comparable
 */
class IteradorMaximo<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elementos;

    public IteradorMaximo(List<T> elementos) {
        this.elementos = elementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private T maximo = encontrarMaximo();
            private boolean yaRetornado = false;

            /**
             * Encuentra el elemento máximo de la colección
             * Se ejecuta una sola vez al crear el iterador
             */
            private T encontrarMaximo() {
                if (elementos == null || elementos.isEmpty()) {
                    return null;
                }

                T max = elementos.get(0);
                for (T elemento : elementos) {
                    if (elemento.compareTo(max) > 0) {
                        max = elemento;
                    }
                }
                return max;
            }

            @Override
            public boolean hasNext() {
                // Solo retorna true una vez (cuando tiene el máximo y no se ha retornado)
                return maximo != null && !yaRetornado;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Ya se retornó el máximo");
                }
                yaRetornado = true;
                return maximo;
            }
        };
    }

    /**
     * Método de conveniencia para obtener el máximo directamente
     * Sin necesidad de usar el iterador
     * 
     * @return El elemento máximo o null si la colección está vacía
     */
    public T obtenerMaximo() {
        Iterator<T> it = iterator();
        return it.hasNext() ? it.next() : null;
    }
}

// ============================================
// CLASE AUXILIAR: PRODUCTO
// ============================================

/**
 * Producto: Clase de ejemplo para demostrar iteradores con objetos
 * personalizados
 * 
 * Implementa Comparable para ordenar por precio
 */
class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    /**
     * Compara productos por precio
     * Usado por IteradorMaximo para encontrar el producto más caro
     */
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", nombre, precio);
    }
}

/*
 * ============================================
 * RESUMEN DEL PATRÓN ITERATOR
 * ============================================
 * 
 * COMPONENTES PRINCIPALES:
 * 
 * 1. Iterator<T> (interfaz estándar de Java)
 * - hasNext(): boolean
 * - next(): T
 * - remove(): void (opcional)
 * 
 * 2. Iterable<T> (interfaz estándar de Java)
 * - iterator(): Iterator<T>
 * 
 * VENTAJAS:
 * ✓ Oculta la estructura interna de la colección
 * ✓ Permite múltiples iteraciones simultáneas
 * ✓ Iteración uniforme sin importar el tipo de colección
 * ✓ Compatible con for-each loops de Java
 * ✓ Facilita el filtrado y transformación de datos
 * 
 * CUÁNDO USAR ITERADORES PROPIOS:
 * - Necesitas lógica de iteración personalizada (filtros, orden inverso, etc.)
 * - Quieres ocultar la implementación interna de tu colección
 * - Necesitas iteración lazy (procesamiento bajo demanda)
 * - Quieres múltiples formas de recorrer la misma colección
 * 
 * MEJORES PRÁCTICAS:
 * 1. Implementa Iterable<T> en la clase contenedora
 * 2. Crea una clase interna o anónima para Iterator<T>
 * 3. Mantén el estado de iteración separado del contenedor
 * 4. Valida con hasNext() antes de llamar next()
 * 5. Lanza NoSuchElementException si next() se llama sin elementos
 * 6. Documenta si tu iterador soporta remove() o no
 * 
 * ============================================
 */