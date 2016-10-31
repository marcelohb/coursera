package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/traduzir")
public class Traduzir extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Traduzir() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavraTraduzida = null;
		String palavraOriginal = request.getParameter("palavra");
		ServletContext context = getServletContext();
		Arquivo arquivo = new Arquivo("/Tradutor/PALAVRAS.TXT");
		InputStream is = context.getResourceAsStream("/PALAVRAS.TXT");
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String texto = "";
			
			while ((texto = reader.readLine()) != null) {
				arquivo.adicionar(texto);
			}
		}
		palavraTraduzida = arquivo.traduzir(palavraOriginal);
		response.getWriter().println("Palavra traduzida: " + palavraTraduzida);
	}

}
