package mineplicity.hubapi.main.database;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Ervin on 6/1/2014.
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onPJE(PlayerJoinEvent event) {
        if (event instanceof Player) {
            Player p = event.getPlayer();
            String puuid = event.getPlayer().getUniqueId().toString();
            if () {

            }
        }
    }
}
