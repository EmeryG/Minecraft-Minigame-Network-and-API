import minepow.PlayingStage.MinigameMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;

/**
 * Created by Ali on 25/06/2014.
 */
public class GameListener implements Listener {

    @EventHandler
    public void onBPE(BlockPlaceEvent e){
        if(e.getBlockPlaced().equals(Material.TNT)){
            e.setCancelled(true);
            Bukkit.getWorld("world").spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEEE(EntityExplodeEvent e){
        for(Block b : e.blockList()){
            if(b.getType().equals(Material.CHEST)){
                b.breakNaturally();
                break;
            }
        }
    }

    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            if (((Player) e.getEntity()).getHealth() - e.getDamage() < 1) {
                MinigameMain.setSpecator((Player) e.getEntity());
            }if(MinigameMain.getSpecators().size() - Bukkit.getOnlinePlayers().length == 1){
                for(Player p :Bukkit.getOnlinePlayers()){
                    if(!MinigameMain.getSpecators().contains(p)){
                        ArrayList<Player> winner = new ArrayList<Player>();
                        winner.add(p);
                        MinigameMain.finish(winner);
                    }
                }
            }
        }
    }

}
