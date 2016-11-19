package br.com.coursera.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.Conexao;
import br.com.coursera.persistencia.UsuarioDao;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Cadastro() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if (nome.isEmpty() || email.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
			request.setAttribute("mensagem", "Todos os campos devem ser preenchidos");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			return;
		}
		
		UsuarioDao dao = new UsuarioDao(new Conexao());
		try {
			dao.inserir(new Usuario(usuario, senha, email, nome, 0));
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
