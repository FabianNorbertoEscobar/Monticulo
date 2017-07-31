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
			System.out.println("Ra�z del mont�culo de M�nimo: " + minHeap.pispear());
			System.out.println("Ra�z del mont�culo de M�ximo: " + maxHeap.pispear());
		}
		System.out.println("Mont�culos vac�os");
	}

}
