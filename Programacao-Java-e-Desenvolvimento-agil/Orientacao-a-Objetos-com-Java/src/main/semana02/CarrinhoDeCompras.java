package main.semana02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CarrinhoDeCompras {
	
	private int id;
	private Map<Integer, Pizza> pizzas;
	private Double total;

	public CarrinhoDeCompras(int i) {
		id = i;
		pizzas = new HashMap<>();
		total = new Double(0.0);
	}
	
	public void adicionarPizza(Pizza pizza) {
		if (pizza.ingredientes().size() == 0)
			throw new IllegalArgumentException("Pizza sem ingrediente");
		pizzas.put(pizzas.size()+1, pizza);
	}

	public Double total() {
		Set<Integer> todasAsPizzas = pizzas.keySet();
		for (Integer pizza : todasAsPizzas) {
			total += pizzas.get(pizza).preco();
		}
		return total;
	}
	
	public void imprimir() {
		System.out.println("-----------------------------");
		System.out.println("--------- T O T A L ---------");
		System.out.println("-----------------------------");
		System.out.println("-- R $ : " + total() + ".");
		System.out.println("-----------------------------");
		System.out.println("-- I N G R E D I E N T E S --");
		System.out.println("-----------------------------");
		imprimirIngredientes();
	}
	
	public void imprimirIngredientes() {
		Set<String> todasAsPizzas = Pizza.quantidadeIngredientes.keySet();
		for (String p : todasAsPizzas) {
			System.out.println(p + " - " + Pizza.quantidadeIngredientes.get(p));
		}
	}
	
	public int getId() {
		return id;
	}

}
