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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLivro;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroUsuario other = (LivroUsuario) obj;
		if (idLivro != other.idLivro)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
}
