package br.com.coursera.dominio;

public class LivroUsuario {

	private int idUsuario;
	private int idLivro;
	
	public LivroUsuario(int idUsuario, int idLivro) {
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public int getIdLivro() {
		return idLivro;
	}
}
