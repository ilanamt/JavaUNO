package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.card.CardPilesManager;
import model.card.deck.IDeckStrategy;
import model.card.deck.UNODeckStrategy;
import model.card.type.ICard;
import model.player.type.RealPlayer;

public class CardPilesManagerTest {
	
	private CardPilesManager manager;
	private IDeckStrategy strategy;
	private RealPlayer player;

	@Before
	public void setUp() throws Exception {
		strategy = new UNODeckStrategy();
		manager = new CardPilesManager(strategy);
		player = new RealPlayer("player1");
	}

	@Test
	public void testNotNull() {
		assertNotNull(manager.drawCard());
		assertNotNull(manager.drawCards(100));
		
	}
	
	@Test
	public void testRebuildDeck() {
		ICard a = manager.drawCard();
		ICard c = manager.drawCard();
		
		manager.discard(c);
		manager.discard(a);
		manager.rebuildDeck();
		assertEquals(manager.getCurrentPlayedCard(), a);
	}
	
	@Test
	public void testAddCardsToPlayer() {
		assertEquals(manager.getDrawableCardsNumber(), 107);
		manager.addCardsToPlayer(player, 7);
		assertEquals(manager.getDrawableCardsNumber(),100);
		assertEquals(player.getHandSize(), 7);
		
	}
	
	@Test
	public void testDrawCards() {
		ArrayList<ICard> a = manager.drawCards(7);
		assertEquals(a.size(), 7);
		assertEquals(manager.getDrawableCardsNumber(),100);
	}

}
