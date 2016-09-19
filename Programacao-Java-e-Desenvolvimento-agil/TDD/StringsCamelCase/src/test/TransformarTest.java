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

public class TransformarTest {
	
	String palavra;
	char[] arrayDePalavras;
	List<String> listaDePalavras;
	
	@Before
	public void setUp() {
		palavra = "NomeCasa";
		listaDePalavras = new ArrayList<>();
	}

	@Test
	public void quebrarPalavra() {
		arrayDePalavras = palavra.toCharArray();
		String p = null;
		for (char c : arrayDePalavras) {
			
			if (String.valueOf(c).matches("[A-Z]")) {
				if (p != null)
					listaDePalavras.add(p);
				p = null;
			} 
			if (p == null) {
				p = String.valueOf(c);
			} else {
				p += String.valueOf(c);
			}
		}
		listaDePalavras.add(p);
		assertEquals(2,listaDePalavras.size());
	}

}
