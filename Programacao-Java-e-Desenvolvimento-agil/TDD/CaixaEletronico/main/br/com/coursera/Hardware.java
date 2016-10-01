package br.com.coursera;

public interface Hardware {

	public Integer pegarNumeroDaContaCartao(String numeroDoCartao) throws Exception;
	
	public void entregarDinheiro() throws Exception;
	
	public void lerEnvelope() throws Exception;
}
