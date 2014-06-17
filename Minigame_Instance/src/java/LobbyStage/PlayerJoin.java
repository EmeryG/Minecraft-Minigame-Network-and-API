package LobbyStage;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Ali on 15/06/2014.
 */
public class PlayerJoin implements Listener{
    @EventHandler
    public void onPJE(PlayerJoinEvent e){
        if(Bukkit.getOnlinePlayers().length == 2){
            Timer timer = new Timer();
            timer.run();
        }
    }
}
