

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversor")
public class conversor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public conversor() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		Double temperaturaInformada = Double.valueOf(request.getParameter("t1"));
		Double temperaturaResposta;
		String tipoResposta;
		if ("fahrenheit".equals(tipo)) {
			temperaturaResposta = (temperaturaInformada - 32) / 1.8;
			tipoResposta = "celsius";
		} else {
			temperaturaResposta = (temperaturaInformada * 1.8) + 32;
			tipoResposta = "fahrenheit";
		}
		response.getWriter().write(temperaturaInformada + " graus " + tipo + " = " + temperaturaResposta + " graus " + tipoResposta);
	}

}
