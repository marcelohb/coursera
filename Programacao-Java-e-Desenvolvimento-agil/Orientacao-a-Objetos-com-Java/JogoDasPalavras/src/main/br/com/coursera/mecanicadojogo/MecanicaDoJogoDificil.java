package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.util.ModoDeJogo;

public class MecanicaDoJogoDificil implements MecanicaDoJogo {

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
	public Double pontuacaoFinal() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public ModoDeJogo modo() {
		return ModoDeJogo.DIFICIL;
	}

	@Override
	public String novaPalavra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reiniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respostaErrada() {
		// TODO Auto-generated method stub
		
	}

}
