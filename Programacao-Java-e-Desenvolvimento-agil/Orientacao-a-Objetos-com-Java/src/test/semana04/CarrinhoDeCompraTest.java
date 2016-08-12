package test.semana04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.semana04.CarrinhoDeCompra;
import main.semana04.Produto;
import main.semana04.ProdutoComTamanho;

public class CarrinhoDeCompraTest {
	
	CarrinhoDeCompra c1;
	
	@Before
	public void setUp() {
		c1 = new CarrinhoDeCompra(1);
	}

	@Test
	public void adicionaProdutoNoCarrinho() {
		Produto p1 = new Produto(1, "Camisa", 10.0);
		c1.adicionarProduto(p1, 1);
		assertEquals(1, c1.quantidadeProduto(p1));
	}
	
	@Test
	public void adicionaMaisDeUmProduto() {
		Produto p1 = new Produto(1, "Camisa Azul", 10.0);
		Produto p2 = new Produto(1, "Camisa Vermelha", 10.0);
		c1.adicionarProduto(p1, 3);
		c1.adicionarProduto(p2, 5);
		assertEquals(8, c1.quantidadeProduto(p1));
	}
	
	@Test
	public void adicionaProdutoTamanhoDiferente() {
		ProdutoComTamanho pMaior = new ProdutoComTamanho(1, "Camisa Azul", 13.0, 7.0);
		ProdutoComTamanho pMaior2 = new ProdutoComTamanho(1, "Camisa Azul", 13.0, 8.0);
		ProdutoComTamanho pMenor = new ProdutoComTamanho(2, "Camisa Azul", 13.0, 5.0);
		c1.adicionarProduto(pMaior, 3);
		c1.adicionarProduto(pMaior2, 1);
		c1.adicionarProduto(pMenor, 5);
		assertEquals(3, c1.quantidadeProduto(pMaior));
		assertEquals(1, c1.quantidadeProduto(pMaior2));
		assertEquals(5, c1.quantidadeProduto(pMenor));
	}
	
	@Test
	public void somaTotalDoCarrinho() {
		Produto p1 = new Produto(1, "Camisa Azul", 10.0);
		Produto p2 = new Produto(2, "Camisa Vermelha", 11.0);
		c1.adicionarProduto(p1, 3);
		c1.adicionarProduto(p2, 5);
		assertEquals(new Double(85.0), c1.total());
	}
	
	@Test
	public void removerProduto() {
		Produto p1 = new Produto(1, "Camisa Azul", 10.0);
		Produto p2 = new Produto(2, "Camisa Vermelha", 11.0);
		c1.adicionarProduto(p1, 3);
		c1.adicionarProduto(p2, 5);
		c1.removerProduto(p1,1);
		assertEquals(2, c1.quantidadeProduto(p1));
		assertEquals(5, c1.quantidadeProduto(p2));
	}
	
	@Test
	public void removerTodosProdutos() {
		Produto p1 = new Produto(1, "Camisa Azul", 10.0);
		Produto p2 = new Produto(2, "Camisa Vermelha", 11.0);
		c1.adicionarProduto(p1, 3);
		c1.adicionarProduto(p2, 5);
		c1.removerProduto(p1,1);
		c1.removerProduto(p1,2);
		assertEquals(0, c1.quantidadeProduto(p1));
		assertEquals(5, c1.quantidadeProduto(p2));
	}
	
	@Test
	public void removerMaisQueAQuantidade() {
		Produto p1 = new Produto(1, "Camisa Azul", 10.0);
		c1.adicionarProduto(p1, 3);
		c1.removerProduto(p1,4);
		assertEquals(0, c1.quantidadeProduto(p1));
	}

}
