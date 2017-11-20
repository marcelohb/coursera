package br.com.coursera.aplicacao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.coursera.dominio.LivroUsuario;

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
		LivroUsuario lu = new LivroUsuario(1, 1);
		assertTrue(Aplicacao.livrosDoUsuario.contains(lu));
//		for (Livro l : Aplicacao.listaDeLivrosLidos(2)) {
//			System.out.println(l.toString());
//		}
	}
	
	@Test
	public void livroLido() {
		Aplicacao.usuarioLeuLivro(1,1);
		LivroUsuario lu = new LivroUsuario(1, 1);
		assertTrue(Aplicacao.livrosDoUsuario.contains(lu));
	}

}
