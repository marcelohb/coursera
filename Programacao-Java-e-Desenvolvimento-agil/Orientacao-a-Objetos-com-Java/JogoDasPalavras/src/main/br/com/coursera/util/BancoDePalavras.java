package main.br.com.coursera.util;

import java.util.List;

public class BancoDePalavras {
	
	public static int palavraAtual = 0;
	private List<String> palavras;

	public BancoDePalavras() {
		Arquivo arq = new Arquivo("src/PALAVRAS.txt");
		palavras = arq.retornarPalavras();
	}
	
	public String proximaPalavra() {
		if (palavraAtual > palavras.size()-1) {
			palavraAtual = palavras.size()-1;
		}
		return palavras.get(palavraAtual);
	}

}
