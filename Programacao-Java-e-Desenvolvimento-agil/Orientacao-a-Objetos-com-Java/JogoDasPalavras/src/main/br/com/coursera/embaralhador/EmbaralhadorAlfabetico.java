package main.br.com.coursera.embaralhador;

import java.util.Arrays;

public class EmbaralhadorAlfabetico implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		StringBuilder sb = new StringBuilder();
		char[] s = palavra.toCharArray();
		Arrays.sort(s);
		for (char c : s) {
			sb.append(c);
		}
		return sb.toString();
	}

	@Override
	public String novaPalavra() {
		return null;
	}

}
