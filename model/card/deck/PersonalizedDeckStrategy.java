package model.card.deck;

import java.util.ArrayList;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.ICard;

/**
 * This class allows to create any kind of deck, adding a list or individual cards
 * @author ilana
 *
 */
public class PersonalizedDeckStrategy implements IDeckStrategy {

	ICardPile deck;
	ArrayList<ICard> initial;
	
	/**
	 * Class constructor
	 * @param cards initial list of cards to be added
	 */
	public PersonalizedDeckStrategy(ArrayList<ICard> cards) {
		deck = new CardPile();
		initial = cards;
	}


	@Override
	public ICardPile createDeck() {
		for(ICard c : initial) {
			deck.pushCard(c);
		}
		
		return deck;
	}
	
	public ICardPile addCard(ICard aCard) {
		deck.pushCard(aCard);
		return deck;
	}

}
