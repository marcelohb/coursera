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

@WebServlet("/insereTopico")
public class InsereTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsereTopico() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String conteudo = request.getParameter("conteudo");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Topico topico = new Topico(titulo, usuario.getLogin());
		topico.setConteudo(conteudo);
		TopicoDao dao = new TopicoDao(new Conexao());
		try {
			dao.inserir(topico);
			dao.registrarPontos(usuario.getLogin());
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("insere_topico.jsp").forward(request, response);
			return;
		}
		List<Topico> topicos = dao.listarTopicos();
		request.setAttribute("topicos", topicos);
		request.getRequestDispatcher("topicos.jsp").forward(request, response);
	}

}
