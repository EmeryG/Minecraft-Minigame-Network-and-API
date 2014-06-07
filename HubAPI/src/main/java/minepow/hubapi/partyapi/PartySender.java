package minepow.hubapi.partyapi;

import lilypad.client.connect.api.request.impl.MessageRequest;
import minepow.hubapi.Main;
import org.bukkit.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartySender {

    public void partyDisband(Party party) {

        /* String partyName = party.getLeader().toString();

        MessageRequest r = new MessageRequest(, "PartyAPI", partyName);
        Main.getBukkitConnect().request(r); */
    }

    public void partyCreate(Party party) {

    }

    public void partyInvite(Player p, Party party) {

    }

    public void partyJoin(Player p, Party party) {

    }

    public void partyLeave(Player p, Party party) {

    }

    public void partyChat() {

    }
}
