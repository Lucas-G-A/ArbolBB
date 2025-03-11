# Árbol Binario de Búsqueda (BST)

Este repositorio contiene una implementación de un Árbol Binario de Búsqueda (Binary Search Tree, BST) en Java.

## Características

- Inserción de nodos
- Eliminación de nodos
- Búsqueda de elementos
- Recorridos en preorden, inorden y postorden
- Altura del árbol

## Uso

Ejemplo de cómo utilizar la implementación:

```java
public class Main {
    public static void main(String[] args) {
        ArbolBB<Integer> abb = new ArbolBB();
        abb.inserta(10);
        abb.inserta(5);
        abb.inserta(15);
        abb.inserta(2);
        
        System.out.println("Inorden: ");
        abb.inOrden();
    }
}
```

