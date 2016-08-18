package main.semana05;

public class Autoridade implements FormatadorNome {
	
	private String nome;
	private String sobrenome;
	private FormatadorNome formatarNome;

	public Autoridade(String nome, String sobrenome) {
		this.nome = nome.toUpperCase();
		this.sobrenome = sobrenome.toUpperCase();
	}
	
	public String getTratamento(TipoDeTratamento tipo, Sexo sexo, String titulo) {
		if (tipo.equals(TipoDeTratamento.INFORMAL)) 
			return formatarNome.informal(nome, sobrenome);
		
		if (tipo.equals(TipoDeTratamento.RESPEITOSO))
			return formatarNome.respeitoso(sobrenome, sexo);
		
		if (tipo.equals(TipoDeTratamento.COMTITULO))
			return formatarNome.comTitulo(nome, sobrenome, titulo);
		return "TIPO INEXISTENTE";
	}

	@Override
	public String informal(String nome, String sobrenome) {
		return nome;
	}

	@Override
	public String respeitoso(String sobrenome, Sexo sexo) {
		String tratamento;
		if (sexo.equals("M"))
		return null;
	}

	@Override
	public String comTitulo(String nome, String sobrenome, String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

}