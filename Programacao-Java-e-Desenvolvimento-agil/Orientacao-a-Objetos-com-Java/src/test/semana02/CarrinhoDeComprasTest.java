package test.semana02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.semana02.CarrinhoDeCompras;
import main.semana02.Pizza;

public class CarrinhoDeComprasTest {
	
	CarrinhoDeCompras c1;
	
	@Before
	public void setUp() {
		c1 = new CarrinhoDeCompras(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pizzaSemIngrediente() {
		Pizza p1 = new Pizza("Vazia");
		c1.adicionarPizza(p1);
	}

	@Test
	public void adicionarPizza() {
		Pizza p1 = new Pizza("Especial");
		p1.adicionarIngrediente("azeitona");
		c1.adicionarPizza(p1);
		assertEquals(new Double(15), c1.total());
	}
	@Test
	public void carrinhoCom3Pizzas() {
		Pizza p1 = new Pizza("Um");
		p1.adicionarIngrediente("Mussarela");
		p1.adicionarIngrediente("Presunto");
		c1.adicionarPizza(p1);
		Pizza p2 = new Pizza("Dois");
		p2.adicionarIngrediente("Mussarela");
		p2.adicionarIngrediente("Catupiry");
		p2.adicionarIngrediente("Ovo");
		p2.adicionarIngrediente("Cebola");
		c1.adicionarPizza(p2);
		Pizza p3 = new Pizza("Tres");
		p3.adicionarIngrediente("Mussarela");
		p3.adicionarIngrediente("Catupiry");
		p3.adicionarIngrediente("Ovo");
		p3.adicionarIngrediente("Cebola");
		p3.adicionarIngrediente("Bacon");
		p3.adicionarIngrediente("Azeitona");
		p3.adicionarIngrediente("Presunto");
		c1.adicionarPizza(p3);
		assertEquals(new Double(58), c1.total());
		c1.imprimir();
	}

}
