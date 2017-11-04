package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameLogic;
import model.IGameLogic;
import model.card.deck.IDeckStrategy;
import model.card.deck.UNODeckStrategy;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.type.IPlayer;
import model.player.type.VirtualPlayer;

public class GameLogicTest {
	
	private IGameLogic game;
	private IPlayerListBuilder builder;
	private IDeckStrategy strategy;

	@Before
	public void setUp() throws Exception {
		builder = new PlayerListBuilder();
		
		IPlayer p1 = new VirtualPlayer("p1");
		IPlayer p2 = new VirtualPlayer("p2");
		IPlayer p3 = new VirtualPlayer("p3");
		IPlayer p4 = new VirtualPlayer("p4");
		    
		builder.addPlayer(p1);
		builder.addPlayer(p2);
		builder.addPlayer(p3);
		builder.addPlayer(p4);
		
		strategy = new UNODeckStrategy();
		game = new GameLogic(builder, strategy);
	}

	@Test
	public void testDrawWell() {
		assertTrue(game.isDrawWellEmpty());
		game.addToDrawWell(10);
		assertFalse(game.isDrawWellEmpty());
		game.resetDrawWell();
		assertTrue(game.isDrawWellEmpty());

		
		
	}

}
