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
        dropNetherStar(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));
    }

    private void dropNetherStar(Location borderPoint1, Location borderPoint2){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneYGreater = borderPoint1.getBlockY() > borderPoint2.getBlockY();

        Location tp = new Location(borderPoint1.getWorld(), 0, 100, 0);
        Random r = new Random();

        if(isOneXGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
        }

        if(isOneYGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockY() - borderPoint2.getBlockY()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockY() - borderPoint1.getBlockY()));
        }

        borderPoint1.getWorld().strikeLightning(tp);

        borderPoint1.getWorld().dropItemNaturally(tp, new ItemStack(Material.NETHER_STAR));

    }
}
