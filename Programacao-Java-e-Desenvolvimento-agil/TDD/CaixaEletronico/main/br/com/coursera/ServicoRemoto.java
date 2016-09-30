package br.com.coursera;

public interface ServicoRemoto {

	public ContaCorrente recuperarConta(Integer numeroDaConta);
	
	public void persistirConta(ContaCorrente conta);

}
