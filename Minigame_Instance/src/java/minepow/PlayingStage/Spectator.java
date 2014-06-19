package minepow.PlayingStage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by Ervin on 6/18/2014.
 */
public class Spectator implements Listener {

    @EventHandler
    public void onPDE(EntityDamageEvent event) {
        if (event instanceof Player) {
            Player player = ((Player) event).getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
                player.sendMessage("You are a Spectator silly");
            }
        }
    }

    @EventHandler
    public void onPDIP(PlayerDropItemEvent event) {
        if (event instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
                player.sendMessage("You are a Spectator silly");
            }
        }
    }

    @EventHandler
    public void onPHE(FoodLevelChangeEvent event) {
        if (event instanceof Player) {
            Player player = ((Player) event).getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPPIE(PlayerPickupItemEvent event) {
        if (event instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
                player.sendMessage("You are a Spectator silly");
            }
        }
    }

    @EventHandler
    public void onPDE(EntityDamageByEntityEvent event) {
        if (event instanceof Player) {
            Player player = ((Player) event).getPlayer();
            Player damager = (Player) event.getDamager();
        }
    }
}
