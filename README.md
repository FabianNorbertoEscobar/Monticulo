# Montículos binarios en Java

Proyecto de prácticas para implementar montículos binarios de mínimos y de máximos, y utilizarlos como colas de prioridad y para ordenar vectores con HeapSort.

## Contenido

- [Objetivos de aprendizaje](#objetivos-de-aprendizaje)
- [Tecnologías](#tecnologías)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Cómo funciona](#cómo-funciona)
- [Funcionalidades](#funcionalidades)
- [Complejidad](#complejidad)
- [Ejecutar el ejemplo](#ejecutar-el-ejemplo)
- [Pruebas](#pruebas)
- [Ideas para seguir practicando](#ideas-para-seguir-practicando)

## Objetivos de aprendizaje

El proyecto sirve para practicar:

- Árboles binarios casi completos representados con arreglos.
- Herencia y clases abstractas para compartir comportamiento entre variantes.
- Colas de prioridad y operaciones de inserción, consulta y extracción.
- Reordenamiento de elementos mediante las operaciones de un montículo.
- Pruebas unitarias con JUnit.

## Tecnologías

- **Java 8** (configurado en el proyecto de Eclipse).
- **JUnit 4** para las pruebas.
- **Eclipse IDE** como configuración de proyecto incluida (`.project` y `.classpath`).

No se incluye Maven ni Gradle; el proyecto usa las carpetas `src` y `test` como raíces de código fuente.

## Estructura del proyecto

```text
src/
└── monticulo/
    ├── Monticulo.java         # Comportamiento común y almacenamiento
    ├── MonticuloMinimo.java   # Prioridad para el menor elemento
    ├── MonticuloMaximo.java   # Prioridad para el mayor elemento
    ├── HeapSort.java          # Orden ascendente y descendente
    └── Main.java              # Ejemplo ejecutable
test/
└── monticulo/
    ├── MonticuloMinimoTest.java
    └── MonticuloMaximoTest.java
```

## Cómo funciona

Un montículo binario es un árbol casi completo que satisface una propiedad de prioridad:

- En un **montículo mínimo**, cada padre es menor o igual que sus hijos; la raíz contiene el mínimo.
- En un **montículo máximo**, cada padre es mayor o igual que sus hijos; la raíz contiene el máximo.

El árbol se almacena en un arreglo de tamaño fijo. Se deja libre la posición `0` y la raíz se guarda en la posición `1`. Para un nodo en la posición `i`, el hijo izquierdo está en `2 * i`, el derecho en `2 * i + 1` y el padre en `i / 2`.

`Monticulo` implementa el almacenamiento y las operaciones comunes. Las subclases `MonticuloMinimo` y `MonticuloMaximo` definen la relación de orden a través de `condicion`, por lo que comparten el algoritmo y difieren en cuál valor tiene prioridad.

## Funcionalidades

| Operación | Descripción |
| --- | --- |
| `insertar(int)` | Agrega un elemento si queda capacidad. |
| `eliminar()` | Extrae y devuelve la raíz, es decir, el elemento prioritario. |
| `pispear()` | Devuelve la raíz sin extraerla. |
| `estaVacio()` | Indica si no hay elementos. |
| `estaLleno()` | Indica si se alcanzó la capacidad máxima. |
| `mostrar()` | Imprime cada padre con los hijos que tenga. |
| `HeapSort.sort(int[])` | Ordena el arreglo de menor a mayor mediante un montículo mínimo. |
| `HeapSort.reverseSort(int[])` | Ordena el arreglo de mayor a menor mediante un montículo máximo. |

La capacidad se fija al construir el montículo y no aumenta automáticamente. Insertar en un montículo lleno, o consultar/eliminar uno vacío, lanza `IllegalStateException`. Se permiten valores duplicados.

## Complejidad

En un montículo binario convencional, consultar la raíz cuesta **O(1)**, y tanto insertar como extraer la raíz cuestan **O(log n)**. Sin embargo, la implementación de este proyecto vuelve a ejecutar `montar()` después de cada inserción. Como ese método recorre y hunde los nodos internos, **la inserción aquí puede costar O(n)**; por ello, `HeapSort` con inserciones sucesivas puede llegar a **O(n²)** en lugar de la complejidad habitual **O(n log n)**. El almacenamiento es **O(n)**.

Eliminar la raíz reorganiza el montículo hundiendo el nuevo elemento, con coste **O(log n)**. La reconstrucción completa tras insertar es una oportunidad para practicar una optimización: mantener el montículo con `flotar()` y no reconstruirlo en cada inserción.

## Ejecutar el ejemplo

Con un JDK instalado, desde la raíz del repositorio:

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/monticulo/*.java
java -cp out monticulo.Main
```

`Main` genera valores aleatorios, muestra las raíces de ambos montículos, extrae sus elementos y compara el orden ascendente y descendente de un vector.

## Pruebas

Las clases de prueba verifican el estado inicial, inserción, consulta de la raíz, extracción, orden de prioridad y el comportamiento al superar la capacidad o eliminar de un montículo vacío.

En Eclipse, importa el repositorio como proyecto Java y ejecuta `MonticuloMinimoTest` y `MonticuloMaximoTest` como pruebas **JUnit 4**. El `.classpath` ya declara las carpetas `src` y `test`, JavaSE-1.8 y el contenedor de JUnit 4.

## Ideas para seguir practicando

- Evitar la reconstrucción completa del montículo después de cada inserción y añadir pruebas de regresión.
- Añadir una construcción de montículo desde un arreglo (`heapify`) y comparar su coste con insertar elemento por elemento.
- Ampliar las pruebas con arreglos vacíos, un solo elemento, duplicados y valores extremos de `int`.
- Generalizar la estructura para aceptar otros tipos y un `Comparator`.
- Añadir configuración Maven o Gradle para compilar y ejecutar las pruebas desde línea de comandos.
