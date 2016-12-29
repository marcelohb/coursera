package br.com.coursera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.dominio.Topico;
import br.com.coursera.persistencia.Conexao;
import br.com.coursera.persistencia.TopicoDao;

@WebServlet("/listarTopicos")
public class ListarTopicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarTopicos() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	TopicoDao daoTopico = new TopicoDao(new Conexao());
		List<Topico> topicos = daoTopico.listarTopicos();
		req.setAttribute("topicos", topicos);
		req.getRequestDispatcher("topicos.jsp").forward(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
