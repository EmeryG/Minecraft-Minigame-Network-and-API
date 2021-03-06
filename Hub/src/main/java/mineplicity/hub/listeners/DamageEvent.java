package mineplicity.hub.listeners;

import mineplicity.hub.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onEDE(EntityDamageEvent event) {
        //Teleports player to the spawn if they take damage from the void.
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                FileConfiguration config = Main.config;
                int x = config.getInt("Spawn.x");
                int y = config.getInt("Spawn.y");
                int z = config.getInt("Spawn.z");
                World world = Bukkit.getWorld(config.getString("Spawn.world"));

                p.teleport(new Location(world, x, y, z));
                p.setHealth(20);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
