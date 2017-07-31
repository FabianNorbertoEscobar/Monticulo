package principalPackage;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Monticulo minHeap = new MonticuloMinimo(10);
		Monticulo maxHeap = new MonticuloMaximo(10);
		
		for (int i = 0; i < 10; i++) {
			minHeap.insertar(rand.nextInt(20));
			maxHeap.insertar(rand.nextInt(20));
		}
		
		System.out.println("Mont�culo de M�nimo");
		minHeap.mostrar();

		System.out.println("Mont�culo de M�ximo");
		maxHeap.mostrar();
	}

}
