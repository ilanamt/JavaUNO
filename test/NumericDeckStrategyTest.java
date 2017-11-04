package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.ICardPile;
import model.card.deck.NumericDeckStrategy;

public class NumericDeckStrategyTest {
	
	private NumericDeckStrategy strategy;

	@Before
	public void setUp() throws Exception {
		strategy = new NumericDeckStrategy();
	}

	@Test
	public void testCreateDeck() {
		ICardPile p = strategy.createDeck();
		assertEquals(p.getSize(), 80);
	}

}
