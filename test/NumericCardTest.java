package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.NumericCard;
import model.card.type.Symbol;

public class NumericCardTest {
	
	private NumericCard card1;
	private NumericCard card2;
	private NumericCard card3;
	private NumericCard card4;
	
	@Before
	public void setUp() throws Exception {
		card1 = new NumericCard(Color.RED, Symbol.FIVE);
		card2 = new NumericCard(Color.RED, Symbol.SIX);
		card3 = new NumericCard(Color.BLUE, Symbol.FIVE);
		card4 = new NumericCard(Color.BLUE, Symbol.EIGHT);
	}

	@Test
	public void testConstructor() {
		assertEquals(card1.getColor(), Color.RED);
		assertEquals(card1.getSymbol(), Symbol.FIVE);
		assertNotNull(card1);
		
	}
	
	@Test
	public void testSetColor() {
		card1.setColor(Color.BLUE);
		assertEquals(card1.getColor(), Color.BLUE);
	}
	
	@Test
	public void testIsPlayableOver() {
		assertTrue(card1.isPlayableOver(card2));
		assertTrue(card1.isPlayableOver(card3));
		assertFalse(card1.isPlayableOver(card4));
	}
	
	@Test
	public void testIsDiscardable() {
		assertTrue(card1.isDiscardable());
	}
	
	@Test
	public void testToString() {
		assertEquals(card1.toString(), card1.getSymbol().getName()+" "+card1.getColor().getName());
	}
	
	@Test
	public void testIsFirstPlayable() {
		assertTrue(card1.isFirstPlayable());
	}
	

}
