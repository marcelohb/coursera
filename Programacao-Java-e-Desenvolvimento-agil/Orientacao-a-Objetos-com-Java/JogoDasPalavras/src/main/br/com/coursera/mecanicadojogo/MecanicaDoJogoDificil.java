package main.br.com.coursera.mecanicadojogo;

import main.br.com.coursera.embaralhador.Embaralhador;
import main.br.com.coursera.embaralhador.EmbaralhadorFabrica;
import main.br.com.coursera.util.BancoDePalavras;
import main.br.com.coursera.util.ModoDeJogo;

public class MecanicaDoJogoDificil implements MecanicaDoJogo {
	
	private BancoDePalavras bp;
	private int tentativas;
	private Double pontuacao;
	
	public MecanicaDoJogoDificil() {
		bp = new BancoDePalavras();
		tentativas = 3;
		pontuacao = 0.0;
		this.reiniciar();
	}

	@Override
	public boolean fimDeJogo() {
		if (tentativas <= 0)
			return true;
		if (BancoDePalavras.ultimaPalavra == BancoDePalavras.palavraAtual)
			return true;
		return false;
	}

	@Override
	public boolean acertouPalavra(String palavra) {
		if (palavra.toUpperCase().equals(bp.proximaPalavra())) {
			BancoDePalavras.palavraAtual++;
			pontuacao += 1.0;
			return true;
		} else {
			this.respostaErrada();
			return false;
		}
	}

	@Override
	public boolean podeTentarNovamente() {
		if (tentativas > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Double pontuacaoFinal() {
		if (pontuacao < 0.0) {
			return 0.0;
		}
		return pontuacao;
	}

	@Override
	public ModoDeJogo modo() {
		return ModoDeJogo.DIFICIL;
	}

	@Override
	public String novaPalavra() {
		Embaralhador fabrica = new EmbaralhadorFabrica().novoEmbaralhador(this.modo());
		return fabrica.embaralhar(bp.proximaPalavra());
	}

	@Override
	public void reiniciar() {
		BancoDePalavras.palavraAtual = 0;
		tentativas = 3;
		pontuacao = 0.0;
	}

	@Override
	public void respostaErrada() {
		tentativas --;
		pontuacao -= 1.0;
	}
}
