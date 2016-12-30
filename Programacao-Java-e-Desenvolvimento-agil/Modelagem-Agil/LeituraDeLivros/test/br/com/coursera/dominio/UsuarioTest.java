package br.com.coursera.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.coursera.aplicacao.Aplicacao;

public class UsuarioTest {
	
	private Usuario u = new Usuario("eu","123","Euzequiel"); 

	@Test
	public void compararUsuario() {
		Usuario u2 = new Usuario("eu","123","Euzequiel");
		assertEquals(u, u2);
	}
	
	@Test
	public void novoUsuarioComPontuacaoZerada() {
		assertEquals(Double.valueOf(0.0), u.getPontuacao());
	}
	
	@Test
	public void listaDeUsuariosInicialmente() {
		assertEquals(0, Aplicacao.listaDeUsuarios().size());
	}
	
	@Test
	public void adicionarUsuario() {
		Aplicacao.limparUsuarios();
		Aplicacao.adicionarUsuario(u);
		assertEquals(1, Aplicacao.listaDeUsuarios().size());
	}
	
	@Test
	public void listaDeUsuariosCarregada() {
		Aplicacao.limparUsuarios();
		Aplicacao.carregarUsuarios();
		assertEquals(10, Aplicacao.listaDeUsuarios().size());
	}
	
	@Test
	public void buscarUsuarioPeloLogin() {
		Aplicacao.limparUsuarios();
		Aplicacao.carregarUsuarios();
		Usuario usuarioLogado = Aplicacao.login("eu", "123");
		assertEquals(u, usuarioLogado);
	}
	
	@Test
	public void usuarioInvalido() {
		Aplicacao.limparUsuarios();
		Aplicacao.carregarUsuarios();
		Usuario usuarioLogado = Aplicacao.login("eu", "1234");
		assertEquals(null, usuarioLogado);
	}

}
