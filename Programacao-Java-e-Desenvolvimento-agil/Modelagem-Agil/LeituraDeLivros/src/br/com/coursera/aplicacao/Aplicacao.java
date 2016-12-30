package br.com.coursera.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import br.com.coursera.dominio.Usuario;

public class Aplicacao {
	
	public static List<Usuario> usuarios = new ArrayList<>();

	public static List<Usuario> listaDeUsuarios() {
		return usuarios;
	}
	
	public static void adicionarUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public static void limparUsuarios() {
		usuarios.clear();
	}
	
	public static void carregarUsuarios() {
		usuarios.add(new Usuario("eu", "123", "Euzequiel"));
		usuarios.add(new Usuario("bruno", "123", "Bruno"));
		usuarios.add(new Usuario("leo", "123", "Leonardo"));
		usuarios.add(new Usuario("edu", "123", "Eduardo"));
		usuarios.add(new Usuario("ma", "123", "Maraisa"));
		usuarios.add(new Usuario("fer", "123", "Fernanda"));
		usuarios.add(new Usuario("dani", "123", "Daniela"));
		usuarios.add(new Usuario("pati", "123", "Patricia"));
		usuarios.add(new Usuario("tata", "123", "Tamires"));
		usuarios.add(new Usuario("gabi", "123", "Gabriela"));
	}

	public static Usuario login(String login, String senha) {
		Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getLogin().equals(login)).findFirst();
		try {
			if (!usuario.get().getSenha().equals(senha))
				return null;
		} catch (NoSuchElementException e) {
			return null;
		}
		
		return usuario.orElse(null);
	}

}
