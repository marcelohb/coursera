package br.com.coursera;

public class MockServicoRemoto implements ServicoRemoto {

	@Override
	public ContaCorrente recuperarConta(String numeroDaConta) {
		ContaCorrente conta = CaixaEletronico.contas.get("123");
		if (conta == null)
			throw new IllegalArgumentException("Conta nao encontrada");
		return conta;
	}

}
