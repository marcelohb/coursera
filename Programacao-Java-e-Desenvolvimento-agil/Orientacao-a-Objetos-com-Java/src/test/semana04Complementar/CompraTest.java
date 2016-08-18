package test.semana04Complementar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.semana04Complementar.Compra;

public class CompraTest {
	
	Compra compra;

	@Before
	public void setUp() {
		compra = new Compra(10.0);
	}
	
	@Test
	public void valorTotal() {
		assertEquals(new Double(10.0), compra.total());
	}
}
