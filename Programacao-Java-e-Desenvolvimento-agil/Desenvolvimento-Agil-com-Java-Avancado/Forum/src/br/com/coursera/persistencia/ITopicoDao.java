package br.com.coursera.persistencia;

import java.util.List;

import br.com.coursera.dominio.Topico;

public interface ITopicoDao {

	public int inserir(Topico topico);
	
	public int inserir(String titulo, String usuario);
	
	public void registrarPontos(String login);
	
	public List<Topico> listarTopicos();
	
	public List<Topico> listarTopicosDoUsuario(String login);
	
	public int removerTopico(int idTopico);
}
