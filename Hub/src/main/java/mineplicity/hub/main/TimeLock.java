package mineplicity.hub.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeLock extends BukkitRunnable {

    @Override
    public void run() {
        World world = Bukkit.getWorld(Main.config.getString("Spawn.world"));
        world.setTime(Main.config.getLong("TimeLock.lockedTime"));
    }
}
