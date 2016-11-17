package br.com.coursera.persistencia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.coursera.AbstractTest;
import br.com.coursera.dominio.Topico;
import br.com.coursera.dominio.Usuario;

public class TopicoDaoTest extends AbstractTest {
	
	private TopicoDao dao;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = new TopicoDao(conexao);
	}

	@Test
	public void inserirApenasTitulo() {
		Topico topico = new Topico("Tópico 1", "eu");
		assertEquals(1, dao.inserir(topico));
	}
	
	@Test
	public void inserirTopicoCompleto() {
		Topico topico = new Topico("Topico 2", "jonh");
		topico.setConteudo("Conteudo do topico 2");
		assertEquals(1, dao.inserir(topico));
	}
	
	@Test
	public void registrarPontosDoTopico() {
		String login = "jonh";
		Topico topico = new Topico("Topico 2", login);
		topico.setConteudo("Conteudo do topico 2");
		assertEquals(1, dao.inserir(topico));
		dao.registrarPontos(login);
		UsuarioDao daoUsuario = new UsuarioDao(conexao);
		Usuario u = daoUsuario.recuperar(login);
		assertEquals(10, u.getPontos());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inserirTopicoComUsuarioQueNaoExiste() {
		Topico topico = new Topico("Tópico 1", "xx");
		dao.inserir(topico);
		// TODO criar exceção propria
	}

}
