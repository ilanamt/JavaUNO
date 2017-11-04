package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining wild cards: wild and wild draw 4 in UNO game
 * @author ilana
 *
 */
public abstract class AbstractWildCard extends AbstractCard implements ICard {
	
	/**
	 * Class constructor
	 * @param sim card symbol
	 */
	public AbstractWildCard(Symbol sim) {
		super(Color.NONE, sim);
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
	public abstract void executeAction(IGameLogic game, IController ctrl);
	

}
