import minepow.PlayingStage.Util;
import minepow.config.Config;
import minepow.listeners.States;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Ali on 23/06/2014.
 */
public class NetherStarDropper extends BukkitRunnable {
    @Override
    public void run() {
        Util.dropItemRandonmly(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2), new ItemStack(Material.NETHER_STAR));
    }
}
