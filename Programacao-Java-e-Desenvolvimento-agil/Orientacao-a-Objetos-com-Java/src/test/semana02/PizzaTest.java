package test.semana02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.semana02.Pizza;

public class PizzaTest {
	
	Pizza p1;
	
	@Before
	public void criarPizza() {
		Pizza.limparIngredientes();
		p1 = new Pizza("Marguerita");
	}

	@Test
	public void precoDaPizzaCom1Ingrediente() {
		p1.adicionarIngrediente("Mussarela");
		assertEquals(new Integer(15), p1.preco());
	}

	@Test
	public void precoDaPizzaCom3Ingrediente() {
		p1.adicionarIngrediente("Mussarela");
		p1.adicionarIngrediente("Manjeiricão");
		p1.adicionarIngrediente("Azeitona");
		assertEquals(new Integer(20), p1.preco());
	}

	@Test
	public void precoDaPizzaComMais5Ingrediente() {
		p1.adicionarIngrediente("Mussarela");
		p1.adicionarIngrediente("Manjeiricão");
		p1.adicionarIngrediente("Azeitona");
		p1.adicionarIngrediente("Cebola");
		p1.adicionarIngrediente("Tomate");
		p1.adicionarIngrediente("Bacon");
		assertEquals(new Integer(23), p1.preco());
	}

	@Test
	public void ingredienteAdicionado() {
		p1.adicionarIngrediente("Mussarela");
		assertTrue(p1.ingredientes().containsKey("Mussarela"));
	}
	
	@Test
	public void pizzasSemIngredientes() {
		p1.adicionarIngrediente("Mussarela");
		p1.adicionarIngrediente("Manjeiricão");
		p1.adicionarIngrediente("Azeitona");
		Pizza.limparIngredientes();
		assertEquals(0, Pizza.quantidadeIngredientes.size());
	}
	
	@Test
	public void contabilizarIngredientes() {
		assertEquals(0, Pizza.quantidadeIngredientes.size());
	}

}
