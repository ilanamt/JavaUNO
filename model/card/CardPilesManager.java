package model.card;

import java.util.ArrayList;

import model.card.deck.IDeckStrategy;
import model.card.type.ICard;
import model.player.type.IPlayer;

/**
 * This class manages everything that needs to be done with the deck and discard pile
 * @author ilana
 *
 */
public class CardPilesManager implements ICardPilesManager {
	
	protected ICardPile deck;
	protected ICardPile descartes;
	
	/**
	 * Class constructor
	 * @param strategy deck strategy used for this game
	 */
	public CardPilesManager(IDeckStrategy strategy) {
		deck = strategy.createDeck();
		descartes = new CardPile();
		
		deck.shuffle();
		
		ICard first = deck.peekCard();
		while(!first.isFirstPlayable()) {
			deck.shuffle();
			first = deck.peekCard();
		}
		descartes.pushCard(deck.popCard());
	}
	
	public int getDeckSize() {
		return deck.getSize();
	}

	@Override
	public void rebuildDeck() {
		ICard first = descartes.popCard();
		deck.pushCards(descartes);
		descartes.pushCard(first);
		deck.shuffle();
	}

	@Override
	public ICard drawCard() {
		return deck.popCard();
	}

	@Override
	public int getDrawableCardsNumber() {
		
		return deck.getSize() + descartes.getSize() -1;
	}

	@Override
	public ArrayList<ICard> drawCards(int cardsNumber) {
		if(cardsNumber>deck.getSize()) {
			this.rebuildDeck();
		}
		ArrayList<ICard> res = new ArrayList<ICard>();
		for(int i =1; i<= cardsNumber;i++) {
			res.add(deck.popCard());
		}	
		return res;
	}
	
	@Override
	public ICard getCurrentPlayedCard() {
		return descartes.peekCard();
	}

	@Override
	public void discard(ICard newCard) {
		descartes.pushCard(newCard);
	}

	@Override
	public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
		ArrayList<ICard> nuevas = new ArrayList<ICard>();
		for(int i=1; i<=number; i++) {
			nuevas.add(deck.popCard());
		}
		player.addToHand(nuevas);
		return nuevas;
	}

}
