package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.CardPile;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

public class CardPileTest {
	
	private CardPile pile;
	private CardPile pile2;
	private ICard c3;
	private ICard c1;
	private ICard c2;

	@Before
	public void setUp() throws Exception {
		c1 = new WildCard();
		c2 = new NumericCard(model.card.type.Color.BLUE, Symbol.EIGHT);
		c3 = new NumericCard(model.card.type.Color.RED, Symbol.FIVE);
		pile = new CardPile();
		pile2 = new CardPile();
	}


	@Test
	public void testEmpty() {
		assertEquals(pile.isEmpty(), true);
		pile.pushCard(c1);
		assertEquals(pile.isEmpty(), false);
	}
	
	@Test
	public void testGetSize() {
		assertEquals(pile.getSize(), 0);
		pile.pushCard(c1);
		assertEquals(pile.getSize(), 1);
			
	}
	
	@Test
	public void testPushPop() {
		pile.pushCard(c1);
		pile.pushCard(c2);
		assertEquals(pile.getSize(), 2);
		assertEquals(pile.popCard(), c2);
		assertEquals(pile.getSize(), 1);
	}
	
	@Test
	public void testPeek() {
		pile.pushCard(c2);
		assertEquals(pile.getSize(), 1);
		assertEquals(pile.peekCard(), c2);
		assertEquals(pile.getSize(), 1);
	}
	
	@Test
	public void testPushCards() {
		pile2.pushCard(c2);
		pile.pushCard(c1);
		pile.pushCards(pile2);
		assertEquals(pile.getSize(), 2);
		assertEquals(pile2.getSize(), 0);
		assertEquals(pile.peekCard(), c2);
			
	}
	
	@Test
	public void testShuffle() {
		pile.pushCard(c2);
		pile.pushCard(c1);
		pile.pushCard(c3);
		pile.shuffle();
		assertEquals(pile.getSize(), 3);
		
	}
	
}
