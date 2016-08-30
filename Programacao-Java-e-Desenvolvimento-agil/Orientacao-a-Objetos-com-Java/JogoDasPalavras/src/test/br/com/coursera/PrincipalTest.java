package test.br.com.coursera;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoFabrica;
import main.br.com.coursera.util.BancoDePalavras;
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
		BancoDePalavras bp = new BancoDePalavras();
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
		assertEquals("UE", jogoFacil.novaPalavra());
	}

}
