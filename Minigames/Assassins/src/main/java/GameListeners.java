import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Ali on 22/06/2014.
 */
public class GameListeners implements Listener{

    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity().getUniqueId() == Targeting.targetList.get(e.getDamager().getUniqueId()) && e.getDamager() instanceof Player){
            Player player = (Player) e.getDamager();
            e.setCancelled(true);
            if(player.getInventory().getItemInHand() == new ItemStack(Material.GOLD_SWORD)){
                player.getInventory().getItemInHand().setDurability((short)0);
                e.setDamage(10);
            }else{
                e.setDamage(5);
            }
        }
    }

    @EventHandler
    public void onPDE(PlayerDeathEvent e){

    }
}
