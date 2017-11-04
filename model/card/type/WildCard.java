package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defining UNO Wild Card
 * @author ilana
 *
 */
public class WildCard extends AbstractWildCard implements ICard {

	/**
	 * Class constructor
	 */
	public WildCard() {
		super(Symbol.WILD);
	}

	@Override
	public String toString(){
		return "Wild Card";
	}
	

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		Color color = game.getCurrentPlayer().selectColor(game, ctrl);
		this.setColor(color);
		ctrl.showMessage("Se ha jugado la carta "+this);
		ctrl.showMessage("Se ha escogido el color "+color.getName());

	}

}
