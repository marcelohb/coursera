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
		listaDePalavras.add(p);
	}
	
	public List<String> getListaDePalavras() {
		return listaDePalavras;
	}

}
