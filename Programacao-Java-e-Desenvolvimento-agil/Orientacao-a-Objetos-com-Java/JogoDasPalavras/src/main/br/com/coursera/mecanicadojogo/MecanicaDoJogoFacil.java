package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.embaralhador.Embaralhador;
import main.br.com.coursera.embaralhador.EmbaralhadorFabrica;
import main.br.com.coursera.util.ModoDeJogo;

public class MecanicaDoJogoFacil implements MecanicaDoJogo {

	@Override
	public boolean fimDeJogo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acertouPalavra() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean podeTentarNovamente() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int pontuacaoFinal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ModoDeJogo modo() {
		return ModoDeJogo.FACIL;
	}

	@Override
	public String novaPalavra(ModoDeJogo modo) {
		Embaralhador fabrica = new EmbaralhadorFabrica().embaralhar(modo);
		return fabrica.novaPalavra();
	}

}
