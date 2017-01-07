package br.com.coursera.dominio;

public class Livro {
	
	private int	id;
	private String titulo;
	private String autor;
	private Estilo estilo;
	private int paginas;
	private Double pontosDeLeitura;
	private boolean lido;

	public Livro(int id, String titulo, String autor, Estilo estilo, int paginas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.paginas = paginas;
		this.pontosDeLeitura = 0.0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public Double getPontosDeLeitura() {
		return pontosDeLeitura;
	}
	
	public void setPontosDeLeitura(Double pontosDeLeitura) {
		this.pontosDeLeitura = pontosDeLeitura;
	}
	
	public boolean lido() {
		return lido;
	}
	
	public void foiLido(boolean lido) {
		this.lido = lido;
	}
	
	public String checked() {
		return (lido ? "checked=checked" : "");
	}
	
	@Override
	public String toString() {
		return "Livro [id:" + getId() + 
				",titulo:" + getTitulo() + 
				",autor:" + getAutor() + 
				",estilo:" + getEstilo() + 
				",paginas:" + getPaginas() +
				",pontos:" + getPontosDeLeitura() + 
				",lido:" + lido() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + id;
		result = prime * result + paginas;
		result = prime * result + ((pontosDeLeitura == null) ? 0 : pontosDeLeitura.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (estilo != other.estilo)
			return false;
		if (id != other.id)
			return false;
		if (paginas != other.paginas)
			return false;
		if (pontosDeLeitura == null) {
			if (other.pontosDeLeitura != null)
				return false;
		} else if (!pontosDeLeitura.equals(other.pontosDeLeitura))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
