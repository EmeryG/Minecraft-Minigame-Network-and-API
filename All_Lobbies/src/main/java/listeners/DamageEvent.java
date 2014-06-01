package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Ervin on 5/30/2014.
 */
public class DamageEvent implements Listener {

    @EventHandler
    public void onEDE(EntityDamageEvent event) {
        if(event instanceof Player) {
            Player p = (Player) event;
            if(event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                p.setHealth(0);
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
