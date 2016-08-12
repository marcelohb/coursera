package main.semana02;

import java.util.HashMap;
import java.util.Map;

public class Pizza {
	
	private String sabor;
	private Map<String, Integer> ingredientes;
	private Integer preco;
	public static Map<String, Integer> quantidadeIngredientes = new HashMap<>();

	public Pizza(String sabor) {
		this.sabor = sabor;
		ingredientes = new HashMap<>();
	}

	public void adicionarIngrediente(String ingrediente) {
		ingredientes.put(ingrediente, null);
		contabilizaIngrediente(ingrediente);
	}

	private void contabilizaIngrediente(String ingrediente) {
		if (quantidadeIngredientes.containsKey(ingrediente)) {
			int qtd = quantidadeIngredientes.get(ingrediente);
			quantidadeIngredientes.put(ingrediente, qtd+1);
		} else {
			quantidadeIngredientes.put(ingrediente, 1);
		}
	}
	
	public static void limparIngredientes() {
		quantidadeIngredientes.clear();
	}

	public Integer preco() {
		int qtdIngredientes = ingredientes.size();
		switch (qtdIngredientes) {
		case 1: case 2:
			preco = 15;
			break;
		case 3: case 4: case 5:
			preco = 20;
			break;
		default:
			preco = 23;
		}
		return preco;
	}
	
	public String sabor() {
		return this.sabor;
	}
	
	public Map<String,Integer> ingredientes() {
		return ingredientes;
	}

}
