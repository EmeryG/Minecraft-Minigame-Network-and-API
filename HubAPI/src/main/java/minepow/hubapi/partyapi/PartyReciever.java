package minepow.hubapi.partyapi;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

abstract public class PartyReciever {

    public static void RecieveMessage(String message) {

        if (message.startsWith("d=")) {
            message = message.substring(2);
            partyDisband(Bukkit.getOfflinePlayer(message));

        } else if (message.startsWith("c=")) {
            message = message.substring(2);
            partyCreate(Bukkit.getOfflinePlayer(message));

        } else if (message.startsWith("i=")) {
            message = message.substring(2);
            String leader = "";
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == ';') {
                    leader = message.substring(i + 1);
                }
            }
            partyInvite(Bukkit.getOfflinePlayer(message), Bukkit.getOfflinePlayer(leader));

        } else if (message.startsWith("a=")) {
            message = message.substring(2);
            partyAccept(Bukkit.getOfflinePlayer(message));

        } else if (message.startsWith("l=")) {
            message = message.substring(2);
            partyLeave(Bukkit.getOfflinePlayer(message));

        } else if (message.startsWith("chat=")) {
            message = message.substring(5);
            String chatMessage = "";
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == ';') {
                    chatMessage = message.substring(i + 1);
                }
            }
            partyChat(Bukkit.getOfflinePlayer(message), chatMessage);

        } else if (message.startsWith("k=")) {
            message = message.substring(2);
            partyKick(Bukkit.getOfflinePlayer(message));
        }
    }

    static void partyDisband(OfflinePlayer leader) {
        Party party = PartyManager.getParty(leader);
        PartyManager.deleteParty(party);
    }

    static void partyCreate(OfflinePlayer leader) {
        PartyManager.addParty(leader);
    }

    static void partyInvite(OfflinePlayer p, OfflinePlayer leader) {
        if (PartyManager.invites.containsKey(p)) {
            PartyManager.invites.remove(p);
            PartyManager.invites.put(p, leader);
        } else {
            PartyManager.invites.put(p, leader);
        }
    }

    static void partyAccept(OfflinePlayer p) {
        if (PartyManager.invites.containsKey(p)) {
            Party party = PartyManager.getParty(PartyManager.invites.get(p));
            party.addMember(p);
            PartyManager.invites.remove(p);
        }
    }

    static void partyLeave(OfflinePlayer p) {
        Party party = PartyManager.getParty(p);
        if (party != null) {
            party.deleteMember(p);
        }
    }

    static void partyChat(OfflinePlayer p, String text) {
        Party party = PartyManager.getParty(p);
        for (OfflinePlayer player : party.getMembers()) {
            if (player.isOnline()) {
                Player oPlayer = (Player) player;
                oPlayer.sendMessage(text);
            }
        }
    }

    static void partyKick(OfflinePlayer p) {
        Party party = PartyManager.getParty(p);
        party.deleteMember(p);
    }
}
