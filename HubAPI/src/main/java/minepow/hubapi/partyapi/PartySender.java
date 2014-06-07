package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartySender {

    static public void partyDisband(Party party) {

        DataTransferListener.sendData("d=" + Party.getLeader().getName());

    }

    static public void partyCreate(OfflinePlayer leader) {

        DataTransferListener.sendData("c=" + Party.getLeader().getName());

    }

    static public void partyInvite(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    static public void partyJoin(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    static public void partyAccept(OfflinePlayer p) {

        DataTransferListener.sendData("a=" + p.getName());

    }

    static public void partyLeave(OfflinePlayer p) {

        DataTransferListener.sendData("i=" + p.getName());

    }
    //DataTransferListener.sendMessage(message);

    static public void partyChat(OfflinePlayer p, Party party, String text) {

        DataTransferListener.sendData("c=" + p.getName() + " t=" + text);

    }
}
