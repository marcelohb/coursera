package br.com.coursera;

public class MockServicoRemoto implements ServicoRemoto {

	@Override
	public ContaCorrente recuperarConta(Integer numeroDaConta){
		ContaCorrente conta = CaixaEletronico.contas.get(numeroDaConta);
		if (conta == null)
			throw new IllegalArgumentException("Conta nao encontrada");
		return conta;
	}

	@Override
	public void persistirConta(ContaCorrente conta) {
		CaixaEletronico.contas.put(conta.getNumero(), conta);
	}

}
