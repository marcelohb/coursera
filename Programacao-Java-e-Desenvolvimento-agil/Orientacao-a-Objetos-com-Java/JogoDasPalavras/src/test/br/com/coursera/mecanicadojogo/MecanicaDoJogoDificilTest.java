package test.br.com.coursera.mecanicadojogo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoDificil;
import main.br.com.coursera.util.BancoDePalavras;

public class MecanicaDoJogoDificilTest {
	
	MecanicaDoJogo mf;
	BancoDePalavras bp;
	String palavraOriginal = "AMO";
	String palavraInvertida = "UE";
	
	@Before
	public void setUp() {
		mf = new MecanicaDoJogoDificil();
		bp = new BancoDePalavras();
	}
	
	@Test
	public void podeTentarCom1Erro() {
		mf.reiniciar();
		mf.respostaErrada();
		assertTrue(mf.podeTentarNovamente());
	}
	
	@Test
	public void naoPodeTentar() {
		mf.reiniciar();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		assertFalse(mf.podeTentarNovamente());
	}
	
	@Test
	public void errar3VezesAMesmaPalavra() {
		mf.reiniciar();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		assertFalse(mf.podeTentarNovamente());
		assertTrue(mf.fimDeJogo());
	}
	
	@Test
	public void pontuacaoFinalNenhumAcerto() {
		mf.reiniciar();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		assertEquals(new Double(0.0), mf.pontuacaoFinal());
	}
	
	@Test
	public void pontuacaoFinalUmAcerto() {
		mf.reiniciar();
		mf.acertouPalavra("EU");
		assertEquals(new Double(1.0), mf.pontuacaoFinal());
	}
	
	@Test
	public void pontuacaoUmAcertoUmErro() {
		mf.reiniciar();
		mf.acertouPalavra("EU");
		mf.respostaErrada();
		assertEquals(new Double(0.0), mf.pontuacaoFinal());
	}
	
	@Test
	public void fimDeJogoPorErro() {
		mf.reiniciar();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		mf.respostaErrada();
		assertTrue(mf.fimDeJogo());
	}
	
	@Test
	public void fimDeJogoPorAcerto() {
		mf.reiniciar();
		mf.acertouPalavra("EU");
		mf.acertouPalavra("TU");
		mf.acertouPalavra("ELES");
		assertTrue(mf.fimDeJogo());
		assertEquals(new Double(3.0), mf.pontuacaoFinal());
	}
	
	@Test
	public void inicioNaoPodeTerFim() {
		mf.reiniciar();
		assertFalse(mf.fimDeJogo());
	}

}
