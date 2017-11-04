package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class for defininf numeric cards
 * @author ilana
 *
 */
public class NumericCard extends AbstractCard implements ICard {

	/**
	 * Class constructor
	 * @param aColor card color
	 * @param aSymbol card symbol
	 */
	public NumericCard(Color aColor, Symbol aSymbol) {
		super(aColor, aSymbol);
	}

	@Override
	public boolean isFirstPlayable() {
		return true;
	}

	@Override
	public void executeAction(IGameLogic game, IController ctrl) {
		ctrl.showMessage("Se ha jugado la carta "+this);
	}


}
