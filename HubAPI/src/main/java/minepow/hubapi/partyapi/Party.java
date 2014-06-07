package minepow.hubapi.partyapi;

import org.bukkit.entity.Player;

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

    public Player leader;
    public List<Player> members = new ArrayList<Player>();

    public Party(Player leader){
        this.leader = leader;
    }

    public Player getLeader(){
        return leader;
    }

    public List<Player> getMembers(){
        return members;
    }

    public void addMembers(Player player){
        members.add(player);
    }

}
