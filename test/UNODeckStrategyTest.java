package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.card.ICardPile;
import model.card.deck.IDeckStrategy;
import model.card.deck.UNODeckStrategy;

public class UNODeckStrategyTest {
	ICardPile pile;

	@Before
	public void setUp() throws Exception {
		IDeckStrategy UNOstrategy = new UNODeckStrategy();
		pile = UNOstrategy.createDeck();
		
	}

	@Test
	public void testCreateDeck() {
		assertEquals(pile.getSize(), 108);
	}

}
