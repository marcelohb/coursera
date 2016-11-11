package br.com.coursera.persistencia;

import org.junit.Before;
import org.junit.Test;

import br.com.coursera.persistencia.Conexao;

public class ConexaoTest {
	
	private Conexao c;
	
	@Before
	public void setUp() {
		c = new Conexao();
	}

	@Test
	public void conectar() {
		c.conectar();
	}

}
