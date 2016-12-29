package br.com.coursera.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.coursera.aplicacao.Aplicacao;

public class UsuarioTest {
	
	private Usuario u = new Usuario("eu","****","Eu Mesmo"); 

	@Test
	public void compararUsuario() {
		Usuario u2 = new Usuario("eu","****","Eu Mesmo");
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

}
