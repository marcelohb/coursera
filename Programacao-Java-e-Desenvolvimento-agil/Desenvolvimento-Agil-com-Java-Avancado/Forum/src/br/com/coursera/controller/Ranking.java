package br.com.coursera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.Conexao;
import br.com.coursera.persistencia.UsuarioDao;

@WebServlet("/ranking")
public class Ranking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ranking() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao(new Conexao());
		List<Usuario> usuarios = dao.ranking();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("ranking.jsp").forward(request, response);
	}

}
