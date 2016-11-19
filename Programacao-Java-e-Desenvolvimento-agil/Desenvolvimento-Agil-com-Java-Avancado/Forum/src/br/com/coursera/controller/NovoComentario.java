package br.com.coursera.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Comentario;
import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.ComentarioDao;
import br.com.coursera.persistencia.Conexao;

@WebServlet("/novoComentario")
public class NovoComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovoComentario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTopico = Integer.valueOf(request.getParameter("idTopico"));
		String comentario = request.getParameter("novoComentario");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		ComentarioDao dao = new ComentarioDao(new Conexao());
		try {
			dao.inserir(new Comentario(idTopico, comentario, usuario.getLogin()));
			dao.registrarPontos(usuario.getLogin());
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("exibeTopico?id="+idTopico).forward(request, response);
			return;
		}
		request.getRequestDispatcher("exibeTopico?id="+idTopico).forward(request, response);
		
	}

}
