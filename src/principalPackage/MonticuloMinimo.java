package principalPackage;

public class MonticuloMinimo extends Monticulo {

	public MonticuloMinimo(int tamañoMaximo) {
		super(tamañoMaximo);
		this.nodo[0] = Integer.MIN_VALUE;
	}

	@Override
	protected void montando(int i) {
		if (!this.esHoja(i)) {
			if (!this.tieneHijoUnico(i)) {
				if (!this.condicion(this.hijoIzquierdo(i), i) || !this.condicion(this.hijoDerecho(i), i)) {
					if (!this.condicion(this.hijoIzquierdo(i), this.hijoDerecho(i))) {
						this.intercambiar(i, this.hijoIzquierdo(i));
						this.montando(this.hijoIzquierdo(i));
					} else {
						this.intercambiar(this.hijoDerecho(i), i);
						this.montando(this.hijoDerecho(i));
					}
				}
			} else {
				if (!this.condicion(this.hijoIzquierdo(i), i)) {
					this.intercambiar(i, this.hijoIzquierdo(i));
					this.montando(this.hijoIzquierdo(i));
				}
			}
		}
	}

	@Override
	protected boolean condicion(int hijo, int padre) {
		return this.nodo[hijo] >= this.nodo[padre];
	}
	
}
