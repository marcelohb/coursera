package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class Arquivo {
	
	private String caminho;
	private Stream<String> linhas;
	private HashMap<String, String> palavras;

	public Arquivo(String caminho) {
		this.caminho = caminho;
		palavras = new HashMap<>();
	}
	
	public HashMap<String, String> palavras() {
		try {
			Path arq = Paths.get(caminho);
			linhas = Files.lines(arq);
			linhas.forEach(s -> palavras.put(fT(s)[0],fT(s)[1]));
			return palavras;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void adicionar(String s) {
		this.palavras.put(fT(s)[0], fT(s)[1]);
	}
	
	private void carregarPalavras() {
		try {
			Path arq = Paths.get(caminho);
			linhas = Files.lines(arq);
			linhas.forEach(s -> palavras.put(fT(s)[0],fT(s)[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String traduzir(String palavra) {
		carregarPalavras();
		String palavraTraduzida;
		if (palavras.isEmpty())
			return "NAO EXISTEM PALAVRAS";
		palavraTraduzida = palavras.get(palavra.toUpperCase());
		if (palavraTraduzida==null)
			return palavra;
		return palavraTraduzida;
	}
	
	/** 
	 * Formatar texto */
	private String[] fT (String textoOriginal) {
		String texto[] = textoOriginal.split("\\|"); 
		return texto;
	}

}
