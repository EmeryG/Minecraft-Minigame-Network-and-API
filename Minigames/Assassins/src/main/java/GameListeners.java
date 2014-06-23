import minepow.PlayingStage.MinigameMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Ali on 22/06/2014.
 */
public class GameListeners implements Listener{

    @EventHandler
    //Handles Assassinating
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(checkPlayerSaftey(e.getEntity()) && e.getDamager() instanceof Player) {
            if (e.getEntity().getUniqueId() == Targeting.targetList.get(e.getDamager().getUniqueId())) {
                Player player = (Player) e.getDamager();
                e.setCancelled(true);
                if (player.getInventory().getItemInHand() == new ItemStack(Material.GOLD_SWORD)) {
                    player.getInventory().getItemInHand().setDurability((short) 0);
                    e.setDamage(10);
                } else {
                    e.setDamage(5);
                }
            }
        }
    }

    private boolean checkPlayerSaftey(Entity entity) {
        int i = 0;
        for(Player p : Bukkit.getOnlinePlayers()){
            if(entity.getLocation().distance(p.getLocation()) <= 3){
                i++;
            }
        }
        return i >= 2;
    }

    @EventHandler
    public void onPDE(PlayerDeathEvent e){
        MinigameMain.setSpecator(e.getEntity());
        UUID newTarget = Targeting.targetList.get(e.getEntity().getUniqueId());
        Targeting.targetList.replace(e.getEntity().getKiller().getUniqueId(), newTarget);

        int alivePlayers = Bukkit.getOnlinePlayers().length - MinigameMain.getSpecators().size();
        if(alivePlayers == 1){
            ArrayList<Player> winner = new ArrayList<Player>();
            for(Player p : Bukkit.getOnlinePlayers()){
                if(!MinigameMain.getSpecators().contains(p)){
                    winner.add(p);
                    break;
                }
            }
        }
    }
}
