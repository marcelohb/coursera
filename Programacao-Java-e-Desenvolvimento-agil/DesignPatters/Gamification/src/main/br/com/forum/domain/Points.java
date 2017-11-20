package main.br.com.forum.domain;

public class Points extends Achievement{
	
	private int qtd;

	public Points(String name, int qtd) {
		super(name);
		setQtd(qtd);
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}
