package main.semana05;

public enum Sexo {
	
	MASCULINO("M", "Sr"), FEMININO("F", "Sra");
	
	private String sexo;
	private String tratamento; 
	
	Sexo(String sexo, String tratamento) {
		this.sexo = sexo;
		this.tratamento = tratamento;
	}
	
	public String sexo() {
		return sexo;
	}
	
	public String tratamento() {
		return null;
	}
}
