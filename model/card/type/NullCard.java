package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining NullCard to be played when there are no playable cards
 * @author ilana
 *
 */
public class NullCard extends AbstractCard implements ICard {

	/**
	 * Class constructor
	 */
	public NullCard() {
		super(Color.NONE, Symbol.NONE);
	}

	@Override
	public boolean isPlayableOver(ICard otherCard) {
		return true;
	}
	
	@Override
	public boolean isFirstPlayable() {
		return false;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		ICard card = game.drawOneCard(game.getCurrentPlayer());
		if(card.isPlayableOver(game.getCurrentPlayedCard())) {
			game.getCurrentPlayer().removeCardFromHand(card);
			game.playCard(card, ctrl);
		}
	}
	
	@Override
	public boolean isDiscardable() {
		return false;
	}

}
