package model.card.deck;

import java.util.EnumSet;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NumericCard;

import model.card.type.Symbol;

/**
 * Class that allows to create a Numeric Deck with cards from 0 to 9
 * and 2 of each in each color
 * @author ilana
 *
 */
public class NumericDeckStrategy implements IDeckStrategy {

ICardPile deck;
	
	/**
	 * Class constructor
	 */
	public NumericDeckStrategy() {
		deck = new CardPile();
	}

	@Override
	public ICardPile createDeck() {
		
		
		EnumSet<Symbol> numbers;
		numbers = EnumSet.range(Symbol.ZERO, Symbol.NINE);

		
		//Se agregan las cartas del 0 al 9 (2 de cada color)
		for(Symbol num : numbers) {
			ICard r = new NumericCard(Color.RED, num);
			ICard g = new NumericCard(Color.GREEN, num);
			ICard b = new NumericCard(Color.BLUE, num);
			ICard y = new NumericCard(Color.YELLOW, num);
			deck.pushCard(r);
			deck.pushCard(g);
			deck.pushCard(b);
			deck.pushCard(y);
			deck.pushCard(r);
			deck.pushCard(g);
			deck.pushCard(b);
			deck.pushCard(y);		
		}
		
		//Se revuelve el mazo
		deck.shuffle();
		
		return deck;
	}

}
