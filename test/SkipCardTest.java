package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.card.type.SkipCard;
import model.card.type.Symbol;


public class SkipCardTest {
	
	private SkipCard card;


	@Before
	public void setUp() throws Exception {
		
		card = new SkipCard(model.card.type.Color.BLUE);
		
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), model.card.type.Color.BLUE);
		assertEquals(card.getSymbol(), Symbol.SKIP);
		
	}
	

}
