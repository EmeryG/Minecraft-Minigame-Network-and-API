package spectator;

import org.bukkit.entity.Player;

/**
 * Created by Ali on 14/06/2014.
 */
public class Spectator {

    Player player;

    public Spectator(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

}
