package principalPackage;

public abstract class Monticulo {

	protected int[] nodo;
	protected int tama�o;
	
	private static final int RAIZ = 1;
	
	public Monticulo(int tama�oMaximo) {
		this.tama�o = 0;
		this.nodo = new int[tama�oMaximo + 1];
	}
	
	protected int padre(int i) {
		return i / 2;
	}
	
	protected int hijoIzquierdo(int i) {
		return 2 * i;
	}
	
	protected int hijoDerecho(int i) {
		return 2 * i + 1;
	}
	
	private boolean tieneHijoIzquierdo(int i) {
		return this.hijoIzquierdo(i) <= this.tama�o;
	}
	
	private boolean tieneHijoDerecho(int i) {
		return this.hijoDerecho(i) <= this.tama�o;
	}
	
	protected boolean tieneHijoUnico(int i) {
		return this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
	}
	
	public boolean estaVacio() {
		return this.tama�o == 0;
	}
	
	public boolean estaLleno() {
		return this.tama�o == this.nodo.length - 1;
	}
	
	protected boolean esHoja(int i) {
		return i >= this.tama�o / 2 && i <= this.tama�o;
	}
	
	protected void intercambiar(int i, int j) {
		int tmp = this.nodo[i];
		this.nodo[i] = this.nodo[j];
		this.nodo[j] = tmp;
	}
	
	private void montar() {
		for (int i = this.tama�o / 2; i >= 1; i--) {
			this.montando(i);
		}
	}
	
	protected abstract void montando(int i);
	
	protected abstract boolean condicion(int hijo, int padre);
	
	public void insertar(int nuevo) {
		if (!this.estaLleno()) {
			this.nodo[++this.tama�o] = nuevo;
			int actual = tama�o;
			while (!this.condicion(actual, this.padre(actual))) {
				this.intercambiar(actual, this.padre(actual));
				actual = this.padre(actual);
			}
			this.montar();
		}
	}
	
	public int eliminar() {
		if (!this.estaVacio()) {
			int nodo = this.nodo[RAIZ];
			this.nodo[RAIZ] = this.nodo[this.tama�o--];
			this.montando(RAIZ);
			return nodo;
		} else {
			return this.nodo[0];
		}
	}
	
	public int pispear() {
		if (!this.estaVacio()) {
			return this.nodo[RAIZ];
		} else {
			return this.nodo[0];
		}
	}
	
	public void mostrar() {
		for (int i = 1; i <= this.tama�o / 2; i++) {
			System.out.print("Padre: " + this.nodo[i]);
			if (this.tieneHijoIzquierdo(i)) {
				System.out.print(" HijoIzquierdo: " + this.nodo[2 * i]);
			}
			if (this.tieneHijoDerecho(i)) {
				System.out.print(" HijoDerecho: " + this.nodo[2 * i + 1]);
			}
			System.out.println();
		}
	}
	
}
