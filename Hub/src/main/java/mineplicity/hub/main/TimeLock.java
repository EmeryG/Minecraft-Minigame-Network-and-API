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
        FileConfiguration config = Main.config;
        World world = Bukkit.getWorld("world");
        world.setTime(config.getLong("TimeLock.lockedTime"));
    }
}
