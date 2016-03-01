package com.eic.cefet.cg.vetor.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.eic.cefet.cg.vetor.entidade.Vetor;

public class OperationTest {

	Vetor u, v;
	
	@Before
	public void init() {
		u = new Vetor(2, 4, 9);
		v = new Vetor(10, 15, 3);
	}
	
	@Test
	public void testSoma() {
		assertEquals(new Vetor(12, 19, 12), Operation.soma(u, v));
	}

	@Test
	public void testDiferenca() {
		assertEquals(new Vetor(-8, -11, 6), Operation.diferenca(u, v));
	}

	@Test
	public void testMultiplicacao() {
		assertEquals(new Vetor(6, 12, 27), Operation.multiplicacao(3, u));
	}

	@Test
	public void testVetorDefinido() {
		assertEquals(new Vetor(8, 11, -6), Operation.vetorDefinido(u, v));
	}

	@Test
	public void testSaoParalelo() {
		assertFalse(Operation.saoParalelos(u, v));
	}

	@Test
	public void testPontoMedio() {
		double[] a = new double[]{u.getX(), u.getY(), u.getZ()};
		double[] b = new double[]{v.getX(), v.getY(), v.getZ()};
		double[] pontoMedio = new double[]{6, 9.5, 6};
		
		assertEquals(pontoMedio[0], Operation.pontoMedio(a, b)[0], 0);
		assertEquals(pontoMedio[1], Operation.pontoMedio(a, b)[1], 0);
		assertEquals(pontoMedio[2], Operation.pontoMedio(a, b)[2], 0);
	}

	@Test
	public void testDistancia() {
		double[] a = new double[]{u.getX(), u.getY(), u.getZ()};
		double[] b = new double[]{v.getX(), v.getY(), v.getZ()};
		
		double expected = Math.sqrt(Math.pow(8, 2) + Math.pow(11, 2) + Math.pow(-6, 2));
		
		assertEquals(expected, Operation.distancia(a, b), 0);
	}

	@Test
	public void testModulo() {
		double expected = Math.sqrt(Math.pow(2, 2) + Math.pow(4, 2) + Math.pow(9, 2));
		
		assertEquals(expected, Operation.modulo(u), 0);
	}

	@Test
	public void testProdutoEscalar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaoOrtogonal() {
		fail("Not yet implemented");
	}

	@Test
	public void testCos() {
		fail("Not yet implemented");
	}

	@Test
	public void testAngulo() {
		fail("Not yet implemented");
	}

	@Test
	public void testCosDiretorX() {
		fail("Not yet implemented");
	}

	@Test
	public void testCosDiretorY() {
		fail("Not yet implemented");
	}

	@Test
	public void testCosDiretorZ() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnguloDiretorX() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnguloDiretorY() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnguloDiretorZ() {
		fail("Not yet implemented");
	}

	@Test
	public void testProjecao() {
		fail("Not yet implemented");
	}

}
