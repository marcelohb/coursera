package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import main.Transformar;

public class TransformarTest {
	
	Transformar transformar;
	String palavra;
	
	@Before
	public void setUp() {
		transformar = new Transformar();
		palavra = "NomeCasa";
	}

	@Test
	public void quebrarPalavra() {
		transformar.separarPalavras(palavra);
		assertEquals(2,transformar.getListaDePalavras().size());
	}
	
	@Test
	public void conferirPalavras() {
		transformar.separarPalavras(palavra);
		assertEquals("nome", transformar.getListaDePalavras().get(0));
		assertEquals("casa", transformar.getListaDePalavras().get(1));
	}

}
