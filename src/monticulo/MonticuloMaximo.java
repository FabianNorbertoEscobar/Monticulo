package monticulo;

public class MonticuloMaximo extends Monticulo {

	public MonticuloMaximo(int tamañoMaximo) {
		super(tamañoMaximo);
		this.nodo[0] = Integer.MAX_VALUE;
	}

	@Override
	protected boolean condicion(int hijo, int padre) {
		return this.nodo[hijo] <= this.nodo[padre];
	}

}
