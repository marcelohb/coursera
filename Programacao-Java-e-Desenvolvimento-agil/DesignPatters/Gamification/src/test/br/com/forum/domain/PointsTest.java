package test.br.com.forum.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import main.br.com.forum.domain.Points;

public class PointsTest {
	
	private Points points;

	@Test
	public void newPoints() {
		points = new Points("New Points", 10);
		assertEquals("New Points", points.getName());
		assertEquals(10, points.getQtd());
	}
	
	@Test
	public void equals() {
		points = new Points("New Points", 10);
		Points other = new Points("New Points", 10);
		assertEquals(other.getName(), points.getName());
		assertEquals(other.getQtd(), points.getQtd());
	}

}
