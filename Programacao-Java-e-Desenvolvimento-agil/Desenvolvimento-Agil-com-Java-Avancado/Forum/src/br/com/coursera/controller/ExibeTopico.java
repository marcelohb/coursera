package br.com.coursera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Comentario;
import br.com.coursera.dominio.Topico;
import br.com.coursera.persistencia.ComentarioDao;
import br.com.coursera.persistencia.Conexao;
import br.com.coursera.persistencia.TopicoDao;

@WebServlet("/exibeTopico")
public class ExibeTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExibeTopico() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		TopicoDao dao = new TopicoDao(new Conexao());
		ComentarioDao daoComentario = new ComentarioDao(new Conexao());
		Topico topico = dao.buscarTopicoPorId(id);
		List<Comentario> comentarios = daoComentario.listarComentariosDoTopico(id);
		
		request.setAttribute("topico", topico);
		request.setAttribute("comentarios", comentarios);
		request.getRequestDispatcher("exibe_topico.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
