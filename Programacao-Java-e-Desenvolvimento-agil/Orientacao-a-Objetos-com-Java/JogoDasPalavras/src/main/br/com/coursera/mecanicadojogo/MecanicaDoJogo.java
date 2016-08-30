package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.util.ModoDeJogo;

public interface MecanicaDoJogo {
	
	public boolean fimDeJogo();
	public boolean podeTentarNovamente();
	public Double pontuacaoFinal();
	public ModoDeJogo modo();
	public String novaPalavra();
	public boolean acertouPalavra(String palavra);
	public void reiniciar();
	public void respostaErrada();
	
}