package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Pontos;
import main.Usuario;

public class UsuarioTest {
	
	private Usuario guerra;
	
	@Before
	public void setUp() {
		guerra = new Usuario("guerra");
		guerra.obterPontuacao().put(Pontos.CURTIDA,10);
	}

	@Test
	public void somarQuantidadeDeUmTipo() {
		int qtd;
		guerra.somarPontuacao(Pontos.CURTIDA, 1);
		qtd = guerra.obterPontuacao().get(Pontos.CURTIDA);
		assertEquals(11, qtd);
	}

	@Test
	public void somarQuantidadeComDoisTipos() {
		int qtdCurtida, qtdComentario;
		guerra.obterPontuacao().put(Pontos.COMENTARIO, 5);
		guerra.somarPontuacao(Pontos.CURTIDA, 1);
		guerra.somarPontuacao(Pontos.COMENTARIO, 5);
		qtdCurtida = guerra.obterPontuacao().get(Pontos.CURTIDA);
		qtdComentario = guerra.obterPontuacao().get(Pontos.COMENTARIO);
		assertEquals(11, qtdCurtida);
		assertEquals(10, qtdComentario);
	}
	
	@Test
	public void somarTipoQueNaoExiste() {
		int qtdEstrelaNaoExiste;
		guerra.somarPontuacao(Pontos.ESTRELA, 1);
		qtdEstrelaNaoExiste = guerra.obterPontuacao().get(Pontos.ESTRELA);
		assertEquals(1, qtdEstrelaNaoExiste);
	}

}
