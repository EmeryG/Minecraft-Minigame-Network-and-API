package minepow.PlayingStage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by Ervin on 6/18/2014.
 */
public class Spectator implements Listener {

    @EventHandler
    public void onPDE(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event).getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPDIP(PlayerDropItemEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPHE(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event).getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPPIE(PlayerPickupItemEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPDE(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            if (MinigameMain.getSpecators().contains(damager)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPIE(PlayerInteractEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPBE(BlockBreakEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPPE(BlockPlaceEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = event.getPlayer();
            if (MinigameMain.getSpecators().contains(player)) {
                event.setCancelled(true);
            }
        }
    }
}
