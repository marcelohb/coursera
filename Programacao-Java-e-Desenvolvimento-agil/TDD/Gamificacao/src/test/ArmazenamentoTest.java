package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import main.Armazenamento;
import main.Pontos;

public class ArmazenamentoTest {
	
//	Placar placar;
	Armazenamento armazenamento;
	
	@Before
	public void setUp() {
		armazenamento = new Armazenamento("src/gamificacao.txt");
//		placar = new Placar();
	}

	@Test
	public void criarArquivoSeNaoExistir() {
		assertTrue(armazenamento.lerArquivo());
	}
	
	@Test
	public void armazenarPontosDeUmUsuario() throws FileNotFoundException {
		armazenamento.armazenar("GUERRA",10,Pontos.MOEDA);
	}

}
