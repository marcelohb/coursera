package test.br.com.coursera.mecanicadojogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoFacil;
import main.br.com.coursera.util.BancoDePalavras;

public class MecanicaDoJogoFacilTest {
	
	MecanicaDoJogo mf;
	BancoDePalavras bp;
	String palavraOriginal = "AMO";
	String palavraInvertida = "UE";
	
	@Before
	public void setUp() {
		mf = new MecanicaDoJogoFacil();
		bp = new BancoDePalavras();
	}

	@Test
	public void inverterPalavra() {
		String embaralhada = mf.novaPalavra();
		assertEquals(palavraInvertida, embaralhada);
	}
	
	@Test
	public void primeiraPalavraInvertida() {
		String embaralhada = mf.novaPalavra();
		assertEquals(palavraInvertida, embaralhada);
	}
	
	@Test
	public void acertarPrimeiraInveterSegunda() {
		mf.reiniciar();
		String embaralhada = mf.novaPalavra();
		assertEquals("UE", embaralhada);
		mf.acertouPalavra();
		embaralhada = mf.novaPalavra();
		assertEquals("UT", embaralhada);
	}
	
	@Test
	public void inveterTerceira() {
		mf.reiniciar();
		String embaralhada = mf.novaPalavra();
		assertEquals("UE", embaralhada);
		mf.acertouPalavra();
		embaralhada = mf.novaPalavra();
		mf.acertouPalavra();
		embaralhada = mf.novaPalavra();
		assertEquals("SELE", embaralhada);
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
		String embaralhada = mf.novaPalavra();
		mf.respostaErrada();
		embaralhada = mf.novaPalavra();
		mf.respostaErrada();
		embaralhada = mf.novaPalavra();
		assertEquals("UE", embaralhada);
		assertTrue(mf.podeTentarNovamente());
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
	public void pontuazaoFinalUmAcerto() {
		mf.reiniciar();
		mf.acertouPalavra();
		assertEquals(new Double(1.0), mf.pontuacaoFinal());
	}
	
	@Test
	public void pontuazaoUmAcertoUmErro() {
		mf.reiniciar();
		mf.acertouPalavra();
		mf.respostaErrada();
		assertEquals(new Double(0.5), mf.pontuacaoFinal());
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
		mf.acertouPalavra();
		mf.acertouPalavra();
		mf.acertouPalavra();
		assertTrue(mf.fimDeJogo());
		assertEquals(new Double(3.0), mf.pontuacaoFinal());
	}

}
