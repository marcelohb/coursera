package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Arquivo;

public class ArquivoTest {

	@Test
	public void encontrarArquivo() {
		Arquivo arquivo = new Arquivo("PALAVRA.TXT");
	}

}
