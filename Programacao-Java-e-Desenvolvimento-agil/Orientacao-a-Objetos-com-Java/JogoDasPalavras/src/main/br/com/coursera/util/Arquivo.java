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
	Stream<String> linhas;
	
	public Arquivo(String caminho) {
		this.caminho = caminho;
	}

	List<String> palavras = new ArrayList<String>();

	public List<String> retornarPalavras() {
		Path caminho = Paths.get(this.caminho);
		try {
			linhas = Files.lines(caminho);
			linhas.forEach(c -> palavras.add(c));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			linhas.close();
		}
		return palavras;
	}

}
