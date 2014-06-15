package listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import player.PlayerManager;
import spectator.Spectator;
import spectator.SpectatorManager;

/**
 * Created by Ali on 14/06/2014.
 */
public class PlayerDeath implements Listener{

    public void onPDE(PlayerDeathEvent e){
        //Do spectator stuff
        PlayerManager.removePlayer(e.getEntity());
        SpectatorManager.removeSpectator(e.getEntity());
    }

}
