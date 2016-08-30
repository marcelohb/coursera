package main.br.com.coursera.embaralhador;

import main.br.com.coursera.util.ModoDeJogo;

public class EmbaralhadorFabrica {

	public Embaralhador novoEmbaralhador(ModoDeJogo modo) {
		switch (modo) {
		case FACIL:
			return new EmbaralhadorInvertido();
		case MEDIO:
			return new EmbaralhadorAlfabetico();
		case DIFICIL:
			return new EmbaralhadorRandomico();
		default:
			break;
		}
		return null;
	}

}
