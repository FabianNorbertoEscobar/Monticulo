# Montículo
Montículo de mínimos y montículo de máximos, implementación estática en un vector

En computación, un montículo (o heap en inglés) es una estructura de datos del tipo árbol con información perteneciente a un conjunto ordenado. Los montículos máximos tienen la característica de que cada nodo padre tiene un valor mayor que el de cualquiera de sus nodos hijos, mientras que en los montículos mínimos, el valor del nodo padre es siempre menor al de sus nodos hijos.

Un árbol cumple la condición de montículo si satisface dicha condición y además es un árbol binario casi completo. Un árbol binario es completo cuando todos los niveles están llenos, con la excepción del último, que se llena desde la izquierda hacia la derecha.

En un montículo de prioridad, el mayor elemento (o el menor, dependiendo de la relación de orden escogida) está siempre en el nodo raíz. Por esta razón, los montículos son útiles para implementar colas de prioridad. Una ventaja que poseen los montículos es que, por ser árboles completos, se pueden implementar usando arreglos (arrays), lo cual simplifica su codificación y libera al programador del uso de punteros.

La eficiencia de las operaciones en los montículos es crucial en diversos algoritmos de recorrido

Los Montículos binarios (binary heaps en inglés) son un caso particular y sencillo de la estructura de datos Montículo, y está basada en un árbol binario balanceado, que puede verse como un árbol binario con dos restricciones adicionales:

### Propiedad de montículo
Cada nodo contiene un valor superior al de sus hijos (para un montículo por máximos) o más pequeño que el de sus hijos (para un montículo por mínimos).
Árbol semicompleto
El árbol está balanceado y en un mismo nivel las inserciones se realizan de izquierda a derecha.

Los montículos por mínimos se utilizan frecuentemente para representar colas de prioridad.

## Inserción de un elemento
La inserción de un elemento se realiza agregando el elemento en la posición que respeta la restricción de árbol semicompleto pero posiblemente invalidando la propiedad de montículo, para luego remontar hacia la raíz restaurando la propiedad de montículo por intercambio del valor de la posición desordenada por el valor de su padre. Esta reorganización se realiza en tiempo O(log n).

## Eliminación del elemento máximo
Para borrar el elemento máximo del montículo, de la manera más eficiente se puede tomar el elemento de la posición que debe quedar vacía, colocándolo en la raíz (así cumpliendo la propiedad de árbol completo), y luego intercambiar ese valor con el máximo de sus hijos hasta satisfacer la propiedad de montículo (si es de máximos), o intercambiarlo con el mínimo de sus hijos (si es de mínimos). Esta reorganización se puede realizar también en tiempo O(log n).

## Implementación en un vector
La posición cero no se utiliza y la raíz del montículo se almacena en la posición 1. Para un nodo en la posición i, su padre se encuentra en parte_entera(i/2), su hijo izquerdo en la posición 2*i y su hijo derecho en la posición 2*i+1.

## Ordenamiento HEAPSORT
Los montículos tienen la particularidad de que siempre en su raíz tiene alojado al valor mínimo (en el caso de los montículos de mínimos) o al valor máximo (en el caso de los montículos de máximos). Por lo tanto, al eliminar un nodo de un montículo, la nueva raíz será mayor o igual a la raíz anterior de un montículo de mínimos, o será menor o igual en un montículo de máximos.
Debido a esto, se pueden utilizar para ordenamiento: creando un montículo, insertando todos los valores del vector a ordenar y luego, eliminándolos uno a uno escribiéndolos nuevamente en el vector, en el orden en que van saliendo.
## Sort
Ordena de forma ascendente y utiliza un montículo de mínimos
## ReverseSort
Ordena de forma descendente y utiliza un montículo de máximos