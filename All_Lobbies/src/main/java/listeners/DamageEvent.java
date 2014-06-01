package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Ervin on 5/30/2014.
 */
public class DamageEvent implements Listener {

    @EventHandler
    public void onEDE(EntityDamageEvent event) {
        if(event instanceof Player) {
            Player p = (Player) event;
            if(event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.setCancelled(true);

            }
            event.setCancelled(true);
        }
    }
}
