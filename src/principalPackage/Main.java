package principalPackage;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Monticulo minHeap = new MonticuloMinimo(10);
		Monticulo maxHeap = new MonticuloMaximo(10);
		
		System.out.println("Insertando nodos a los montículos");
		for (int i = 0; i < 10; i++) {
			minHeap.insertar(rand.nextInt(20));
			maxHeap.insertar(rand.nextInt(20));
			System.out.println("Luego de " + (i+1) + "° inserción:");
			System.out.println("Raíz del montículo de Mínimo: " + minHeap.pispear());
			System.out.println("Raíz del montículo de Máximo: " + maxHeap.pispear());
		}
		
		System.out.println("Montículo de Mínimo Completo");
		minHeap.mostrar();

		System.out.println("Montículo de Máximo Completo");
		maxHeap.mostrar();
		
		System.out.println("Eliminando nodos de los montículos");
		for (int i = 0; i < 10; i++) {
			minHeap.eliminar();
			maxHeap.eliminar();
			System.out.println("Luego de " + (i+1) + "° eliminación:");
			System.out.println("Raíz del montículo de Mínimo: " + minHeap.pispear());
			System.out.println("Raíz del montículo de Máximo: " + maxHeap.pispear());
		}
		System.out.println("Montículos vacíos");
	}

}
