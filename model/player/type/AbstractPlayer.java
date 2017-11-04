package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Class for defining players
 * @author ilana
 *
 */
public abstract class AbstractPlayer implements IPlayer {
	
	protected ArrayList<ICard> hand;
	protected boolean UNOstate;
	protected String name;
	
	/**
	 * Class constructor
	 * @param aName player name
	 */
	public AbstractPlayer(String aName) {
		hand = new ArrayList<ICard>();
		UNOstate = false;
		name = aName;
	}
	

	@Override
	public void addToHand(ArrayList<ICard> aHand) {
		for(ICard card : aHand) {
			hand.add(card);
		}
	}

	@Override
	public boolean hasWon() {
		return hand.size()==0;
	}

	@Override
	public abstract ICard getCardToPlay(IGameLogic game, IController ctrl);

	@Override
	public abstract Color selectColor(IGameLogic game, IController ctrl);

	@Override
	public int getHandSize() {
		return hand.size();
	}

	@Override
	public boolean hasOneCard() {
		return hand.size()==1;
	}

	@Override
	public ArrayList<ICard> getHand() {
		return hand;
	}

	@Override
	public void setSaidUNO(boolean status) {
		UNOstate = status;
	}

	@Override
	public boolean hasSaidUNO() {
		return UNOstate;
	}

	@Override
	public void removeCardFromHand(ICard card) {
		hand.remove(card);
	}

	@Override
	public boolean needsToDrawCard(ICard currentCard) {
		for(ICard c : hand) {
			if(c.isPlayableOver(currentCard)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ICard getCardFromHand(int number) {
		if(number<hand.size() && number>=0) {
			return hand.get(number);
		}
		else {
			return new NullCard();
		}
	}
	


}
