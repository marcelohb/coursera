package test.br.com.forum.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import main.br.com.forum.domain.Badge;

public class BadgeTest {
	
	private Badge badge;

	@Test
	public void newBadge() {
		badge = new Badge("novo");
		assertEquals("novo", badge.getName());
	}
	
	@Test
	public void equals() {
		badge = new Badge("novo");
		Badge other = new Badge("novo");
		assertEquals(other.getName(), badge.getName());
	}

}
