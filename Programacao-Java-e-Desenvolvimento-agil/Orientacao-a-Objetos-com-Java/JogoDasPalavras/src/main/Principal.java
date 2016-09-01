package main;

import java.util.Scanner;

import main.br.com.coursera.mecanicadojogo.MecanicaDoJogo;
import main.br.com.coursera.mecanicadojogo.MecanicaDoJogoFabrica;
import main.br.com.coursera.util.Apresentacao;
import main.br.com.coursera.util.ModoDeJogo;

public class Principal {

	public static void main(String[] args) {
		
		String inicioDeJogo;
		String palavra;
		int modoDeJogo = 0;
		MecanicaDoJogoFabrica jogo = null;
		MecanicaDoJogo m = null;
		
		Apresentacao a = new Apresentacao();
		a.telaInicial();
		a.escolherJogo();
		Scanner sc = new Scanner(System.in);
		inicioDeJogo = sc.nextLine();
		jogo = new MecanicaDoJogoFabrica();
		if ("1".equals(inicioDeJogo)) {
			m = jogo.novoJogo();
		} else {
			a.escolherModoDeJogo();
			try {
				modoDeJogo = Integer.valueOf(sc.nextLine()).intValue();
				switch (modoDeJogo) {
				case 1:
					m = jogo.novoJogo(ModoDeJogo.FACIL);
					break;
				case 2:
					m = jogo.novoJogo(ModoDeJogo.MEDIO);
					break;
				case 3:
					m = jogo.novoJogo(ModoDeJogo.DIFICIL);
					break;
				default:
					System.out.println("OPÇÃO INVÁLIDA: " + modoDeJogo);
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("ERRO: OPÇÃO INVÁLIDA");
				e.printStackTrace();
				System.exit(0);
			}
			
		}
		a.vamosLa();
		while (!m.fimDeJogo()) {
			a.escreverPalavra(m.novaPalavra());
			palavra = sc.nextLine();
			m.acertouPalavra(palavra);
		}
		if (!m.podeTentarNovamente()) {
			a.perdeu();
		}
		sc.close();
		a.pontuacao(m.pontuacaoFinal());
		a.fimDeJogo();
	}

}
