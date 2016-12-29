package br.com.coursera.aplicacao;

import java.util.ArrayList;
import java.util.List;

import br.com.coursera.dominio.Usuario;

public class Aplicacao {
	
	public static List<Usuario> usuarios = new ArrayList<>();

	public static List<Usuario> listaDeUsuarios() {
		return usuarios;
	}
	
	public static void adicionarUsuario(Usuario u) {
		usuarios.add(u);
	}

}
