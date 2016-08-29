package test.br.com.coursera.util;

import static org.junit.Assert.*;

import org.junit.Test;

import main.br.com.coursera.util.BancoDePalavras;

public class BancoDePalavrasTest {

	@Test
	public void alterarPalavras() {
		String palavraAtual = "EU";
		BancoDePalavras partida = new BancoDePalavras();
		assertEquals(palavraAtual, partida.proximaPalavra());
	}

}
