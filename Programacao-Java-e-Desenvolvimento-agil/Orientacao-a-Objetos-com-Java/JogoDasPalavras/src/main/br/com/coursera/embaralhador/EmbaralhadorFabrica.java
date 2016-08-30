package main.br.com.coursera.embaralhador;

import main.br.com.coursera.util.ModoDeJogo;

public class EmbaralhadorFabrica {

	public Embaralhador novoEmbaralhador(ModoDeJogo modo) {
		if (modo.equals(ModoDeJogo.FACIL)) {
			return new EmbaralhadorInvertido();
		}
		return null;
	}

}
