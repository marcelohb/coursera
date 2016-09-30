package br.com.coursera;

public class ContaCorrente {
	
	private Integer numero;
	private String usuario;
	private String senha;
	private Double saldo = 0.0;
	
	public ContaCorrente(int numero, String usuario, String senha) {
		this.numero = numero;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void sacar(Double valor) {
		this.saldo -= valor;
	}
	
	public void depositar(Double valor) {
		this.saldo += valor;
	}

}
