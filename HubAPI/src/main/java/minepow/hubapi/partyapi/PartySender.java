package minepow.hubapi.partyapi;

import minepow.hubapi.partyapi.sockets.DataTransferListener;
import org.bukkit.OfflinePlayer;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartySender {

    static public void partyDisband(OfflinePlayer leader) {

        DataTransferListener.sendData("d=" + leader.getName());

    }

    static public void partyCreate(OfflinePlayer leader) {

        DataTransferListener.sendData("c=" + leader.getName());

    }

    static public void partyInvite(OfflinePlayer p, OfflinePlayer leader) {

        DataTransferListener.sendData("i=" + p.getName() + ";" + leader.getName());

    }

    static public void partyAccept(OfflinePlayer p) {

        DataTransferListener.sendData("a=" + p.getName());

    }

    static public void partyLeave(OfflinePlayer p) {

        DataTransferListener.sendData("l=" + p.getName());

    }


    static public void partyChat(OfflinePlayer p, String text) {

        DataTransferListener.sendData("chat=" + p.getName() + ";" + text);

    }

    static public void partyKick(OfflinePlayer p) {

        DataTransferListener.sendData("k=" + p.getName());

    }

}
