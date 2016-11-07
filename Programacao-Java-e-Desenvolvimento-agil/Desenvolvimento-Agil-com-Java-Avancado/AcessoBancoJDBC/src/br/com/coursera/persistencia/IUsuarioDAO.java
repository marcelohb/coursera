package br.com.coursera.persistencia;

import java.util.List;

import br.com.coursera.dominio.Usuario;

public interface IUsuarioDAO {
	
	public void inserir(Usuario usuario);
	
	public Usuario recuperar(String login);
	
	public void adicionarPontos(String login, int pontos);
	
	public List<Usuario> ranking();

}
