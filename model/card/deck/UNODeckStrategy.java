package model.card.deck;

import java.util.EnumSet;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.Draw2Card;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.ReverseCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;
import model.card.type.WildCard;
import model.card.type.WildDraw4Card;

/**
 * This class allows to create a UNO Deck
 * @author ilana
 *
 */
public class UNODeckStrategy implements IDeckStrategy {
	ICardPile deck;
	
	/**
	 * Class constructor
	 */
	public UNODeckStrategy() {
		deck = new CardPile();
	}

	@Override
	public ICardPile createDeck() {
		
		EnumSet<Color> colores;
		colores = EnumSet.range(Color.BLUE, Color.YELLOW);	
		
		EnumSet<Symbol> numbers;
		numbers = EnumSet.range(Symbol.ONE, Symbol.NINE);
		
		//Se agregan las cartas 0 (1 de cada color)
		ICard zr = new NumericCard(Color.RED, Symbol.ZERO);
		ICard zg = new NumericCard(Color.GREEN, Symbol.ZERO);
		ICard zb = new NumericCard(Color.BLUE, Symbol.ZERO);
		ICard zy = new NumericCard(Color.YELLOW, Symbol.ZERO);
		
		deck.pushCard(zr);
		deck.pushCard(zg);
		deck.pushCard(zb);
		deck.pushCard(zy);
		
		//Se agregan las cartas del 1 al 9 (2 de cada color)
		for(Symbol num : numbers) {
			ICard r = new NumericCard(Color.RED, num);
			ICard g = new NumericCard(Color.GREEN, num);
			ICard b = new NumericCard(Color.BLUE, num);
			ICard y = new NumericCard(Color.YELLOW, num);
			deck.pushCard(r);
			deck.pushCard(g);
			deck.pushCard(b);
			deck.pushCard(y);
			deck.pushCard(r);
			deck.pushCard(g);
			deck.pushCard(b);
			deck.pushCard(y);		
		}
		
		//Se gregan las skip card
		for(Color col : colores) {
			ICard sc = new SkipCard(col);
			deck.pushCard(sc);
			deck.pushCard(sc);
		}
		
		//Se agregan las reverse card
		for(Color col : colores) {
			ICard rc = new ReverseCard(col);
			deck.pushCard(rc);
			deck.pushCard(rc);
		}
		
		//Se agregan las draw 2 card (2 de cada una)
		for(Color col : colores) {
			ICard dc = new Draw2Card(col);
			deck.pushCard(dc);
			deck.pushCard(dc);
		}
		
		//Se agregan las wild card (4 de cada una)
		ICard wc = new WildCard();
		deck.pushCard(wc);
		deck.pushCard(wc);
		deck.pushCard(wc);
		deck.pushCard(wc);
		
		//Se agregan las wild draw 4 (4 de cada una)
		ICard wcd = new WildDraw4Card();
		deck.pushCard(wcd);
		deck.pushCard(wcd);
		deck.pushCard(wcd);
		deck.pushCard(wcd);
		
		//Se revuelve el mazo
		deck.shuffle();
		
		return deck;
	}

}
