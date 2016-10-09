package main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Armazenamento {
	
	private Path arquivo;
	
	public Armazenamento(String caminho) {
		arquivo = Paths.get(caminho);
	}

	public boolean lerArquivo() {
		
		if (arquivo.toFile().exists())
			return true;
		
		try {
			return arquivo.toFile().createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void armazenar(String usuario, int quantidade, Pontos tipo) throws FileNotFoundException {
		BufferedWriter escrever = null;
		try {
			escrever = Files.newBufferedWriter(arquivo);
			escrever.write(usuario+"|"+quantidade+"|"+tipo);
			escrever.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
