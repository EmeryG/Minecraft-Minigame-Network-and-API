package mineplicity.hub.listeners;

import mineplicity.hub.main.InfinitePotionEffect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPRE(PlayerRespawnEvent e) {

        //When a player respawns, adds potion effects
        Player p = (Player) e;
        p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.SPEED, 2));
        p.addPotionEffect(new InfinitePotionEffect(PotionEffectType.JUMP, 2));
    }
}
