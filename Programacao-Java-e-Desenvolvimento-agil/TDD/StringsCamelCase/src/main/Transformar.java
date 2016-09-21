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
		for (String s : palavra.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z]|(?=[0-9]))")){
			if (ehSiglaOuAcronimo(s)) {
				listaDePalavras.add(s);
			} else {
				listaDePalavras.add(s.toLowerCase());
			}
		}
	}
	
	public List<String> getListaDePalavras() {
		return listaDePalavras;
	}
	
	private void verificaSeIniciaComNumero() {
		if (String.valueOf(arrayDePalavras[0]).matches("[0-9]"))
			throw new IllegalArgumentException("Nao pode iniciar com numero");
	}
	
	private void verificaCaracteresEspeciais() {
		for (char c : arrayDePalavras) {
			if (String.valueOf(c).matches("[^a-zA-Z0-9]"))
				throw new IllegalArgumentException("Nao pode conter caracteres especiais");
		}
	}
	
	private boolean ehSiglaOuAcronimo(String sigla) {
		char[] letras = sigla.toCharArray();
		for (Character c : letras) {
			if (Character.isLowerCase(c))
				return false;
		}
		return true;
	}
	

}
