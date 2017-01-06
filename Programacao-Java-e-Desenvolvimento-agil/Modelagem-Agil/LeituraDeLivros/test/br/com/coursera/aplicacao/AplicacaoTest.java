package br.com.coursera.aplicacao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AplicacaoTest {
	
	@Before
	public void setUp() {
		Aplicacao.limparLivros();
		Aplicacao.limparUsuarios();
		Aplicacao.carregarLivros();
		Aplicacao.carregarUsuarios();
	}

	@Test
	public void verificarCargaDeUsuarios() {
		assertEquals(10, Aplicacao.listaDeUsuarios().size());
	}

	@Test
	public void verificarCargaDeLivros() {
		assertEquals(7, Aplicacao.listaDeLivros().size());
	}
	
	@Test
	public void registrarLeituraDeLivro() {
		Aplicacao.usuarioLeuLivro(1,1);
		Aplicacao.usuarioLeuLivro(2,2);
		Aplicacao.usuarioLeuLivro(2,1);
		assertEquals(1, Aplicacao.listaDeLivrosLidos(1).size());
	}

}
