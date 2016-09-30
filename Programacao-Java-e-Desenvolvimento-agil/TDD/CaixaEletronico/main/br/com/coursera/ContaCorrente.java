package br.com.coursera;

public class ContaCorrente {
	
	private String _usuario = "marcelo";
	private String _senha = "123";
	private Double _saldo = 0.0;
	
	public ContaCorrente(String usuario, String senha) {
		_usuario = usuario;
		_senha = senha;
	}

	public String getUsuario() {
		return _usuario;
	}

	public String getSenha() {
		return _senha;
	}

	public Double getSaldo() {
		return _saldo;
	}

}
