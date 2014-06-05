package mineplicity.hub.partyAPI;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class PartyManager {

	private static ArrayList<Party> partys = new ArrayList<Party>();
	
	public static void addParty(Player leader){
		Party party = new Party(leader);
		partys.add(party);
	}
	
	public static void deleteParty(Party party){
		partys.remove(party);
		for(Player p : party.getPlayers()){
			party.removePlayer(p);
		}
	}
	
	public static Party getParty(Player player){
		for(Party p : partys){
			if(p.getPlayers().contains(player)) return p;
		}
		return null;
	}
	
	public static void disbandParty(Party party){
		deleteParty(party);
	}
	
}
