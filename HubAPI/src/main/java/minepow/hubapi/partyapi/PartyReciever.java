package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartyReciever {

    public static void RecieveMessage(String message){
        if(message.startsWith("d=")) {
            if(message.remov
        } else if(message.startsWith("c=")) {

        } else if(message.startsWith("i=")) {

        } else if(message.startsWith("j=")) {

        } else if(message.startsWith("a=")) {

        } else if(message.startsWith("l=")) {

        } else if(message.startsWith("chat=")) {

        }
    }

    void partyDisband(OfflinePlayer leader) {

    }

    void partyCreate(OfflinePlayer leader) {

    }

    void partyInvite(OfflinePlayer p, OfflinePlayer leader) {

    }

    void partyJoin(OfflinePlayer p, OfflinePlayer leader) {

    }

    void partyAccept(OfflinePlayer p) {

    }

    void partyLeave(OfflinePlayer p) {

    }

    void partyChat(OfflinePlayer p, OfflinePlayer leader, String text) {

    }
}
