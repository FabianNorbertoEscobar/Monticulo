package principalPackage;

public class HeapSort {
	
	public static void sort(int v[]) {
		Monticulo minHeap = new MonticuloMinimo(v.length);
		for (int i = 0; i < v.length; i++) {
			minHeap.insertar(v[i]);
		}
		for (int i = 0; i < v.length; i++) {
			v[i] = minHeap.eliminar();
		}
	}

	public static void reverseSort(int v[]) {
		Monticulo maxHeap = new MonticuloMaximo(v.length);
		for (int i = 0; i < v.length; i++) {
			maxHeap.insertar(v[i]);
		}
		for (int i = 0; i < v.length; i++) {
			v[i] = maxHeap.eliminar();
		}
	}

}
