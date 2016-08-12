package test.semana04;

import static org.junit.Assert.*;

import org.junit.Test;

import main.semana04.Produto;

public class ProdutoTest {

	@Test
	public void produtoIguais() {
		Produto p1 = new Produto(1, "Camiseta Amarela", 10.0);
		Produto p2 = new Produto(1, "Camiseta Vermelha", 10.0);
		assertEquals(p1, p2);
	}

	@Test
	public void produtoComDescricaoIgualCodigoDiferente() {
		Produto p1 = new Produto(1, "Camiseta Amarela", 10.0);
		Produto p2 = new Produto(2, "Camiseta Amarela", 10.0);
		assertNotEquals(p1, p2);
	}

}
