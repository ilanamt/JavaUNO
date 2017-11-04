package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.IPlayer;
import model.player.type.RealPlayer;

public class PlayerManagerTest {
	
	private PlayerManager manager;
	private PlayerManager manager2;
	private IPlayerListBuilder builder;
	private IPlayer player1;
	private IPlayer player2;
	private IPlayer player3;

	@Before
	public void setUp() throws Exception {
		builder = new PlayerListBuilder();
		player1 = new RealPlayer("player1");
		player2 = new RealPlayer("player2");
		player3 = new RealPlayer("player3");
		builder.addPlayer(player1);
		builder.addPlayer(player2);
		builder.addPlayer(player3);
		manager = new PlayerManager(builder);
		builder.addPlayer(player1);
		builder.addPlayer(player2);
		manager2 = new PlayerManager(builder);
	}

	@Test
	public void testGetCurrent() {
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player1);
	}
	
	@Test
	public void testGetPlayers() {
		manager.startTurn();
		assertEquals(manager.getPlayers().size(), 3);
		assertNotNull(manager.getPlayers().get(0));
		assertNotNull(manager.getPlayers().get(1));
		assertNotNull(manager.getPlayers().get(2));
		assertEquals(manager.getPlayers().get(0), player1);
		assertEquals(manager.getPlayers().get(1), player2);
		assertEquals(manager.getPlayers().get(2), player3);
	}
	
	@Test
	public void testStartTurn() {
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player1);
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player2);
		manager.invertDirection();
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player1);
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player3);
	}
	
	@Test
	public void testSkip() {
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player1);
		manager.skipPlayer();
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player3);
		manager.invertDirection();
		manager.startTurn();
		manager.skipPlayer();
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player3);

		
	}
	
	@Test
	public void testInvert() {
		manager2.startTurn();
		assertEquals(manager2.getCurrentPlayer(), player1);
		manager2.invertDirection();
		manager2.startTurn();
		assertEquals(manager2.getCurrentPlayer(), player1);
		
		manager.startTurn();
		assertEquals(manager2.getCurrentPlayer(), player1);
		manager.invertDirection();
		manager.startTurn();
		assertEquals(manager.getCurrentPlayer(), player3);
	}
	

}
