package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining UNO Draw 2 card
 * @author ilana
 *
 */
public class Draw2Card extends AbstractActionCard implements ICard {

	/**
	 * Class constructor
	 * @param aColor card color
	 */
	public Draw2Card(Color aColor) {
		super(aColor, Symbol.DRAW_TWO);
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.addToDrawWell(2);
		ctrl.showMessage("Se ha jugado la carta "+this);

	}

}
