package main.semana05Complementar;

import java.time.LocalDate;
import java.time.Month;

public class Pessoa {

	LocalDate dataNascimento;
	LocalDate dtInicio, dtFim;
	
	public Pessoa(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Signo getSigno() {
		int ano = dataNascimento.getYear();
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.MARCH, 21-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.APRIL, 20+1))) {
			return Signo.ARIES;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.APRIL, 21-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.MAY, 20+1))) {
			return Signo.TOURO;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.MAY, 21-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.JUNE, 20+1))) {
			return Signo.GEMEOS;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.JUNE, 21-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.JULY, 21+1))) {
			return Signo.CANCER;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.JULY, 22-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.AUGUST, 22+1))) {
			return Signo.LEAO;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.AUGUST, 23-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.SEPTEMBER, 22+1))) {
			return Signo.VIRGEM;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.SEPTEMBER, 23-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.OCTOBER, 22+1))) {
			return Signo.LIBRA;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.OCTOBER, 22-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.NOVEMBER, 22+1))) {
			return Signo.ESCORPIAO;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.NOVEMBER, 22-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.DECEMBER, 21+1))) {
			return Signo.SAGITARIO;
		}
		
		if ((dataNascimento.isAfter(LocalDate.of(ano, Month.DECEMBER, 22-1)) && dataNascimento.isBefore(LocalDate.of(ano+1, Month.JANUARY, 1))) ||
			(dataNascimento.isAfter(LocalDate.of(ano-1, Month.DECEMBER, 31)) && dataNascimento.isBefore(LocalDate.of(ano, Month.JANUARY, 20+1)))) {
			return Signo.CAPRICORNIO;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.JANUARY, 21-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.FEBRUARY, 19+1))) {
			return Signo.AQUARIO;
		}
		
		if (dataNascimento.isAfter(LocalDate.of(ano, Month.FEBRUARY, 20-1)) && dataNascimento.isBefore(LocalDate.of(ano, Month.MARCH, 20))) {
			return Signo.PEIXES;
		}
		return null;
	}

}
