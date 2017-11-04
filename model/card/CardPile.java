package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.ICard;

/**
 * This class allows to create and use a stack of ICard's
 * @author ilana
 *
 */
public class CardPile implements ICardPile {

	protected Stack<ICard> pila;
	
	/**
	 * Class constructor
	 */
	public CardPile() {
		pila = new Stack<ICard>();
	}
	
	@Override
	public int getSize() {
		return pila.size();
	}

	@Override
	public ICard pushCard(ICard newCard) {
		return pila.push(newCard);
	}

	@Override
	public ICard popCard() {
		return pila.pop();
	}

	@Override
	public ICard peekCard() {
		return pila.peek();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(pila);

	}

	@Override
	public boolean isEmpty() {
		return pila.empty();
	}

	@Override
	public void pushCards(ICardPile otherPile) {
		for(int i=1; i<=otherPile.getSize(); i++) {
			this.pushCard(otherPile.popCard());
		}

	}

}
