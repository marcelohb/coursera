package main.br.com.coursera.embaralhador;

public class EmbaralhadorInvertido implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		StringBuilder sb = new StringBuilder(palavra);
		return sb.reverse().toString();
	}

	@Override
	public String novaPalavra() {
		return null;
	}

}
