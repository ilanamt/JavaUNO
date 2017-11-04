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
import model.card.type.Draw2Card;
import model.card.type.Symbol;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import view.ConsoleView;

public class Draw2CardTest {
	
	private Draw2Card card;
	private IGameLogic game;
	private IPlayerListBuilder builder;
	private IDeckStrategy strategy;
	private IController ctrl;
	private ConsoleView view;

	@Before
	public void setUp() throws Exception {
		card = new Draw2Card(Color.YELLOW);
		builder = new PlayerListBuilder();
		strategy = new UNODeckStrategy();
		game = new GameLogic(builder, strategy);
		view = new ConsoleView(game);
		ctrl = new ConsoleController(game, view);
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getColor(), Color.YELLOW);
		assertEquals(card.getSymbol(), Symbol.DRAW_TWO);
	}
	
	@Test
	public void testIsFirstPlayable() {
		assertTrue(card.isFirstPlayable());
	}
	
	@Test
	public void testAction() {
		card.executeAction(game, ctrl);
		assertFalse(game.isDrawWellEmpty());
	}

}
