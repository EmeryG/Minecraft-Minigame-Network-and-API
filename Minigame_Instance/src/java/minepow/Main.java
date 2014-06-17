package minepow;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Ali on 14/06/2014.
 */
public class Main extends JavaPlugin{

    public static Main main;

    @Override
    public void onEnable(){
        main = this;
    }

    @Override
    public void onDisable(){
    }

}
