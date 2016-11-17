package br.com.coursera.dominio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComentarioTest {
	
	private List<Comentario> comentarios;
	private Topico topico1;
	private Topico topico2;
	
	@Before
	public void setUp() {
		comentarios = new ArrayList<>();
		topico1 = new Topico("Um", "Eu");
		topico1.setId(1);
		topico2 = new Topico("Dois", "Eu");
		topico2.setId(2);
	}

	@Test
	public void adicionarUmComentarioAoTopico() {
		Comentario comentario1 = new Comentario(topico1.getId(), "comentario1", "eu");
		comentarios.add(comentario1);
		int qtdDeComentariosDoTopico1 = 0;
		for (Comentario c : comentarios) {
			if (c.getId_topico() == 1)
				qtdDeComentariosDoTopico1 ++;
		}
		assertEquals(1, qtdDeComentariosDoTopico1);
	}

	@Test
	public void adicionarComentariosAoTopico() {
		Comentario comentario1 = new Comentario(topico1.getId(), "comentario1", "eu");
		Comentario comentario2 = new Comentario(topico1.getId(), "comentario2", "eu");
		comentarios.add(comentario1);
		comentarios.add(comentario2);
		int qtdDeComentariosDoTopico1 = 0;
		for (Comentario c : comentarios) {
			if (c.getId_topico() == 1)
				qtdDeComentariosDoTopico1 ++;
		}
		assertEquals(2, qtdDeComentariosDoTopico1);
	}

}
