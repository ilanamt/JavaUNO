package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.Symbol;
import model.player.type.IPlayer;
import model.player.type.RealPlayer;

public class RealPlayerTest {
	
	private IPlayer player;


	@Before
	public void setUp() throws Exception {
		player = new RealPlayer("player");
		ICard c1 = new NumericCard(Color.BLUE, Symbol.EIGHT);
		ICard c2 = new NumericCard(Color.BLUE, Symbol.ONE);
		ICard c3 = new NumericCard(Color.RED, Symbol.NINE);
		ArrayList<ICard> cartas = new ArrayList<ICard>();
		cartas.add(c1);
		cartas.add(c2);
		cartas.add(c3);
		player.addToHand(cartas);
		player.removeCardFromHand(c1);
	}

	@Test
	public void testToString() {
		assertEquals(player.toString(), "Real Player: player");
	}
	
	@Test
	public void testConstructor() {
		assertFalse(player.hasSaidUNO());
	}
	
	@Test
	public void testAddToHand() {
		assertEquals(player.getHandSize(), 2);
	}
	
	@Test
	public void testHasOneCard() {
		assertFalse(player.hasOneCard());
	}
	
	@Test
	public void testGetHand() {
		ArrayList<ICard> h= player.getHand();
		assertEquals(h.size(), 2);
	}
	
	@Test
	public void testHasWon() {
		assertFalse(player.hasWon());
	}
	
	@Test
	public void testGetCardFromHand() {
		ICard r = player.getCardFromHand(0);
		ICard r2 = player.getCardFromHand(10);
		assertEquals(r2.toString(), "Sin Símbolo Sin Color");
		assertNotNull(r);
	}
	
	@Test
	public void testSetUNO() {
		assertFalse(player.hasSaidUNO());
		player.setSaidUNO(true);
		assertTrue(player.hasSaidUNO());
		player.setSaidUNO(false);
		assertFalse(player.hasSaidUNO());
	}
	
	
	


}
