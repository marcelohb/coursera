package main.semana05;

public interface FormatadorNome {

	public String informal(String nome, String sobrenome);
	
	public String respeitoso(String sobrenome, Sexo sexo);
	
	public String comTitulo(String nome, String sobrenome, String titulo);
}
