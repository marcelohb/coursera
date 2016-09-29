package br.com.coursera;

public class CaixaEletronico {
	
	private String _usuario = "marcelo";
	private String _senha = "123";

	public String logar(String conta, String usuario, String senha) {
//		ServicoRemoto servico = new ServicoRemoto;
//		servico.recuperarConta(conta);
		if (usuario.equals(this._usuario) && senha.equals(this._senha))
			return "Usuario Autenticado";
		return "Nao foi possivel autenticar o usuario";
	}

}
