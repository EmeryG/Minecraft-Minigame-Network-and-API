package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Party {

    // List of Playersm leader included
    OfflinePlayer leader;
    List<OfflinePlayer> members = new ArrayList<OfflinePlayer>();

    public Party(OfflinePlayer leader){
        this.leader = leader;

        // The leader is a member, so we add to the members.
        members.add(leader);
    }

    public OfflinePlayer getLeader(){
        return leader;
    }

    public List<OfflinePlayer> getMembers(){
        return members;
    }

    public void addMembers(OfflinePlayer player){
        members.add(player);
    }

}
