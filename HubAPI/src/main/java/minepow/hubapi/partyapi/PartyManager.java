package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class PartyManager {
    // All the parties.
    static List<Party> parties = new ArrayList<Party>();
    static Map<OfflinePlayer, OfflinePlayer> invites = new HashMap<OfflinePlayer, OfflinePlayer>();

    // Checks if the player si in the party and if they are it sends the party. Returns null otherwise.
    public static Party getParty(OfflinePlayer member) {
        for (Party party : parties) {
            if (party.getMembers().contains(member)) {
                return party;
            }
        }
        return null;
    }

    // Adds a party
    public static void addParty(OfflinePlayer leader) {
        parties.add(new Party(leader));
    }

    public static void deleteParty(Party party) {
        parties.remove(party);
    }
}
