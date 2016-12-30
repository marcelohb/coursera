package br.com.coursera.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.aplicacao.Aplicacao;
import br.com.coursera.dominio.Usuario;

@WebServlet(name = "login", description = "Validar usuario da aplicacao", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioLogado;
		Aplicacao.carregarUsuarios();
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if (usuario.isEmpty() || senha.isEmpty()) { 
			request.setAttribute("mensagem", "Usuario/Senha em branco");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		usuarioLogado = Aplicacao.login(usuario, senha);

		if (usuarioLogado == null) {
			request.setAttribute("mensagem", "Usuario/Senha invalido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("usuario", usuarioLogado);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
