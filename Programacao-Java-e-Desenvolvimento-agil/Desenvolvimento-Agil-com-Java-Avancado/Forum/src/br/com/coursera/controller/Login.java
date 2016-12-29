package br.com.coursera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Topico;
import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.Conexao;
import br.com.coursera.persistencia.TopicoDao;
import br.com.coursera.persistencia.UsuarioDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioLogado;
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		if (usuario.isEmpty() || senha.isEmpty()) { 
			request.setAttribute("mensagem", "Usuario/Senha em branco");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		Conexao c = new Conexao();
		UsuarioDao dao = new UsuarioDao(c);
		usuarioLogado = dao.autenticar(usuario,senha);
		if (usuarioLogado==null) {
			request.setAttribute("mensagem", "Usuario/Senha inválido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		TopicoDao daoTopico = new TopicoDao(c);
		List<Topico> topicos = daoTopico.listarTopicos();
		request.setAttribute("topicos", topicos);
		request.getSession().setAttribute("usuario", usuarioLogado);
		request.getRequestDispatcher("topicos.jsp").forward(request, response);
	}

}
