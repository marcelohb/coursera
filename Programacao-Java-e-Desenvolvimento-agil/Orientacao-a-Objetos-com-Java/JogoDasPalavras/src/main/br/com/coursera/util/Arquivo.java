package main.br.com.coursera.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Arquivo {
	
	private String caminho;
	private Stream<String> linhas;
	
	public Arquivo(String caminho) {
		this.caminho = caminho;
	}

	private List<String> palavras = new ArrayList<String>();

	public List<String> retornarPalavras() {
		try {
			Path caminho = Paths.get(this.caminho);
			linhas = Files.lines(caminho);
			linhas.forEach(c -> palavras.add(c.toUpperCase()));
		} catch (NoSuchFieldError ae) {
			System.out.println("Problema na leitura do arquivo " + caminho);
		} catch (IOException e) {
			System.out.println("Problema com o arquivo: " + caminho);
		} finally {
			linhas.close();
		}
		return palavras;
	}

}
