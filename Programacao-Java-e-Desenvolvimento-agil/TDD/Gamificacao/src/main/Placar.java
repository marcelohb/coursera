package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Placar {
	
	IArmazenamento armazenamento;
	
	public Placar(IArmazenamento a) {
		armazenamento = a;
	}

	public void registrarPonto(String usuario, int quantidade, Pontos tipo) {
		armazenamento.armazenar(usuario, quantidade, tipo);
	}

	public HashMap<Pontos, Integer> retornarPontosDeUmUsuario(String usuario) {
		return armazenamento.recuperarTiposDePontosDeUmUsuario(usuario);
	}

	public List<Integer> retornarRanking(Pontos tipo) {
		List<Integer> pontos = new ArrayList<>();
		for (Usuario u : armazenamento.recuperarUsuarios()) {
			int quantidade = armazenamento.recuperarPontosUsuarioPorTipo(u, tipo);
			if (quantidade > 0)
				pontos.add(quantidade);
		}
		Collections.sort(pontos);
		return pontos;
	}

}
