package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.Arquivo;

public class ArquivoTest {
	
	Arquivo arquivo;
	
	@Before
	public void setUp() {
		arquivo = new Arquivo("src/PALAVRAS-TEST.TXT");
	}

	@Test
	public void encontrarArquivo() {
		int qtdDePalavras = arquivo.palavras().size();
		assertEquals(1, qtdDePalavras);
	}
	
	@Test
	public void primeiraPalavra() {
		HashMap<String, String> p = arquivo.palavras();
		assertEquals("WORD", p.get("PALAVRA"));
	}
	
	@Test
	public void seNaoExistirRetornarPalavraEmPortugues() {
		String p = arquivo.traduzir("OLEO");
		assertEquals("OLEO", p);
	}
	
	@Test
	public void palavraTraduzida() {
		String p = arquivo.traduzir("PALAVRA");
		assertEquals("WORD", p);
	}

}
