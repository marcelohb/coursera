package test.semana05Complementar;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import main.semana05Complementar.Pessoa;
import main.semana05Complementar.Signo;

public class PessoaTest {

	@Test
	public void signoAries() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.MARCH, 21));
		assertEquals(Signo.ARIES, p.getSigno());
	}

	@Test
	public void signoTouro() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.APRIL, 21));
		assertEquals(Signo.TOURO, p.getSigno());
	}

	@Test
	public void signoGemeos() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.JUNE, 20));
		assertEquals(Signo.GEMEOS, p.getSigno());
	}

	@Test
	public void signoLeao() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.JULY, 22));
		assertEquals(Signo.LEAO, p.getSigno());
	}

	@Test
	public void signoVirgem() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.AUGUST, 23));
		assertEquals(Signo.VIRGEM, p.getSigno());
	}

	@Test
	public void signoLibra() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.OCTOBER, 22));
		assertEquals(Signo.LIBRA, p.getSigno());
	}

	@Test
	public void signoEscorpiao() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.NOVEMBER, 21));
		assertEquals(Signo.ESCORPIAO, p.getSigno());
	}

	@Test
	public void signoSagitario() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.DECEMBER, 21));
		assertEquals(Signo.SAGITARIO, p.getSigno());
	}

	@Test
	public void signoCancer() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.JULY, 21));
		assertEquals(Signo.CANCER, p.getSigno());
	}

	@Test
	public void signoAquario1() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.FEBRUARY, 19));
		assertEquals(Signo.AQUARIO, p.getSigno());
	}

	@Test
	public void signoAquario2() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.JANUARY, 21));
		assertEquals(Signo.AQUARIO, p.getSigno());
	}

	@Test
	public void signoCapricornio1() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.DECEMBER, 22));
		assertEquals(Signo.CAPRICORNIO, p.getSigno());
	}

	@Test
	public void signoCapricornio2() {
		Pessoa p = new Pessoa(LocalDate.of(1987, Month.JANUARY, 20));
		assertEquals(Signo.CAPRICORNIO, p.getSigno());
	}

}
