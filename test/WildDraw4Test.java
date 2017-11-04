package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.Symbol;
import model.card.type.WildDraw4Card;

public class WildDraw4Test {
	
	private WildDraw4Card card;

	@Before
	public void setUp() throws Exception {
		card = new WildDraw4Card();
		
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), Color.NONE);
		assertEquals(card.getSymbol(), Symbol.WILD_DRAW_FOUR);
	}
	
	@Test
	public void testToString() {
		assertEquals(card.toString(), "Wild Draw 4 Card");
	}

}
