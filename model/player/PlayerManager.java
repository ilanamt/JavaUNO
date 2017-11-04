package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

/**
 * Class that manages everything that has to do with the game players
 * @author ilana
 *
 */
public class PlayerManager implements IPlayerManager {
	
	protected ArrayList<IPlayer> players;
	protected int current;
	protected int next;
	protected Direction dir;
	
	/**
	 * Class constructor
	 * @param builder Player Builder for this game
	 */
	public PlayerManager(IPlayerListBuilder builder) {
		players = builder.buildPlayerList();
		dir = Direction.COUNTERCLOCKWISE;
		current = -1;
		next = 0;
	}

	@Override
	public IPlayer getCurrentPlayer() {
		return players.get(current);		
	}
	

	@Override
	public ArrayList<IPlayer> getPlayers() {
		return players;
	}

	@Override
	public void invertDirection() {
		if(players.size() == 2) {
			this.skipPlayer();
		}
		else {
			int s = players.size();
			dir = dir.swap();
			if(dir.getValue()==-1 && current ==0) {
				this.next = s-1;
			}
			else if(s!= 0){
				this.next = (current+dir.getValue())%s;
			}
		}
		
		
	}

	@Override
	public void startTurn() {
		int s = players.size();
		this.current = this.next;
		if(dir.getValue()==-1 && this.next ==0) {
			this.next = (s-1);
		}
		else if(s!=0){
			this.next = (next + dir.getValue())%s;
		}

	}

	@Override
	public void skipPlayer() {
		int s = players.size();
		if(dir.getValue()==-1 && next ==0) {
			this.next = s-1;
		}
		else {
			this.next = (next+dir.getValue())%s;
		}
		
	}

}
