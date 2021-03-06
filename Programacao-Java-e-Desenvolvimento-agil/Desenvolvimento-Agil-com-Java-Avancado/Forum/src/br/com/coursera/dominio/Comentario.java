package br.com.coursera.dominio;

public class Comentario {
	
	private int id_comentario;
	private String comentario;
	private String login;
	private int id_topico;

	public Comentario(int topico, String comentario, String login) {
		this.id_topico = topico;
		this.comentario = comentario;
		this.login = login;
	}

	public int getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId_topico() {
		return id_topico;
	}

	public void setId_topico(int id_topico) {
		this.id_topico = id_topico;
	}

}
