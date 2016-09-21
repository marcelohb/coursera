package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Transformar;

public class TransformarTest {
	
	Transformar transformar;
	String palavra;
	
	@Before
	public void setUp() {
		transformar = new Transformar();
		palavra = "NomeCasaAlimento";
	}

	@Test
	public void quebrarPalavra() {
		transformar.separarPalavras(palavra);
		assertEquals(3,transformar.getListaDePalavras().size());
	}
	
	@Test
	public void conferirPalavras() {
		transformar.separarPalavras(palavra);
		assertEquals("nome", transformar.getListaDePalavras().get(0));
		assertEquals("casa", transformar.getListaDePalavras().get(1));
		assertEquals("alimento", transformar.getListaDePalavras().get(2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeIniciarComNumero() {
		palavra = "10nomeCasaJoao";
		transformar.separarPalavras(palavra);
		assertEquals("10nome", transformar.getListaDePalavras().get(0));
		assertEquals("casa", transformar.getListaDePalavras().get(1));
		assertEquals("joao", transformar.getListaDePalavras().get(2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeConterCaracteresEspeciais() {
		palavra = "nomeCasa#Joao";
		transformar.separarPalavras(palavra);
		assertEquals("nome", transformar.getListaDePalavras().get(0));
		assertEquals("casa", transformar.getListaDePalavras().get(1));
		assertEquals("joao", transformar.getListaDePalavras().get(2));
	}
	
	@Test
	public void separarSilabas() {
		palavra = "nomeITANome";
		transformar.separarPalavras(palavra);
		assertEquals("nome", transformar.getListaDePalavras().get(0));
		assertEquals("ITA", transformar.getListaDePalavras().get(1));
		assertEquals("nome", transformar.getListaDePalavras().get(2));
		assertEquals(3,transformar.getListaDePalavras().size());
	}

}
