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
<<<<<<< HEAD
                event.setCancelled(true);

=======
                p.setHealth(0);
>>>>>>> 0de56b15a121de98b38b320e931a76cdc3a7cdf7
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
