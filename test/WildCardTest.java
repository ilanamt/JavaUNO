package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.card.type.Color;
import model.card.type.NumericCard;
import model.card.type.Symbol;
import model.card.type.WildCard;


public class WildCardTest {
	
	private WildCard card;
	private NumericCard c2;
	

	@Before
	public void setUp() throws Exception {
		card = new WildCard();
		c2 = new NumericCard(Color.GREEN, Symbol.EIGHT);
		
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), Color.NONE);
		assertEquals(card.getSymbol(), Symbol.WILD);
	}
	
	@Test
	public void testIsPlayableOver(){
		assertTrue(card.isPlayableOver(c2));
	}
	
	@Test
	public void testIsFirstPlayable() {
		assertFalse(card.isFirstPlayable());
	}
	
	@Test
	public void testToString() {
		assertEquals(card.toString(), "Wild Card");
	}
	

}
