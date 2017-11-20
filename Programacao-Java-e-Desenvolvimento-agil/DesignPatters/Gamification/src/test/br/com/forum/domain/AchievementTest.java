package test.br.com.forum.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.br.com.forum.domain.Achievement;

public class AchievementTest {
	
	private Achievement achievement;
	
	@Before
	public void setUp() {
		achievement = new Achievement("primeiraConquista");
	}

	@Test
	public void newAchievement() {
		assertEquals("primeiraConquista", achievement.getName());
	}
	
	@Test
	public void equals() {
		Achievement other = new Achievement("primeiraConquista");
		assertEquals(achievement, other);
	}

}
