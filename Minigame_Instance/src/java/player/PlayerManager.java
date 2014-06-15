package player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14/06/2014.
 */
public class PlayerManager {

    public static List<PowPlayer> players = new ArrayList<PowPlayer>();

    public static void addPlayer(Player player){
        players.add(new PowPlayer(player));
    }

    public static void removePlayer(Player player){
        for(PowPlayer p : players){
            if(p.getPlayer() == player)
                players.remove(p);
        }
    }

}
