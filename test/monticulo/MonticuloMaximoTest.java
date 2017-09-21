package monticulo;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonticuloMaximoTest {

	private Monticulo monticulo;

	@Before
	public void queSeInstancia() {
		monticulo = new MonticuloMaximo(10);
	}

	@Test
	public void estaLlena() {
		Assert.assertFalse(this.monticulo.estaLleno());
	}

	@Test
	public void estaVacio() {
		Assert.assertTrue(this.monticulo.estaVacio());
	}

	@Test
	public void queInserta() {
		this.monticulo.insertar(5);
		Assert.assertFalse(this.monticulo.estaVacio());
	}

	@Test
	public void queElimina() {
		this.monticulo.insertar(5);
		Assert.assertEquals(5, this.monticulo.eliminar());
	}

	@Test
	public void quePispea() {
		this.monticulo.insertar(5);
		Assert.assertEquals(5, this.monticulo.pispear());
		Assert.assertFalse(this.monticulo.estaVacio());
	}

	@Test
	public void queSeRespetaLaPrioridad() {
		this.monticulo.insertar(5);
		this.monticulo.insertar(2);
		this.monticulo.insertar(4);
		this.monticulo.insertar(1);
		this.monticulo.insertar(3);
		Assert.assertEquals(5, this.monticulo.eliminar());
		Assert.assertEquals(4, this.monticulo.eliminar());
		Assert.assertEquals(3, this.monticulo.eliminar());
		Assert.assertEquals(2, this.monticulo.eliminar());
		Assert.assertEquals(1, this.monticulo.eliminar());
	}

	@Test(expected = IllegalStateException.class)
	public void queSeLLena() {
		Random rand = new Random();
		while (true) {
			this.monticulo.insertar(rand.nextInt(100));
		}
	}

	@Test(expected = IllegalStateException.class)
	public void queSeVacia() {
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			this.monticulo.insertar(rand.nextInt(100));
		}
		while (true) {
			this.monticulo.eliminar();
		}
	}
}
