package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Arquivo {
	
	private String caminho;
	private Stream<String> linhas;

	public Arquivo(String caminho) {
		this.caminho = caminho;
	}
	
	public List<String> palavras() {
		try {
			Path arq = Paths.get(caminho);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
