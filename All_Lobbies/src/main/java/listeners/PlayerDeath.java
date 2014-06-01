package listeners;

import main.InfinitePotionEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Ervin on 5/31/2014.
 */
public class PlayerDeath implements Listener {

    @EventHandler
    public void onPDE(PlayerDeathEvent e) {
        if (e instanceof Player) {
            Player p = (Player) e;
            p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.SPEED, 2));
            p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.JUMP, 2));
        }
    }
}
