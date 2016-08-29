package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.util.ModoDeJogo;

public class MecanicaDoJogoFabrica {

	public MecanicaDoJogo novoJogo(ModoDeJogo modo) {
		switch (modo) {
		case FACIL:
			return new MecanicaDoJogoFacil();
		case MEDIO:
			return new MecanicaDoJogoMedio();
		case DIFICIL:
			return new MecanicaDoJogoDificil();
		}
		return null;
	}
	
	public MecanicaDoJogo novoJogo() {
		return new MecanicaDoJogoFacil();
	}

}
