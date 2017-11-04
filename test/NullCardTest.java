package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.NullCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

public class NullCardTest {
	
	private NullCard card;
	private WildCard c2;

	@Before
	public void setUp() throws Exception {
		card = new NullCard();
		c2 = new WildCard();
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), Color.NONE);
		assertEquals(card.getSymbol(), Symbol.NONE);
	}
	
	@Test
	public void testIsPlayableOver() {
		assertTrue(card.isPlayableOver(c2));
	}
	
	@Test
	public void testIsFisrtPlayable() {
		assertFalse(card.isFirstPlayable());
	}
	
	@Test
	public void testIsDiscardable() {
		assertFalse(card.isDiscardable());
	}

}
