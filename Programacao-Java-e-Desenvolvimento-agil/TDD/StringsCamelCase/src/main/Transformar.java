package main;

import java.util.ArrayList;
import java.util.List;

public class Transformar {

	char[] arrayDePalavras;
	List<String> listaDePalavras;
	
	public Transformar() {
		listaDePalavras = new ArrayList<>();
	}
	public void separarPalavras(String palavra) {
		arrayDePalavras = palavra.toCharArray();
		this.verificaSeIniciaComNumero();
		String p = null;
		for (char c : arrayDePalavras) {
			
			if (String.valueOf(c).matches("[A-Z]")) {
				if (p != null)
					listaDePalavras.add(p.toLowerCase());
				p = null;
			} 
			if (p == null) {
				p = String.valueOf(c);
			} else {
				p += String.valueOf(c);
			}
		}
		listaDePalavras.add(p.toLowerCase());
	}
	
	public List<String> getListaDePalavras() {
		return listaDePalavras;
	}
	
	private boolean verificaSeIniciaComNumero() {
		if (String.valueOf(arrayDePalavras[0]).matches("[0-9]"))
			throw new IllegalArgumentException("Não pode iniciar com número");
		return false;
	}

}
