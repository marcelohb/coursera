package test.br.com.coursera.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.br.com.coursera.util.Arquivo;

public class ArquivoTest {
	
	List<String> palavras = new ArrayList<String>();

	@Test
	public void lerArquivo() {
		Arquivo arquivo = new Arquivo("src/PALAVRAS.txt");
		palavras = arquivo.retornarPalavras();
		assertEquals(palavras.size(), 3);
	}

}
