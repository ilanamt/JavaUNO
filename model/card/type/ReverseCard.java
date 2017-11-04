package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining UNO Reverse Card
 * @author ilana
 *
 */
public class ReverseCard extends AbstractActionCard implements ICard {

	/**
	 * Class constructor
	 * @param aColor card color
	 */
	public ReverseCard(Color aColor) {
		super(aColor, Symbol.INVERT);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.invertDirection();
		ctrl.showMessage("Se ha jugado la carta "+this);
	}

}
