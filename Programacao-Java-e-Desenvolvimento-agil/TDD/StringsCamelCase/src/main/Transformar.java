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
		verificaSeIniciaComNumero();
		verificaCaracteresEspeciais();
		String p = new String();
		for (char c : arrayDePalavras) {
			if (Character.isLowerCase(c)) {
				p += String.valueOf(c);
			} else {
				if (!p.isEmpty())
				listaDePalavras.add(p.toLowerCase());
				p = String.valueOf(c);
			}
		}
		listaDePalavras.add(p.toLowerCase());
	}
	
	public List<String> getListaDePalavras() {
		return listaDePalavras;
	}
	
	private void verificaSeIniciaComNumero() {
		if (String.valueOf(arrayDePalavras[0]).matches("[0-9]"))
			throw new IllegalArgumentException("Não pode iniciar com número");
	}
	
	private void verificaCaracteresEspeciais() {
		for (char c : arrayDePalavras) {
			if (String.valueOf(c).matches("[^a-zA-Z0-9]"))
				throw new IllegalArgumentException("Não pode conter caracteres especiais");
		}
	}

}
