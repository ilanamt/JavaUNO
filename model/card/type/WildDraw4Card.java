package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defininf UNO Wild Draw 4 Card
 * @author ilana
 *
 */
public class WildDraw4Card extends AbstractWildCard implements ICard {

	/**
	 * Class constructor
	 */
	public WildDraw4Card() {
		super(Symbol.WILD_DRAW_FOUR);
	}

	@Override
	public String toString(){
		return "Wild Draw 4 Card";
	}
	
	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		game.addToDrawWell(4);
		Color color = game.getCurrentPlayer().selectColor(game, ctrl);
		this.setColor(color);
		ctrl.showMessage("Se ha jugado la carta "+this);
		ctrl.showMessage("Se ha escogido el color "+color.getName());
	}

}
