package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.card.type.Color;
import model.card.type.ReverseCard;
import model.card.type.Symbol;


public class ReverseCardTest {
	
	private ReverseCard card;



	@Before
	public void setUp() throws Exception {
		
		card = new ReverseCard(Color.RED);

	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), Color.RED);
		assertEquals(card.getSymbol(), Symbol.INVERT);
	}
	

}
