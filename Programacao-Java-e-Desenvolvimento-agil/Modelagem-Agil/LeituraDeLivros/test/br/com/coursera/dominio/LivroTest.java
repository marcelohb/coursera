package br.com.coursera.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.coursera.aplicacao.Aplicacao;

public class LivroTest {
	
	private Livro livro;
	
	@Before
	public void setUp() {
		livro = new Livro("Primeiro Livro", "Autor", Estilo.DRAMA, 123);
		Aplicacao.carregarLivros();
	}

	@Test
	public void livrosIguais() {
		Livro l2 = new Livro("Primeiro Livro", "Autor", Estilo.DRAMA, 123);
		assertEquals(l2, livro);
		assertEquals(Double.valueOf(0.0), l2.getPontosDeLeitura());
	}
	
	@Test
	public void livrosDiferentes() {
		Livro l2 = new Livro("Primeiro Livro", "Autor", Estilo.FICCAO_CIENTIFICA, 123);
		assertNotEquals(l2, livro);
		assertEquals(Double.valueOf(0.0), l2.getPontosDeLeitura());
	}
	
	@Test
	public void quantidadeDeLivros() {
		assertEquals(7, Aplicacao.listaDeLivros().size());
	}

}
