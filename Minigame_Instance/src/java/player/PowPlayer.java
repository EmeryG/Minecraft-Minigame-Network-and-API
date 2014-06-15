package player;

import org.bukkit.entity.Player;

/**
 * Created by Ali on 14/06/2014.
 */
public class PowPlayer {

    Player player;

    public PowPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

}
