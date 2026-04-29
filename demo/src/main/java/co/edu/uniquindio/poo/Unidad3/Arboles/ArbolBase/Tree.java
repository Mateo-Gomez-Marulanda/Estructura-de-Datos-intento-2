package co.edu.uniquindio.poo.Unidad3.Arboles.ArbolBase;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void put(T data) {
        Node<T> newNodo = new Node<>(data);
        if (root == null) {
            root = newNodo;
        } else {
            putR(data, root);
        }
    }

    // metodo recursivo para agregar un nodo
    private void putR(T data, Node<T> current) {

        if (data.equals(current.getValue())) { // condicion para no aceptar repetidos
            System.out.print("not added, the value already exists in the tree.");

        } else if (data.compareTo(current.getValue()) < 0) {
            // Si data es MENOR que current, va a la IZQUIERDA
            if (current.getLeft() == null) {

                Node<T> newNode = new Node<>(data);
                current.setLeft(newNode); // se asigna el nuevo nodo a la izquierda del nodo actual
                size++;
            } else {
                // lamado recursivo para seguir buscando el lugar correcto en el subarbol
                // izquierdo
                putR(data, current.getLeft());
            }
        } else {
            // Si data es MAYOR que current, va a la DERECHA
            if (current.getRight() == null) {
                Node<T> newNode = new Node<>(data);
                current.setRight(newNode); // se asigna el nuevo nodo a la derecha del nodo actual
                size++;
            } else {
                // llamado recursivo para seguir buscando el lugar correcto en el subarbol
                // derecho
                putR(data, current.getRight());
            }
        }
    }

    public void remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data cannot be null");
        }
        root = removeR(root, data);
    }

    // metodo recursivo para eliminar un nodo del árbol
    private Node<T> removeR(Node<T> current, T data) {
        if (current == null) {
            return null; // Valor no encontrado
        }

        int comparacion = data.compareTo(current.getValue());

        if (comparacion < 0) {
            // El valor está en el subárbol izquierdo
            current.setLeft(removeR(current.getLeft(), data));
        } else if (comparacion > 0) {
            // El valor está en el subárbol derecho
            current.setRight(removeR(current.getRight(), data));
        } else {
            // Nodo encontrado - tres casos:

            // Caso 1: Nodo sin hijos (hoja)
            if (current.getLeft() == null && current.getRight() == null) {
                size--;
                return null;
            }

            // Caso 2: Nodo con solo hijo derecho
            if (current.getLeft() == null) {
                size--;
                return current.getRight();
            }

            // Caso 3: Nodo con solo hijo izquierdo
            if (current.getRight() == null) {
                size--;
                return current.getLeft();
            }

            // Caso 4: Nodo con dos hijos
            // Encontrar el nodo más pequeño del subárbol derecho (sucesor inorden)
            Node<T> minRight = findMin(current.getRight());
            // Reemplazar el valor del nodo actual con el valor del sucesor
            current.setValue(minRight.getValue());
            // Eliminar el nodo sucesor del subárbol derecho
            current.setRight(removeR(current.getRight(), minRight.getValue()));
        }

        return current;
    }

    // metodo auxiliar para encontrar el nodo con el valor mínimo en un subárbol
    private Node<T> findMin(Node<T> current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public boolean binarySearch(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data cannot be null");
        }
        return binarySearchR(root, data); // se llama al metodo recursivo
    }

    // metodo recursivo para buscar un valor en el arbol
    private boolean binarySearchR(Node<T> current, T data) {
        if (current == null) {
            return false;
        }

        // se guarda el valor de la comparacion con el fin de poder comparar el tamaño
        // de los datos sin importar su tipo
        int comparacion = current.getValue().compareTo(data);

        if (comparacion == 0) {
            return true; // Encontrado
        } else if (comparacion > 0) {
            return binarySearchR(current.getLeft(), data); // Izquierda: valores menores
        } else {
            return binarySearchR(current.getRight(), data); // Derecha: valores mayores
        }
    }

    // Metodos de recorrido en profundidad: preorden, inorden y postorden
    public void inOrder() {
        if (root == null) {
            System.out.println("tree is empty.");
        } else {
            inOrderR(root);
            System.out.println(); // salto de línea al final
        }
    }

    private void inOrderR(Node<T> current) {
        if (current != null) {
            inOrderR(current.getLeft()); // Recorre el subárbol izquierdo
            System.out.print(current.getValue() + " "); // Muestra el valor del nodo actual
            inOrderR(current.getRight()); // Recorre el subárbol derecho
        }
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("tree is empty.");
        } else {
            preOrderR(root);
            System.out.println();
        }
    }

    private void preOrderR(Node<T> current) {
        if (current != null) {
            System.out.print(current.getValue() + " "); // obtiene el valor del nodo actual
            preOrderR(current.getLeft()); // subarbol izquierdo
            preOrderR(current.getRight()); // subarbol derecho
        }
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("tree is empty.");
        } else {
            postOrderR(root);
            System.out.println();
        }
    }

    private void postOrderR(Node<T> current) {
        if (current != null) {
            postOrderR(current.getLeft()); // subarbol izquierdo
            postOrderR(current.getRight()); // subarbol derecho
            System.out.print(current.getValue() + " "); // obtiene el valor del nodo actual
        }
    }

    // pendiente de revision
    // private int getHeight(Node<T> node) {
    // if (node == null) {
    // return 0;
    // }
    // return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    // }

    // // Metodos de recorrido por niveles: por niveles o amplitud
    // public void levelOrder() {
    // if (root == null) {
    // System.out.println("tree is empty.");
    // } else {
    // levelOrderR(root);
    // System.out.println(); // salto de línea al final
    // }
    // }

    // private void levelOrderR(Node<T> current){

    // }
}
