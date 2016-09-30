package br.com.coursera;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTest {
	
	CaixaEletronico caixa = new CaixaEletronico();
//	TODO Hardware hardware;
	
	@Before
	public void setUp() {
		CaixaEletronico.contas.put(55, new ContaCorrente(55,"marcelo", "123"));
		CaixaEletronico.contas.put(78, new ContaCorrente(78,"joao", "123"));
	}

	@Test
	public void logarComUsuarioCorreto() {
		assertEquals("Usuario Autenticado",caixa.logar(55,"marcelo","123"));
	}

	@Test
	public void logarComUsuarioIncorreto() {
		assertEquals("Nao foi possivel autenticar o usuario",caixa.logar(55,"marcelo","1234"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void logarComContaInexistente() {
		assertEquals("Conta nao encontrada",caixa.logar(5,"marcelo","12"));
	}
	
	@Test
	public void saldoZerado() {
		assertEquals("O saldo é R$ 0,00", caixa.saldo(55));
	}
	
	@Test
	public void sacarComSaldoZerado() {
		assertEquals("Saldo insuficiente", caixa.sacar(55, Double.valueOf(100)));
		assertEquals("O saldo é R$ 0,00", caixa.saldo(55));
	}
	
	@Test
	public void sacarComSaldo() {
		caixa.depositar(55, Double.valueOf(100));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(100)));
		assertEquals("O saldo é R$ 0,00", caixa.saldo(55));
	}
	
	@Test
	public void variosSaques() {
		caixa.depositar(55, Double.valueOf(100));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(1)));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(10)));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(10)));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(11)));
		assertEquals("O saldo é R$ 68,00", caixa.saldo(55));
	}
	
	@Test
	public void saqueDeUmaContaNaoPodeSacarDeOutra() {
		caixa.depositar(55, Double.valueOf(100));
		caixa.depositar(78, Double.valueOf(100));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(10)));
		assertEquals("O saldo é R$ 90,00", caixa.saldo(55));
		assertEquals("O saldo é R$ 100,00", caixa.saldo(78));
	}
	
	@Test
	public void depositar() {
		assertEquals("Depósito recebido com sucesso", caixa.depositar(55, Double.valueOf(100)));
		assertEquals("O saldo é R$ 100,00", caixa.saldo(55));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void depositarEmContaInexistente() {
		assertEquals("Depósito recebido com sucesso", caixa.depositar(9999, Double.valueOf(100)));
		assertEquals("O saldo é R$ 100,00", caixa.saldo(55));
	}
	
	@Test
	public void depositoEmUmaContaNaoPodeDepositarEmOutra() {
		assertEquals("Depósito recebido com sucesso",caixa.depositar(55, Double.valueOf(100)));
		assertEquals("Depósito recebido com sucesso",caixa.depositar(78, Double.valueOf(100)));
		assertEquals("Retire seu dinheiro", caixa.sacar(55, Double.valueOf(10)));
		assertEquals("O saldo é R$ 90,00", caixa.saldo(55));
		assertEquals("O saldo é R$ 100,00", caixa.saldo(78));
	}
	

}
