package test.semana01;

import static org.junit.Assert.*;

import org.junit.Test;

import main.semana01.Paciente;

public class PacienteTest {
	
	@Test
	public void pesoBaixoMuitoGrave() {
		Paciente p1 = new Paciente(50.0, 1.8);
		assertEquals(15.43, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void pesoGrave() {
		Paciente p1 = new Paciente(55.0, 1.8);
		assertEquals(16.97, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void pesoBaixo() {
		Paciente p1 = new Paciente(60.0, 1.8);
		assertEquals(18.51, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void pesoNormal() {
		Paciente p1 = new Paciente(80.0, 1.8);
		assertEquals(24.69, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void sobrepeso() {
		Paciente p1 = new Paciente(81.5, 1.8);
		assertEquals(25.15, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void obesidadeGrau1() {
		Paciente p1 = new Paciente(98.0, 1.8);
		assertEquals(30.24, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void obesidadeGrau2() {
		Paciente p1 = new Paciente(120.0, 1.8);
		assertEquals(37.03, p1.calcularIMC(),0.01);
	}
	
	@Test
	public void obesidadeGrau3() {
		Paciente p1 = new Paciente(129.8, 1.8);
		assertEquals(40.06, p1.calcularIMC(),0.01);
	}

}
