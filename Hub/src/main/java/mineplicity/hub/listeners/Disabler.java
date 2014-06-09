package mineplicity.hub.listeners;

import mineplicity.hub.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Ali on 01/06/2014.
 */
public class Disabler implements Listener {

    @EventHandler
    public void onPlayerDoAnyPvP(EntityDamageByEntityEvent e) {
        Player player = (Player) e.getDamager();
        //If attacker is OP or has mineplicity.nopvpBypass permission node, they will deal damage
        if (!player.hasPermission("bukkit.command.op") || !player.hasPermission("hub.nopvpBypass")) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.DARK_RED + "No PvP allowed");
            player.playSound(player.getLocation(), Sound.ITEM_BREAK, 10, 1);
        }
    }

    //When player tries to build
    //If they are OP or has mineplicity.nobuildBypass permission node, they will build
    @EventHandler
    public void onPlayerBuild(BlockPlaceEvent e) {
        Player player = (Player) e.getPlayer();
        if (!player.hasPermission("bukkit.command.op") || !player.hasPermission("hub.nobuildBypass")) {
            e.setCancelled(true);

            player.sendMessage(ChatColor.DARK_RED + "No building allowed!");
        }

    }

    //When player food bar change event
    @EventHandler
    public void onPlayerFoodBarChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent e) {
        if (Main.config.getBoolean("disabler.mobSpawn")) {
            if (!(e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) || e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.CUSTOM))) {
                e.setCancelled(true);
            }
        }
    }
}
