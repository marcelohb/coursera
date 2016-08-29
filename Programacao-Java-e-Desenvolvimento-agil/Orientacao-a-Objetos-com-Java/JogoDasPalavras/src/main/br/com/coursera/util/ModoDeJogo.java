package main.br.com.coursera.util;

public enum ModoDeJogo {
	
	FACIL(0),MEDIO(1),DIFICIL(2);
	
	private int nivel;
	
	ModoDeJogo(int nivel) {
		this.nivel = nivel;
	}
	
	public int nivel() {
		return nivel;
	}

}
