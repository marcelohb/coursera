package main;

import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Usuario {
	
	private String nome;
	private HashMap<Pontos, Integer> pontuacao;

	public Usuario(String nome) {
		this.nome = nome.toUpperCase();
		pontuacao = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<Pontos, Integer> obterPontuacao() {
		return pontuacao;
	}

	public Integer obterPontuacaoPorTipo(Pontos tipo) {
		return pontuacao.get(tipo);
	}

	public void setPontuacao(HashMap<Pontos, Integer> pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario u = (Usuario) obj;
		return this.nome.equals(u.getNome());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public String toString() {
//		String r = "nome: " + nome + " [ ";
//		Set<Pontos> chave = pontuacao.keySet();
//		for (Pontos c : chave) {
//			r += c.toString() + ":" + pontuacao.get(c);
//		}
//		r += "]";
//		return  r;
		return toJson();
	}
	
	public String toJson() {
		JSONObject obj = new JSONObject();
		obj.put("nome", nome);
		JSONArray pontos = new JSONArray();
		Set<Pontos> chave = pontuacao.keySet();
		for (Pontos p : chave) {
			pontos.add(p + " : " + pontuacao.get(p));
		}
		obj.put("pontos", pontos);
		return obj.toJSONString();
	}

	public void somarPontuacao(Pontos pontos, int quantidade) {
		int quantidadeAntiga = 0;
		if (pontuacao.containsKey(pontos))
			quantidadeAntiga = this.pontuacao.get(pontos);
		pontuacao.put(pontos, quantidadeAntiga + quantidade);
	}

}
