package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.IArmazenamento;
import main.Pontos;
import main.Usuario;

public class ArmazenamentoMock implements IArmazenamento {
	
	HashMap<Pontos, Integer> pontos;
	
	public ArmazenamentoMock() {
		pontos = new HashMap<>();
	}

	@Override
	public void armazenar(String usuario, int quantidade, Pontos tipo) {
		System.out.println("USUARIO REGISTRADO");
	}

	@Override
	public int recuperarPontosUsuarioPorTipo(Usuario usuario, Pontos tipo) {
		pontos.put(tipo, 10);
		if ("guerra".equals(usuario))
			return 10;
		if ("eu".equals(usuario))
			return 1;
		if ("gugu".equals(usuario))
			return 2; 
		return 0;
	}

	@Override
	public HashMap<Pontos, Integer> recuperarTiposDePontosDeUmUsuario(String usuario) {
		pontos.put(Pontos.ESTRELA, 10);
		return pontos;
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("guerra"));
		usuarios.add(new Usuario("eu"));
		usuarios.add(new Usuario("gugu"));
		return usuarios;
	}

}
