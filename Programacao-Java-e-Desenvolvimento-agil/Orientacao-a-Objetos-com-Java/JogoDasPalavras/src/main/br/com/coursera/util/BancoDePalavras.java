package main.br.com.coursera.util;

import java.util.List;

public class BancoDePalavras {
	
	public static int palavraAtual = 0;
	public static int ultimaPalavra = 0;
	private List<String> palavras;

	public BancoDePalavras() {
		Arquivo arq = new Arquivo("src/PALAVRAS-TEST.txt");
		palavras = arq.retornarPalavras();
		ultimaPalavra = palavras.size();
	}
	
	public String proximaPalavra() {
		try {
			if (palavraAtual > palavras.size()-1) {
				palavraAtual = palavras.size()-1;
			}
			return palavras.get(palavraAtual);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
