package test.semana04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import main.semana04.Produto;
import main.semana04.ProdutoComTamanho;

public class ProdutoComTamanhoTest {

	@Test
	public void produtoIgual() {
		ProdutoComTamanho p1 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 7.0);
		ProdutoComTamanho p2 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 7.0);
		assertEquals(p1, p2);
	}

	@Test
	public void produtoComTamanhoIgual() {
		Produto p1 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 8.0);
		ProdutoComTamanho p2 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 8.0);
		assertEquals(p1, p2);
	}
	
	@Test
	public void produtoCodigoIgualTamanhoDiferente() {
		ProdutoComTamanho p1 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 7.0);
		ProdutoComTamanho p2 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 8.0);
		assertNotEquals(p1, p2);
	}
	
	@Test
	public void produtoCodigoDiferenteTamanhoIgual() {
		ProdutoComTamanho p1 = new ProdutoComTamanho(1, "C. Amarela", 10.0, 7.0);
		ProdutoComTamanho p2 = new ProdutoComTamanho(2, "C. Amarela", 10.0, 7.0);
		assertNotEquals(p1, p2);
	}

}
