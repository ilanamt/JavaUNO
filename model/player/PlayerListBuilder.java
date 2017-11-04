package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

/**
 * Class for building player list for game
 * @author ilana
 *
 */
public class PlayerListBuilder implements IPlayerListBuilder {
	
	protected ArrayList<IPlayer> players;
	
	/**
	 * Class constructor
	 */
	public PlayerListBuilder() {
		players = new ArrayList<IPlayer>();
	}

	@Override
	public void addPlayer(IPlayer player) {
		players.add(player);

	}

	@Override
	public ArrayList<IPlayer> buildPlayerList() {
		ArrayList<IPlayer> res = players;
		players = new ArrayList<IPlayer>();
		return res;
	}

}
