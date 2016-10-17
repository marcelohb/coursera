package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Armazenamento;
import main.Pontos;
import main.Usuario;

public class ArmazenamentoTest {
	
	Armazenamento armazenamento;
	
	@Before
	public void setUp() {
		armazenamento = new Armazenamento("src/gamificacao.txt");
	}
//
//	@Test
//	public void criarArquivoSeNaoExistir() {
//		assertTrue(armazenamento.lerArquivo());
//	}
	
	@Test
	public void adicionarUsuarioALista() {
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("tomas", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 10, Pontos.CURTIDA);
		assertEquals(3,armazenamento.recuperarUsuarios().size());
	}
	
	@Test
	public void adicionarUsuarioQueJaExiste() {
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 10, Pontos.CURTIDA);
		assertEquals(2,armazenamento.recuperarUsuarios().size());
	}
	
	@Test
	public void recuperarQuantidadeDeUmUsuarioPorTipo() {
		int qtdGuerra, qtdEu;
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 11, Pontos.CURTIDA);
		qtdGuerra = armazenamento.recuperarPontosUsuarioPorTipo(new Usuario("Guerra"), Pontos.CURTIDA);
		qtdEu = armazenamento.recuperarPontosUsuarioPorTipo(new Usuario("eu"), Pontos.CURTIDA);
		assertEquals(2,armazenamento.recuperarUsuarios().size());
		assertEquals(10, qtdGuerra);
		assertEquals(11, qtdEu);
	}
	
	@Test
	public void recuperarQuantidadeDeUmMesmoUsuarioDeDoisTipos() {
		int qtdCurtida, qtdEstrela;
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 10, Pontos.ESTRELA);
		armazenamento.armazenar("eu", 1, Pontos.CURTIDA);
		qtdEstrela = armazenamento.recuperarPontosUsuarioPorTipo(new Usuario("eu"), Pontos.ESTRELA);
		qtdCurtida = armazenamento.recuperarPontosUsuarioPorTipo(new Usuario("eu"), Pontos.CURTIDA);
		assertEquals(10, qtdEstrela);
		assertEquals(1, qtdCurtida);
	}
	
	@Test
	public void recuperarUsuariosArmazenados() {
		int quantidadeDeUsuarios;
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 5, Pontos.ESTRELA);
		armazenamento.armazenar("tomas", 2, Pontos.COMENTARIO);
		armazenamento.armazenar("chimbinha", 1, Pontos.MOEDA);
		quantidadeDeUsuarios = armazenamento.recuperarUsuarios().size();
		assertEquals(4, quantidadeDeUsuarios);
	}
	
	@Test
	public void recuperarTiposDePontos() {
		int quantidadeDeTipoDePontos=0;
		armazenamento.armazenar("guerra", 10, Pontos.CURTIDA);
		armazenamento.armazenar("eu", 5, Pontos.ESTRELA);
		armazenamento.armazenar("eu", 12, Pontos.MOEDA);
		armazenamento.armazenar("tomas", 2, Pontos.COMENTARIO);
		armazenamento.armazenar("chimbinha", 1, Pontos.MOEDA);
		quantidadeDeTipoDePontos = armazenamento.recuperarTiposDePontosDeUmUsuario("eu").size();
		assertEquals(2, quantidadeDeTipoDePontos);
	}
	
//	@Test
//	public void armazenarPontosDeUmUsuario() {
//		armazenamento.armazenar("Guerra",10,Pontos.MOEDA);
//		armazenamento.lerArquivo(); // TODO ler arquivo e verificar se existe a linha
//	}
	
//	@Test
//	public void ler() {
//		armazenamento.armazenar("Guerra",10,Pontos.MOEDA);
//		armazenamento.armazenar("Guerra",10,Pontos.CURTIDA);
//		armazenamento.armazenar("chimbinha", 1, Pontos.MOEDA);
//		Usuario u = armazenamento.ler().get(0);
//		assertEquals("GUERRA", u.getNome());
//		assertEquals(Integer.valueOf(10), u.obterPontuacaoPorTipo(Pontos.MOEDA));
//		assertEquals(Integer.valueOf(10), u.obterPontuacaoPorTipo(Pontos.CURTIDA));
//
//		Usuario u2 = armazenamento.ler().get(1);
//		assertEquals("CHIMBINHA", u2.getNome());
//		assertEquals(Integer.valueOf(1), u2.obterPontuacaoPorTipo(Pontos.MOEDA));
//	}

}
