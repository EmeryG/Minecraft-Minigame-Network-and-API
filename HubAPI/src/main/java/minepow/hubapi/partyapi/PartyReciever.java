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


    }

    void partyDisband(OfflinePlayer leader) {



    }

    void partyCreate(OfflinePlayer leader) {

        DataTransferListener.sendData("c=" + Party.getLeader().getName());

    }

    void partyInvite(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    void partyJoin(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    void partyAccept(OfflinePlayer p) {

        DataTransferListener.sendData("a=" + p.getName());

    }

    void partyLeave(OfflinePlayer p) {

        DataTransferListener.sendData("i=" + p.getName());

    }

    void partyChat(OfflinePlayer p, Party party, String text) {

        DataTransferListener.sendData("c=" + p.getName() + " t=" + text);

    }
}
