package model.card.type;

/**
 * Class to define action cards: skip, reverse and draw to in UNO game
 * @author ilana
 *
 */
public abstract class AbstractActionCard extends AbstractCard implements ICard {
	
	/**
	 * Class constructor
	 * @param aColor card color
	 * @param aSymbol card symbol
	 */
	public AbstractActionCard(Color aColor, Symbol aSymbol) {
		super(aColor, aSymbol);
	}

	@Override
	public boolean isFirstPlayable() {
		return true;
	}

}
