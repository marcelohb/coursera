package test.br.com.coursera.util;

import static org.junit.Assert.*;

import org.junit.Test;

import main.br.com.coursera.util.ModoDeJogo;
import main.br.com.coursera.util.Partida;

public class PartidaTest {

	@Test
	public void novaPartida() {
		Partida p1 = new Partida();
		assertEquals(ModoDeJogo.FACIL, p1.modo);
	}

}
