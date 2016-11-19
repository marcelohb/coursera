package br.com.coursera.persistencia;

import java.util.List;

import br.com.coursera.dominio.Comentario;

public interface IComendarioDao {
	
	public int inserir(Comentario comentario);
	
	public int inserir(String comentario, String login, int idTopico);
	
	public void registrarPontos(String usuario);
	
	public List<Comentario> listarComentarios();
	
	public List<Comentario> listarComentariosDoTopico(int idTopico);
	
	public List<Comentario> listarComentariosDoUsuario(String login);
	
	public int removerComentario(int idComentario);

}
