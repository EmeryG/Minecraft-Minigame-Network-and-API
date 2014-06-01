package mineplicity.hub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Ervin on 5/30/2014.
 */
public class PlayerHunger implements Listener {

    @EventHandler
    public void onPLH(FoodLevelChangeEvent event) {
        if (event instanceof Player) {
            Player p = (Player) event;
            event.setCancelled(true);
            p.setFoodLevel(20);
            p.setHealth(20);
        }
    }

}
