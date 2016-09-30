package br.com.coursera;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class CaixaEletronico {
	
	public static Map<Integer, ContaCorrente> contas = new HashMap<>();
	ServicoRemoto servico = new MockServicoRemoto();
	
	public String logar(Integer numeroDaConta, String usuario, String senha) {
		ContaCorrente conta = servico.recuperarConta(numeroDaConta);
		
		if (usuario.equals(conta.getUsuario()) && senha.equals(conta.getSenha()))
			return "Usuario Autenticado";
		return "Nao foi possivel autenticar o usuario";
	}

	public String saldo(Integer numeroDaConta) {
		ContaCorrente conta = servico.recuperarConta(numeroDaConta);
		return "O saldo é " + NumberFormat.getCurrencyInstance().format(conta.getSaldo());
	}

	public String sacar(Integer numeroDaConta, Double valor) {
		ContaCorrente conta = servico.recuperarConta(numeroDaConta);
		if (valor > conta.getSaldo()) {
			return "Saldo insuficiente";
		}
		conta.sacar(valor);
		servico.persistirConta(conta);
		return "Retire seu dinheiro";
	}

	public String depositar(Integer numeroDaConta, Double valor) {
		ContaCorrente conta = servico.recuperarConta(numeroDaConta);
		conta.depositar(valor);
		servico.persistirConta(conta);
		return "Depósito recebido com sucesso";
	}

}
