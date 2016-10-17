package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Armazenamento;
import main.Placar;
import main.Pontos;

public class PlacarTest {
	
	ArmazenamentoMock aMock;
	Armazenamento a;
	Placar placar;
	
	@Before
	public void setUp() {
		aMock = new ArmazenamentoMock();
		a = new Armazenamento("src/gami.txt");
	}
	
	@Test
	public void registrarPontoMock() {
		placar = new Placar(aMock);
		placar.registrarPonto("eu", 100, Pontos.COMENTARIO);
	}

	@Test
	public void retornarPontosDeUmUsuarioMock() {
		placar = new Placar(aMock);
		placar.registrarPonto("guerra", 10, Pontos.ESTRELA);
		HashMap<Pontos, Integer> pontos = placar.retornarPontosDeUmUsuario("guerra");
		assertEquals(Integer.valueOf(10), pontos.get(Pontos.ESTRELA));
	}
	
	@Test
	public void retornarRankingDeTipoDePontoMock() {
		placar = new Placar(aMock);
		List<Integer> pontos = new ArrayList<>();
		pontos.add(10);
		pontos.add(1);
		pontos.add(2);
		Collections.sort(pontos);
		placar.registrarPonto("guerra", 10, Pontos.CURTIDA);
		placar.registrarPonto("eu", 1, Pontos.CURTIDA);
		placar.registrarPonto("gugu", 2, Pontos.CURTIDA);
		assertEquals(Integer.valueOf(1), pontos.get(0));
		assertEquals(Integer.valueOf(2), pontos.get(1));
		assertEquals(Integer.valueOf(10), pontos.get(2));
	}

	@Test
	public void registrarPontoDeUmUsuario() {
		placar = new Placar(a);
		placar.registrarPonto("guerra", 10, Pontos.ESTRELA);
	}
	
	@Test
	public void retornarPontosDeUmUsuario() {
		placar = new Placar(a);
		placar.registrarPonto("guerra", 10, Pontos.CURTIDA);
		placar.registrarPonto("guerra", 10, Pontos.CURTIDA);
		placar.registrarPonto("guerra", 10, Pontos.COMENTARIO);
		HashMap<Pontos, Integer> pontos = placar.retornarPontosDeUmUsuario("guerra");
		assertEquals(Integer.valueOf(20), pontos.get(Pontos.CURTIDA));
		assertEquals(Integer.valueOf(10), pontos.get(Pontos.COMENTARIO));
	}
	
	@Test
	public void retornarRankingDeTipoDePonto() {
		placar = new Placar(a);
		List<Integer> pontos = new ArrayList<>();
		placar.registrarPonto("guerra", 10, Pontos.CURTIDA);
		placar.registrarPonto("guerra", 10, Pontos.COMENTARIO);
		placar.registrarPonto("eu", 1, Pontos.CURTIDA);
		placar.registrarPonto("gugu", 2, Pontos.CURTIDA);
		placar.registrarPonto("xuxa", 0, Pontos.CURTIDA);
		pontos = placar.retornarRanking(Pontos.CURTIDA);
		assertEquals(Integer.valueOf(1), pontos.get(0));
		assertEquals(Integer.valueOf(2), pontos.get(1));
		assertEquals(Integer.valueOf(10), pontos.get(2));
	}

}
