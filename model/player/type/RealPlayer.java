package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Class for defining real players
 * @author ilana
 *
 */
public class RealPlayer extends AbstractPlayer implements IPlayer {
	
	/**
	 * Class constructor
	 * @param aName player name
	 */
	public RealPlayer(String aName) {
		super(aName);
	}
	
	@Override
	public String toString() {
		return "Real Player: " +name;
	}

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		int n = ctrl.AskForCardFromHand(this);
		if(n == hand.size()) {
			if(!this.needsToDrawCard(game.getCurrentPlayedCard())) {
				ctrl.showMessage("Usted tiene cartas jugables, no puede robar del mazo");
				n = ctrl.AskForCardFromHand(this);
			}
			else {
				return new NullCard();
				 
			}
		}
		return this.getCardFromHand(n);
	}
	

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) { 
		return ctrl.askForColor();
	}

}
