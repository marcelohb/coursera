package test.semana04Complementar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.semana04Complementar.CompraParcelada;

public class CompraParceladaTest {
	
	@Test
	public void compraUmaParcela() {
		CompraParcelada cp = new CompraParcelada(10.0, 1, 0.1);
		 assertEquals(new Double(11.0), cp.total());
	}
	
	@Test
	public void compraDuasParcelas() {
		CompraParcelada cp = new CompraParcelada(10.0, 2, 0.1);
		 assertEquals(new Double(12.1), cp.total(),0.01);
	}
	
	@Test
	public void compraCincoParcelas() {
		CompraParcelada cp = new CompraParcelada(10.0, 5, 0.1);
		 assertEquals(new Double(16.10), cp.total(),0.1);
	}
	
	@Test
	public void compraDezParcelas() {
		CompraParcelada cp = new CompraParcelada(10.0, 10, 0.1);
		 assertEquals(new Double(25.93), cp.total(),0.1);
	}
	
}
