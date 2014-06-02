package mineplicity.hub.listeners;

import mineplicity.hub.main.InfinitePotionEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Ervin on 5/31/2014.
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onPJE(PlayerJoinEvent e) {
            Player p = (Player) e;
            p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.SPEED, 2));
            p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.JUMP, 2));
    }
}
