package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.util.ModoDeJogo;

public interface MecanicaDoJogo {
	
	public boolean fimDeJogo();
	public boolean podeTentarNovamente();
	public int pontuacaoFinal();
	public ModoDeJogo modo();
	public String novaPalavra(ModoDeJogo modo);
	public boolean acertouPalavra();
	
}