package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining UNO Skip Card
 * @author ilana
 *
 */
public class SkipCard extends AbstractActionCard implements ICard {

	/**
	 * Class constructor
	 * @param aColor card color
	 */
	public SkipCard(Color aColor) {
		super(aColor, Symbol.SKIP);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.skipPlayer();
		ctrl.showMessage("Se ha jugado la carta "+this);
	}

}
