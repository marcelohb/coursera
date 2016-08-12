package main.semana01;

public class Paciente {
	
	private Double peso;
	private Double altura;
	
	private static final String abaixo16 = "Baixo peso muito grave";
	private final String entre1600_1699 = "Baixo peso grave";
	private final String entre1700_1849 = "Baixo peso";
	private final String entre1850_2499 = "Peso normal";
	private final String entre2500_2999 = "Sobrepeso";
	private final String entre3000_3499 = "Obesidade grau I";
	private final String entre3500_3999 = "Obesidade grau II";
	private final String maior40 = "Obesidade grau III (obesidade mórbida)";
	
	public Paciente(Double peso, Double altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public Double calcularIMC() {
		return this.peso / Math.pow(this.altura, 2);
	}
	
	public String diagnostico() {
		Double imc = calcularIMC();
		if (imc.compareTo(new Double(16)) < 0) {
			return abaixo16;
		}
		if (imc >= new Double(16) && imc <= new Double(16.99)) {
			return entre1600_1699;
		}
		if (imc >= new Double(17) && imc <= new Double(18.49)) {
			return entre1700_1849;
		}
		if (imc >= new Double(18.50) && imc <= new Double(24.99)) {
			return entre1850_2499;
		}
		if (imc >= new Double(25) && imc <= new Double(29.99)) {
			return entre2500_2999;
		}
		if (imc >= new Double(30) && imc <= new Double(34.99)) {
			return entre3000_3499;
		}
		if (imc >= new Double(35) && imc <= new Double(39.99)) {
			return entre3500_3999;
		}
		if (imc.compareTo(new Double(40)) > 0) {
			return maior40;
		}

		return String.valueOf(imc);
	}
	
	public void imprimir() {
		System.out.println(diagnostico());
	}

}
