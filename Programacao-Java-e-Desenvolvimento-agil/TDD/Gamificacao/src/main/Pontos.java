package main;

public enum Pontos {
	
	MOEDA("MOEDA"), ESTRELA("ESTRELA"), CURTIDA("CURTIDA"), COMENTARIO("COMENTARIO");
	
	private String ponto;
	
	Pontos(String ponto) {
		this.ponto = ponto;
	}

	public String ponto() {
		return ponto;
	}
	
}
