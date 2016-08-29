package test.br.com.coursera.mecanicadojogo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoFabrica;
import main.br.com.coursera.util.ModoDeJogo;

public class MecanicaDoJogoFabricaTest {
	
	MecanicaDoJogoFabrica fabrica;
	
	@Before()
	public void setUp() {
		fabrica = new MecanicaDoJogoFabrica();
	}

	@Test
	public void mecanicaVazia() {
		MecanicaDoJogo jogoFacil = fabrica.novoJogo();
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
	}

	@Test
	public void mecanicaFacil() {
		MecanicaDoJogo jogoFacil = fabrica.novoJogo(ModoDeJogo.FACIL);
		assertEquals(jogoFacil.modo(), ModoDeJogo.FACIL);
	}

	@Test
	public void mecanicaMedio() {
		MecanicaDoJogo jogo = fabrica.novoJogo(ModoDeJogo.MEDIO);
		assertEquals(jogo.modo(), ModoDeJogo.MEDIO);
	}

	@Test
	public void mecanicaDificil() {
		MecanicaDoJogo jogo = fabrica.novoJogo(ModoDeJogo.DIFICIL);
		assertEquals(jogo.modo(), ModoDeJogo.DIFICIL);
	}

}
