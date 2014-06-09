package mineplicity.hub.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Ali on 01/06/2014.
 */
public class TimeLock extends BukkitRunnable {

    @Override
    public void run() {
        World world = Bukkit.getWorld(Main.config.getString("Spawn.world"));
        world.setTime(Main.config.getLong("TimeLock.lockedTime"));
    }
}
