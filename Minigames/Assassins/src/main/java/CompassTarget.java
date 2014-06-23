import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Ali on 23/06/2014.
 */
public class CompassTarget extends BukkitRunnable{
    @Override
    public void run() {
        Set<Player> players = Targeting.targetList.keySet();
        for(Player p : players){
            if(p.getItemInHand().getType() == Material.COMPASS){
                p.setCompassTarget(Targeting.targetList.get(p).getLocation());
            }
        }
    }
}
