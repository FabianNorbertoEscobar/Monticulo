package monticulo;

public abstract class Monticulo {

	protected int[] nodo;
	protected int tamaño;

	private static final int RAIZ = 1;

	public Monticulo(int tamañoMaximo) {
		this.tamaño = 0;
		this.nodo = new int[tamañoMaximo + 1];
	}

	private int padre(int i) {
		return i / 2;
	}

	private int hijoIzquierdo(int i) {
		return 2 * i;
	}

	private int hijoDerecho(int i) {
		return 2 * i + 1;
	}

	private boolean tieneHijoIzquierdo(int i) {
		return this.hijoIzquierdo(i) <= this.tamaño;
	}

	private boolean tieneHijoDerecho(int i) {
		return this.hijoDerecho(i) <= this.tamaño;
	}

	private boolean tieneHijoUnico(int i) {
		return this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
	}

	public boolean estaVacio() {
		return this.tamaño == 0;
	}

	public boolean estaLleno() {
		return this.tamaño == this.nodo.length - 1;
	}

	protected boolean esHoja(int i) {
		return !this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
	}

	protected void intercambiar(int i, int j) {
		int tmp = this.nodo[i];
		this.nodo[i] = this.nodo[j];
		this.nodo[j] = tmp;
	}

	private void montar() {
		for (int i = this.tamaño / 2; i >= 1; i--) {
			this.hundir(i);
		}
	}

	private void flotar(int actual) {
		while (!this.condicion(actual, this.padre(actual))) {
			this.intercambiar(actual, this.padre(actual));
			actual = this.padre(actual);
		}
	}

	private void hundir(int i) {
		if (!this.esHoja(i)) {
			if (!this.tieneHijoUnico(i)) {
				if (!this.condicion(this.hijoIzquierdo(i), i) || !this.condicion(this.hijoDerecho(i), i)) {
					if (!this.condicion(this.hijoIzquierdo(i), this.hijoDerecho(i))) {
						this.intercambiar(i, this.hijoIzquierdo(i));
						this.hundir(this.hijoIzquierdo(i));
					} else {
						this.intercambiar(this.hijoDerecho(i), i);
						this.hundir(this.hijoDerecho(i));
					}
				}
			} else {
				if (!this.condicion(this.hijoIzquierdo(i), i)) {
					this.intercambiar(i, this.hijoIzquierdo(i));
					this.hundir(this.hijoIzquierdo(i));
				}
			}
		}
	}

	protected abstract boolean condicion(int hijo, int padre);

	public void insertar(int nuevo) throws IllegalStateException {
		if (this.estaLleno()) {
			throw new IllegalStateException("No se puede insertar nuevo elemento. Montículo lleno.");
		}
		this.nodo[++this.tamaño] = nuevo;
		this.flotar(this.tamaño);
		this.montar();
	}

	public int eliminar() throws IllegalStateException {
		if (this.estaVacio()) {
			throw new IllegalStateException("No se puede eliminar un elemento. Montículo vacío.");
		}
		int nodo = this.nodo[RAIZ];
		this.nodo[RAIZ] = this.nodo[this.tamaño--];
		this.hundir(RAIZ);
		return nodo;
	}

	public int pispear() throws IllegalStateException {
		if (this.estaVacio()) {
			throw new IllegalStateException("No se puede pispear un elemento. Montículo vacío.");
		}
		return this.nodo[RAIZ];
	}

	public void mostrar() {
		for (int i = 1; i <= this.tamaño / 2; i++) {
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
