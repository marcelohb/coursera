package br.com.coursera;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.coursera.CaixaEletronico;

public class CaixaEletronicoTest {
	
	CaixaEletronico caixa = new CaixaEletronico(); 

	@Test
	public void logarComUsuarioCorreto() {
		assertEquals("Usuario Autenticado",caixa.logar("55","marcelo","123"));
	}
	
	@Test
	public void logarComUsuarioInorreto() {
		assertEquals("Nao foi possivel autenticar o usuario",caixa.logar("55","marcelo","12"));
	}
	
	

}
