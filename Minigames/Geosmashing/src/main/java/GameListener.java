import minepow.PlayingStage.MinigameMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ali on 23/06/2014.
 */
public class GameListener implements Listener{

    public HashMap<Location, Player> placedTNT = new HashMap<Location, Player>();

    @EventHandler
    public void onBPE(BlockPlaceEvent e){
        if(e.getBlockPlaced().equals(Material.TNT)){
            e.setCancelled(true);
            Bukkit.getWorld("world").spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
            placedTNT.put(e.getBlock().getLocation(), e.getPlayer());
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEEE(EntityExplodeEvent e){
        for(Block b : e.blockList()){
            if(b.getType().equals(Material.GOLD_BLOCK)){
                Player winner = placedTNT.get(e.getLocation());
                ArrayList<Player> winners = new ArrayList<Player>();
                winners.add(winner);
                MinigameMain.finish(winners);
                break;
            }
        }
    }

    public void onPQE(PlayerQuitEvent e){
        for(PotionEffect type : e.getPlayer().getActivePotionEffects()){
            e.getPlayer().removePotionEffect(type.getType());
        }
    }
}
