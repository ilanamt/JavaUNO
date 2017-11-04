package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ConsoleController;
import controller.IController;
import model.GameLogic;
import model.IGameLogic;
import model.card.deck.IDeckStrategy;
import model.card.deck.UNODeckStrategy;
import model.card.type.Color;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.type.IPlayer;
import model.player.type.VirtualPlayer;
import view.ConsoleView;

public class VirtualPlayerTest {
	
	private IPlayer player;
	private IGameLogic game;
	private IPlayerListBuilder builder;
	private IDeckStrategy strategy;
	private IController ctrl;
	private ConsoleView view;


	@Before
	public void setUp() throws Exception {
		
		player = new VirtualPlayer("player");
		builder = new PlayerListBuilder();
		strategy = new UNODeckStrategy();
		game = new GameLogic(builder, strategy);
		view = new ConsoleView(game);
		ctrl = new ConsoleController(game, view);
	}

	@Test
	public void testToString() {
		assertEquals(player.toString(), "Virtual Player: "+"player");
	}
	
	@Test
	public void testConstructor() {
		assertFalse(player.hasSaidUNO());
	}
	
	@Test
	public void testSelectColor() {
		Color a = player.selectColor(game, ctrl);
		boolean res = a.equals(Color.BLUE) || a.equals(Color.RED) || a.equals(Color.GREEN) || a.equals(Color.YELLOW);
		assertTrue(res);
	}
	

}
