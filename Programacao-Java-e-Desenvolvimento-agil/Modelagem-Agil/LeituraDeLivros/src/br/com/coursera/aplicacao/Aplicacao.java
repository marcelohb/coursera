package br.com.coursera.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.coursera.dominio.Estilo;
import br.com.coursera.dominio.Livro;
import br.com.coursera.dominio.LivroUsuario;
import br.com.coursera.dominio.Usuario;

public class Aplicacao {
	
	public static List<Usuario> usuarios = new ArrayList<>();
	public static List<Livro> livros = new ArrayList<>();
	public static List<LivroUsuario> livrosDoUsuario = new ArrayList<>();

	public static List<Usuario> listaDeUsuarios() {
		return usuarios;
	}
	
	public static List<Livro> listaDeLivros() {
		return livros;
	}
	
	public static void adicionarUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public static void adicionarLivro(Livro l) {
		livros.add(l);
	}
	
	public static void limparUsuarios() {
		usuarios.clear();
	}
	
	public static void limparLivros() {
		livros.clear();
	}
	
	public static void carregarUsuarios() {
		usuarios.add(new Usuario(1,"eu", "123", "Euzequiel"));
		usuarios.add(new Usuario(2,"bruno", "123", "Bruno"));
		usuarios.add(new Usuario(3,"leo", "123", "Leonardo"));
		usuarios.add(new Usuario(4,"edu", "123", "Eduardo"));
		usuarios.add(new Usuario(5,"ma", "123", "Maraisa"));
		usuarios.add(new Usuario(6,"fer", "123", "Fernanda"));
		usuarios.add(new Usuario(7,"dani", "123", "Daniela"));
		usuarios.add(new Usuario(8,"pati", "123", "Patricia"));
		usuarios.add(new Usuario(9,"tata", "123", "Tamires"));
		usuarios.add(new Usuario(10,"gabi", "123", "Gabriela"));
	}
	
	public static void carregarLivros() {
		livros.add(new Livro(1,"Titulo 1", "Autor 1", Estilo.DRAMA, 123));
		livros.add(new Livro(2,"Titulo 2", "Autor 1", Estilo.FICCAO_CIENTIFICA, 23));
		livros.add(new Livro(3,"Titulo 3", "Autor 2", Estilo.RELIGIOSO, 222));
		livros.add(new Livro(4,"Titulo 4", "Autor 1", Estilo.TERROR, 201));
		livros.add(new Livro(5,"Titulo 5", "Autor 4", Estilo.RELIGIOSO, 99));
		livros.add(new Livro(6,"Titulo 6", "Autor 2", Estilo.RELIGIOSO, 101));
		livros.add(new Livro(7,"Titulo 7", "Autor 5", Estilo.DRAMA, 151));
	}
	
	public static int quantidadeDeLivros() {
		if (livros == null)
			return 0;
		return livros.size();
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

	public static void usuarioLeuLivro(int idUsuario, int idLivro) {
		LivroUsuario livroLido = new LivroUsuario(idUsuario, idLivro);
		livrosDoUsuario.add(livroLido);
	}

	public static List<LivroUsuario> listaDeLivrosLidos(int idUsuario) {
		List<LivroUsuario> livrosLidosDoUsuario = livrosDoUsuario.stream().filter(l -> idUsuario == l.getIdUsuario()).collect(Collectors.toList());
		return livrosLidosDoUsuario;
	}

}
