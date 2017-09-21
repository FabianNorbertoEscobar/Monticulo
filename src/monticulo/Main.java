package principalPackage;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Monticulo minHeap = new MonticuloMinimo(10);
		Monticulo maxHeap = new MonticuloMaximo(10);
		
		System.out.println("Insertando nodos a los mont�culos");
		for (int i = 0; i < 10; i++) {
			minHeap.insertar(rand.nextInt(20));
			maxHeap.insertar(rand.nextInt(20));
			System.out.println("Luego de " + (i+1) + "� inserci�n:");
			System.out.println("Ra�z del mont�culo de M�nimo: " + minHeap.pispear());
			System.out.println("Ra�z del mont�culo de M�ximo: " + maxHeap.pispear());
		}
		
		System.out.println("Mont�culo de M�nimo Completo");
		minHeap.mostrar();

		System.out.println("Mont�culo de M�ximo Completo");
		maxHeap.mostrar();
		
		System.out.println("Eliminando nodos de los mont�culos");
		for (int i = 0; i < 10; i++) {
			minHeap.eliminar();
			maxHeap.eliminar();
			System.out.println("Luego de " + (i+1) + "� eliminaci�n:");
			if (!minHeap.estaVacio()) {
				System.out.println("Ra�z del mont�culo de M�nimo: " + minHeap.pispear());
			}
			if (!maxHeap.estaVacio()) {
				System.out.println("Ra�z del mont�culo de M�ximo: " + maxHeap.pispear());
			}
		}
		System.out.println("Mont�culos vac�os");
		
		System.out.println("Ordenamiento de un vector");
		int[] v1 = new int[20];
		int[] v2 = new int[20];
		for (int i = 0; i < 20; i++) {
			v1[i] = rand.nextInt(30);
			v2[i] = v1[i];
		}
		
		System.out.println("Vector desordenado");
		for (int i = 0; i < v1.length; i++) {
			System.out.print(v1[i] + " ");
		}
		System.out.println();
		
		HeapSort.sort(v1);
		System.out.println("Sort:");
		for (int i : v1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		HeapSort.reverseSort(v2);
		System.out.println("ReverseSort");
		for (int i : v2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
