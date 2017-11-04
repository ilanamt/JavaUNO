package model.card.type;

/**
 * Class for defining UNO Cards
 * @author ilana
 *
 */
public abstract class AbstractCard implements ICard{
	
	private Color color;
	private Symbol symbol;
	
	/**
	 * Class constructor
	 * @param aColor card color
	 * @param aSymbol card symbol
	 */
	public AbstractCard(Color aColor, Symbol aSymbol) {
		color = aColor;
		symbol = aSymbol;
	}
	  
	public Color getColor() {
		return this.color;  
	}
	
	public void setColor(Color aColor) {
		this.color = aColor;  
	}

	public Symbol getSymbol() {
		return this.symbol;
	}
	
	public boolean isPlayableOver(ICard otherCard) {
		return (otherCard.getColor() == this.getColor() || otherCard.getSymbol() == this.getSymbol());	
	}
	
	public boolean isDiscardable() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getSymbol().getName() +" "+ this.getColor().getName();	
	}


}
