package main.semana02;

public class Principal {

	public static void main(String[] args) {
		CarrinhoDeCompras c1 = new CarrinhoDeCompras(1);
		
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
		c1.imprimir();
	}

}
