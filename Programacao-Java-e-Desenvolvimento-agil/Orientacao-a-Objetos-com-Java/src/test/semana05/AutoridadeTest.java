package test.semana05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.semana05.Autoridade;
import main.semana05.Sexo;
import main.semana05.TipoDeTratamento;

public class AutoridadeTest {
	
	Autoridade autoridadeMasculina;
	Autoridade autoridadeFeminina;

	@Before
	public void tratamento() {
		autoridadeMasculina = new Autoridade("Marcelo", "Battaglion");
		autoridadeFeminina = new Autoridade("Joana", "Dark");
	}
	
	@Test
	public void informalMasculino() {
		assertEquals("MARCELO",autoridadeMasculina.getTratamento(TipoDeTratamento.INFORMAL, Sexo.MASCULINO, null));
	}
	
	@Test
	public void informalFeminino() {
		assertEquals("JOANA",autoridadeFeminina.getTratamento(TipoDeTratamento.INFORMAL, Sexo.FEMININO, null));
	}
	
	@Test
	public void respeitosoMasculino() {
		assertEquals("Sr. BATTAGLION", autoridadeMasculina.getTratamento(TipoDeTratamento.RESPEITOSO, Sexo.MASCULINO, null));
	}
	
	@Test
	public void respeitosoFeminino() {
		assertEquals("Sra. DARK", autoridadeFeminina.getTratamento(TipoDeTratamento.RESPEITOSO, Sexo.FEMININO, null));
	}
	
	@Test
	public void comTituloMasculino() {
		assertEquals("Dr MARCELO BATTAGLION", autoridadeMasculina.getTratamento(TipoDeTratamento.COMTITULO, Sexo.MASCULINO, "Dr"));
	}
	
	@Test
	public void comTituloFeminino() {
		assertEquals("Dra JOANA DARK", autoridadeFeminina.getTratamento(TipoDeTratamento.COMTITULO, Sexo.FEMININO, "Dra"));
	}

}
