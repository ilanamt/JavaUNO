package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.player.PlayerListBuilder;
import model.player.type.IPlayer;
import model.player.type.RealPlayer;
import model.player.type.VirtualPlayer;

public class PlayerListBuilderTest {
	
	private PlayerListBuilder builder;
	private IPlayer player1;
	private IPlayer player2;

	@Before
	public void setUp() throws Exception {
		builder = new PlayerListBuilder();
		player1 = new RealPlayer("p1");
		player2 = new VirtualPlayer("p2");
	}

	@Test
	public void testAddPlayer() {
		assertEquals(builder.buildPlayerList().size(), 0);
		builder.addPlayer(player1);
		builder.addPlayer(player2);
		ArrayList<IPlayer> players = builder.buildPlayerList();
		assertEquals(players.size(),2);
		assertEquals(players.get(0), player1);
		
	}

}
