package main.br.com.coursera.embaralhador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorRandomico implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		List<String> lista = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		char[] s = palavra.toCharArray();
		for (char cc : s)
			lista.add(String.valueOf(cc));
		Collections.shuffle(lista);
		
		lista.forEach(letra -> sb.append(letra));
		return sb.toString();
	}

	@Override
	public String novaPalavra() {
		return null;
	}

}
