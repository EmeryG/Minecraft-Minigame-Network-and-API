package mineplicity.hub.partyAPI;

import java.util.ArrayList;
import java.util.HashMap;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Party {

    ArrayList<Player> players = new ArrayList<Player>();
    HashMap<Player, ArrayList<Player>> party = new HashMap<Player, ArrayList<Player>>();
    Player leader;


    public Party(Player leader) {
        this.leader = leader;
        players.add(leader);
        party.put(leader, players);
    }

    public Player getLeader() {
        return leader;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public HashMap<Player, ArrayList<Player>> getAllParty() {
        return party;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void messageParty(Party party, String message) {
        for (Player t : party.getPlayers()) {
            t.sendMessage(ChatColor.YELLOW + "Leader:" + party.getLeader().getDisplayName() + " : " + message);
        }
    }

    public boolean isLeader(Player player) {
        return player == leader;
    }

}
