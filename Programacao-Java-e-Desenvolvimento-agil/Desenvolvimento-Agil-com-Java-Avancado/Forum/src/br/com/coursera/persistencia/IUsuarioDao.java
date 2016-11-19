package br.com.coursera.persistencia;

import java.util.List;

import br.com.coursera.dominio.Usuario;

public interface IUsuarioDao {
	
	public int inserir(Usuario usuario);
	
	public Usuario recuperar(String login);
	
	public Usuario autenticar(String usuario, String senha);
	
	public int adicionarPontos(String login, int pontos);
	
	public List<Usuario> ranking();

}
