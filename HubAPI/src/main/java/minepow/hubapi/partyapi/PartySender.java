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

    public void partyDisband(Party party) {

        DataTransferListener.sendData("d=" + Party.getLeader().getName());

    }

<<<<<<< HEAD
    public void partyCreate(OfflinePlayer leader) {
        
=======
    public void partyCreate(OfflinePlayer party) {

        DataTransferListener.sendData("c=" + Party.getLeader().getName());

>>>>>>> ff5b8676bbbe93f936ef7508572fb2a25cc48bff
    }

    public void partyInvite(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    public void partyJoin(OfflinePlayer p, Party party) {

        DataTransferListener.sendData("i=" + p.getName() + " l=" + Party.getLeader().getName());

    }

    public void partyAccept(OfflinePlayer p) {

        DataTransferListener.sendData("a=" + p.getName());

    }

    public void partyLeave(OfflinePlayer p) {

        DataTransferListener.sendData("i=" + p.getName());

    }

<<<<<<< HEAD
    //DataTransferListener.sendMessage(message);

=======
    public void partyChat(OfflinePlayer p, Party party, String text) {

        DataTransferListener.sendData("c=" + p.getName() + " t=" + text);

    }
>>>>>>> ff5b8676bbbe93f936ef7508572fb2a25cc48bff
}
