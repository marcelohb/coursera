package br.com.coursera;

public class MockHardware implements Hardware {

	@Override
	public Integer pegarNumeroDaContaCartao(String numeroDoCartao) throws Exception {
		ServicoRemoto servico = new MockServicoRemoto();
		if (!numeroDoCartao.equals("55"))
			throw new IllegalArgumentException("Conta não encontrada");
		return servico.recuperarConta(Integer.valueOf(numeroDoCartao)).getNumero();
	}

	@Override
	public void entregarDinheiro() throws Exception {
	}

	@Override
	public void lerEnvelope() throws Exception {
	}

}
