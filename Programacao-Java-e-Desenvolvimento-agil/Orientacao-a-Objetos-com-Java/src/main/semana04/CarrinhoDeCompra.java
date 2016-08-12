package main.semana04;

import java.util.HashMap;
import java.util.Set;

public class CarrinhoDeCompra {
	
	private int id;
	private HashMap<Produto, Integer> produtos;
	Double total = 0.0;

	public CarrinhoDeCompra(int id) {
		this.id = id;
		produtos = new HashMap<>();
	}

	public void adicionarProduto(Produto produto, int quantidade) {
		if (produtos.isEmpty()) {
			produtos.put(produto, quantidade);
			return;
		}
		Set<Produto> chaves = produtos.keySet();
		for (Produto p : chaves) {
			if (p.equals(produto)) {
				produtos.put(p, produtos.get(p)+quantidade);
				break;
			} else {
				produtos.put(produto, quantidade);
				break;
			}
		}
	}

	public int quantidadeProduto(Produto produto) {
		return produtos.get(produto);
	}
	
	public Double total() {
		Set<Produto> chaves = produtos.keySet();
		for (Produto p : chaves) {
			total += p.getPreco() * produtos.get(p);
		}
		return total;
	}
	
	public int getId() {
		return this.id;
	}

	public void removerProduto(Produto produto, int quantidade) {
		if (produtos.isEmpty()) {
			return;
		}
		Set<Produto> chaves = produtos.keySet();
		for (Produto p : chaves) {
			if (p.equals(produto)) {
				if (produtos.get(p)-quantidade < 0) {
					produtos.put(p, 0);
				} else {
					produtos.put(p, produtos.get(p)-quantidade);
				}
			} else {
				produtos.remove(produtos.get(produto));
			}
		}
	}

}
