package br.com.coursera;

import java.util.HashMap;
import java.util.Map;

public class CaixaEletronico {
	
	public static Map<String, ContaCorrente> contas = new HashMap<>();

	public String logar(String numeroDaConta, String usuario, String senha) {
		ServicoRemoto servico = new MockServicoRemoto();
		ContaCorrente conta = servico.recuperarConta(numeroDaConta);
		if (usuario.equals(conta.getUsuario()) && senha.equals(conta.getSenha()))
			return "Usuario Autenticado";
		return "Nao foi possivel autenticar o usuario";
	}

}
