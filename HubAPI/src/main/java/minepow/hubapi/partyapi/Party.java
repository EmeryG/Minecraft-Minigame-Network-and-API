package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class Party {

    // List of Players leader included
    static OfflinePlayer leader;
    static List<OfflinePlayer> members = new ArrayList<OfflinePlayer>();

    public Party(OfflinePlayer leader) {
        this.leader = leader;
        // The leader is a member, so we add to the members.
        this.addMember(leader);
    }

    public static OfflinePlayer getLeader() {
        return leader;
    }

    public static List<OfflinePlayer> getMembers() {
        return members;
    }

    public static void addMember(OfflinePlayer player) {
        members.add(player);
    }

    public void deleteMember(OfflinePlayer player) {
        members.remove(player);
    }
}
