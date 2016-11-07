package br.com.coursera;

import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.UsuarioDAO;

public class Aplicacao {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		for (Usuario u : dao.ranking()) {
			System.out.println(u.toString());
		}
	}

}
