package test.br.com.coursera;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoFabrica;
import main.br.com.coursera.util.ModoDeJogo;

public class PrincipalTest {
	
	MecanicaDoJogoFabrica fabrica;
	
	@Before()
	public void setUp() {
		fabrica = new MecanicaDoJogoFabrica();
	}

	@Test
	public void novoJogoVazio() {
		MecanicaDoJogo jogoFacil = fabrica.novoJogo();
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
		assertEquals("UE", jogoFacil.novaPalavra());
		assertTrue(jogoFacil.acertouPalavra("EU"));
		assertEquals("UT", jogoFacil.novaPalavra());
		assertTrue(jogoFacil.acertouPalavra("TU"));
		assertTrue(jogoFacil.acertouPalavra("ELES"));
		assertEquals(new Double(3.0), jogoFacil.pontuacaoFinal());
	}
	
	@Test
	public void ganharJogoFacil() {
		MecanicaDoJogo jogoFacil = fabrica.novoJogo(ModoDeJogo.FACIL);
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
		assertTrue(jogoFacil.acertouPalavra("EU"));
		assertTrue(jogoFacil.acertouPalavra("TU"));
		assertTrue(jogoFacil.acertouPalavra("ELES"));
		assertTrue(jogoFacil.acertouPalavra("NOS"));
		assertTrue(jogoFacil.acertouPalavra("VOS"));
		assertTrue(jogoFacil.acertouPalavra("ABACAXI"));
		assertEquals(new Double(6.0), jogoFacil.pontuacaoFinal());
		assertTrue(jogoFacil.fimDeJogo());
	}
	
	@Test
	public void perderJogoFacil() {
		MecanicaDoJogo jogoFacil = fabrica.novoJogo(ModoDeJogo.FACIL);
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
		assertTrue(jogoFacil.acertouPalavra("EU"));
		assertFalse(jogoFacil.acertouPalavra("xx"));
		assertFalse(jogoFacil.acertouPalavra("xx"));
		assertFalse(jogoFacil.acertouPalavra("xx"));
		assertFalse(jogoFacil.acertouPalavra("xx"));
		assertFalse(jogoFacil.acertouPalavra("xx"));
		assertEquals(new Double(0.0), jogoFacil.pontuacaoFinal());
		assertTrue(jogoFacil.fimDeJogo());
	}
	
	@Test
	public void perderJogoMedio() {
		MecanicaDoJogo jogo = fabrica.novoJogo(ModoDeJogo.MEDIO);
		assertEquals(jogo.modo(), ModoDeJogo.MEDIO);
		assertTrue(jogo.acertouPalavra("EU"));
		assertFalse(jogo.acertouPalavra("xx"));
		assertEquals(new Double(0.0), jogo.pontuacaoFinal());
		assertFalse(jogo.fimDeJogo());
		assertTrue(jogo.acertouPalavra("TU"));
		assertEquals(new Double(1.0), jogo.pontuacaoFinal());
		assertFalse(jogo.acertouPalavra("xx"));
		assertFalse(jogo.acertouPalavra("xx"));
		assertFalse(jogo.acertouPalavra("xx"));
		assertTrue(jogo.fimDeJogo());
	}
	
	@Test
	public void ganharJogoMedio() {
		MecanicaDoJogo jogo = fabrica.novoJogo(ModoDeJogo.MEDIO);
		assertEquals(jogo.modo(), ModoDeJogo.MEDIO);
		assertTrue(jogo.acertouPalavra("EU"));
		assertFalse(jogo.acertouPalavra("xx"));
		assertEquals(new Double(0.0), jogo.pontuacaoFinal());
		assertFalse(jogo.fimDeJogo());
		assertTrue(jogo.acertouPalavra("TU"));
		assertEquals(new Double(1.0), jogo.pontuacaoFinal());
		assertEquals("eleS", jogo.novaPalavra());
//		assertFalse(jogo.acertouPalavra("ELES"));
//		assertFalse(jogo.acertouPalavra("NOS"));
//		assertFalse(jogo.acertouPalavra("VOS"));
//		assertFalse(jogo.acertouPalavra("ABACAXI"));
		assertEquals(new Double(5.0), jogo.pontuacaoFinal());
		assertTrue(jogo.fimDeJogo());
	}

}
