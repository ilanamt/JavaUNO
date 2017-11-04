package model.player.type;

import java.util.ArrayList;
import java.util.Random;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Class for defininf virtual players
 * @author ilana
 *
 */
public class VirtualPlayer extends AbstractPlayer implements IPlayer {
	
	/**
	 * Class constructor
	 * @param aName player name
	 */
	public VirtualPlayer(String aName){
		super(aName);
	}
	
	@Override
	public String toString() {
		return "Virtual Player: " + name;
	}

	@Override
	public ICard getCardToPlay(IGameLogic game, IController ctrl) {
		if(this.needsToDrawCard(game.getCurrentPlayedCard())) {
			game.drawOneCard(this);
		}
		
		ArrayList<ICard> playable = new ArrayList<ICard>();
		for(ICard c : hand) {
			if(c.isPlayableOver(game.getCurrentPlayedCard())) {
				playable.add(c);
			}
		}
		Random random = new Random();
		if(playable.size()>0) {
			int r = random.nextInt(playable.size());
			return playable.get(r);
		}
		
		else {
			return new NullCard();
		}
	}

	@Override
	public Color selectColor(IGameLogic game, IController ctrl) {
		Random random = new Random();
		int r = random.nextInt(4);
		
		return Color.getColors()[r];
	}

}
