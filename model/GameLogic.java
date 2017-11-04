package model;

import java.util.ArrayList;

import controller.IController;
import model.card.CardPilesManager;
import model.card.deck.IDeckStrategy;
import model.card.type.ICard;
import model.player.IPlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.IPlayer;
/**
 * This class represents the complete game logic,
 * using a Player Manager and CardPile Manager
 * @author ilana
 *
 */
public class GameLogic implements IGameLogic {
	
	protected PlayerManager pmanager;
	protected CardPilesManager cmanager;
	protected ArrayList<ICard> drawWell;
	
	/**
	 * Class constructor
	 * @param playerBuilder player builder used for this game
	 * @param strategy deck strategy used for this game
	 */
	public GameLogic(IPlayerListBuilder playerBuilder, IDeckStrategy strategy) {
		pmanager = new PlayerManager(playerBuilder);
		cmanager = new CardPilesManager(strategy);
		drawWell = new ArrayList<ICard>();
		for(IPlayer p : pmanager.getPlayers()) {
			ArrayList<ICard> agr = this.cmanager.drawCards(7);
			p.addToHand(agr);
		}
	}

	@Override
	public boolean hasEnded() {
		for(IPlayer p : pmanager.getPlayers()) {
			if(p.hasWon()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return pmanager.getCurrentPlayer();
	}

	@Override
	public ICard getCurrentPlayedCard() {
		return cmanager.getCurrentPlayedCard();
	}

	@Override
	public void autoShoutUNO(IController ctrl) {
		IPlayer current = this.getCurrentPlayer();
		if(!current.hasSaidUNO() && current.hasOneCard()) {
			current.setSaidUNO(true);
			ctrl.showMessage("¡UNO!");
		}

	}

	@Override
	public void startTurn(IController ctrl) {
		pmanager.startTurn();
		
		IPlayer current = this.getCurrentPlayer();
		if(!this.isDrawWellEmpty()) {
			this.drawCardsFromWell(current, ctrl);
			pmanager.startTurn();
		}
		
		
		this.autoShoutUNO(ctrl);

	}

	@Override
	public void skipPlayer() {
		pmanager.skipPlayer();

	}

	@Override
	public void addToDrawWell(int number) {
		ArrayList<ICard> newc = cmanager.drawCards(number);
		drawWell.addAll(newc);

	}

	@Override
	public void resetDrawWell() {
		drawWell.clear();
	}

	@Override
	public boolean isDrawWellEmpty() {
		return drawWell.isEmpty();
	}

	@Override
	public void drawCardsFromWell(IPlayer player, IController ctrl) {
		
		player.addToHand(drawWell);
		player.setSaidUNO(false);
		ctrl.showMessage("Jugador"+ this.getCurrentPlayer()  +" ha robado " + drawWell.size()+ " cartas");
		this.resetDrawWell();
			
		
	}

	@Override
	public void invertDirection() {
		pmanager.invertDirection();
	}

	@Override
	public boolean playCard(ICard playedCard, IController ctrl) {
		if(playedCard.isPlayableOver(this.getCurrentPlayedCard())) {
			playedCard.executeAction(this, ctrl);
			if(playedCard.isDiscardable()) {
				cmanager.discard(playedCard);
				ctrl.updatePlayedCard();
				this.getCurrentPlayer().removeCardFromHand(playedCard);
			}
			
			return true;
		}
		else {
			ctrl.showMessage("No se pudo jugar la carta, escoja otra");
			return false;
		}
		
	}

	@Override
	public ICard drawOneCard(IPlayer player) {
		if(cmanager.getDeckSize()<1) {
			cmanager.rebuildDeck();
		}
		player.setSaidUNO(false);
		ICard robada = cmanager.drawCard();
		ArrayList<ICard> agr = new ArrayList<ICard>();
		agr.add(robada);
		player.addToHand(agr);
		return robada;
	}

	@Override
	public void announceWinner(IController ctrl) {
		for(IPlayer p : pmanager.getPlayers()) {
			if(p.hasWon()) {
				ctrl.showMessage("El jugador "+ p +" ha ganado!");
			}
		}

	}

}
