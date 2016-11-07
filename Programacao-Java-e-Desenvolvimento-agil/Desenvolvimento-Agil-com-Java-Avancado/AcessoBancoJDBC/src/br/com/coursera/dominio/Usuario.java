package br.com.coursera.dominio;

public class Usuario {
	
	private int id;
	private String login;
	private String email;
	private String nome;
	private String senha;
	private int pontos;

	public Usuario(String login, String senha, String email, String nome, int pontos) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.pontos = pontos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "Usuario : { " + 
				"login : " + this.login +
				", senha : " + this.senha +
				", email : " + this.email +
				", nome : " + this.nome +
				", pontos : " + this.pontos + 
				" }";
	}
}
