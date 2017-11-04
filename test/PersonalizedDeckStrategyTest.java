package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import model.card.ICardPile;

import model.card.deck.PersonalizedDeckStrategy;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

public class PersonalizedDeckStrategyTest {
	
	private PersonalizedDeckStrategy strategy;

	@Before
	public void setUp() throws Exception {
		ArrayList<ICard> l= new ArrayList<ICard>();
		ICard c1 = new WildCard();
		ICard c2 = new NumericCard(model.card.type.Color.BLUE, Symbol.EIGHT);
		ICard c3 = new NumericCard(model.card.type.Color.RED, Symbol.FIVE);
		l.add(c1);
		l.add(c2);
		l.add(c3);
		strategy = new PersonalizedDeckStrategy(l);
	}

	@Test
	public void testCreateDeck() {
		ICardPile deck = strategy.createDeck();
		assertEquals(deck.getSize(), 3);
	}
	
	@Test
	public void testAddCard() {
		ICard c4 = new WildCard();
		ICardPile deck = strategy.addCard(c4);
		assertEquals(deck.getSize(), 1);
		
	}

}
