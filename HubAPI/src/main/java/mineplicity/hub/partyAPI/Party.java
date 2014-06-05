package mineplicity.hub.partyAPI;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class Party {

	ArrayList<Player> players = new ArrayList<Player>();
	HashMap<Player,ArrayList<Player>> party = new HashMap<Player, ArrayList<Player>>();
	Player leader;
	
	public Party(Player leader){
		this.leader = leader;
		players.add(leader);
		party.put(leader, players);
	}
	
	public Player getLeader(){
		return leader;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public HashMap<Player,ArrayList<Player>> getAllParty(){
		return party;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void removePlayer(Player player){
		players.remove(player);
	}
	
	public boolean isLeader(Player player){
		return player == leader;
	}
	
}
