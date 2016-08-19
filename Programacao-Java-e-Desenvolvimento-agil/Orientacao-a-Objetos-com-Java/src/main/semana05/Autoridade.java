package main.semana05;

public class Autoridade implements FormatadorNome {
	
	private String nome;
	private String sobrenome;

	public Autoridade(String nome, String sobrenome) {
		this.nome = nome.toUpperCase();
		this.sobrenome = sobrenome.toUpperCase();
	}
	
	public String getTratamento(TipoDeTratamento tipo, Sexo sexo, String titulo) {
		if (tipo.equals(TipoDeTratamento.INFORMAL)) 
			return informal(nome);
		
		if (tipo.equals(TipoDeTratamento.RESPEITOSO))
			return respeitoso(sobrenome, sexo);
		
		if (tipo.equals(TipoDeTratamento.COMTITULO))
			return comTitulo(nome, sobrenome, titulo);
		return "TIPO INEXISTENTE";
	}

	@Override
	public String informal(String nome) {
		return nome;
	}

	@Override
	public String respeitoso(String sobrenome, Sexo sexo) {
		return sexo.tratamento() + " " + sobrenome;
	}

	@Override
	public String comTitulo(String nome, String sobrenome, String titulo) {
		return titulo + " " + nome + " " + sobrenome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		Autoridade other = (Autoridade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

}