package br.com.coursera;

import java.util.List;

import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.UsuarioDAO;

public class Aplicacao {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		
//		Usuario eu = new Usuario("eu", "eu", "eu", "eu", 10);
//		dao.inserir(eu);
		
		Usuario usuarioRecuperadoPorLogin = dao.recuperar("eu");
		System.out.println(usuarioRecuperadoPorLogin.toString());
		
		dao.adicionarPontos("eu", 1);
		System.out.println(usuarioRecuperadoPorLogin.toString());
//		List<Usuario> usuarios = dao.ranking();
//		
//		usuarios.forEach(System.out::println);
//		dao.inserir();
//		for (Usuario u : dao.ranking()) {
//			System.out.println(u.toString());
//		}
	}

}
