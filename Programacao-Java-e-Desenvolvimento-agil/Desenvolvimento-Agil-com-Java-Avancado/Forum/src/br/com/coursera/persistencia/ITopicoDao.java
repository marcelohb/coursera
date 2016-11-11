package br.com.coursera.persistencia;

import br.com.coursera.dominio.Topico;

public interface ITopicoDao {

	int inserir(Topico topico);
	
	int inserir(String titulo, String usuario);
}
