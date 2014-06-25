import minepow.PlayingStage.MinigameMain;
import minepow.PlayingStage.Util;
import minepow.config.Config;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Ali on 23/06/2014.
 */
public class GameListeners implements Listener{

    int netherStarsPickedUp = 0;

    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            if (((Player) e.getEntity()).getHealth() - e.getDamage() < 1) {
                if (StatesListener.sleepers.contains(e.getEntity())) {
                    StatesListener.addNightmare((Player) e.getEntity());
                }
                if(StatesListener.sleepers.size() < 1){
                    MinigameMain.finish(StatesListener.nightmares);
                }
                e.setCancelled(true);
                ((Player) e.getEntity()).setHealth(15);
                Util.spawnPlayerRandomly((Player) e.getEntity(), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));
            }
        }
    }

    @EventHandler
    public void onPPIE(PlayerPickupItemEvent e){
        if(StatesListener.sleepers.contains(e.getPlayer())){
            if(e.getItem().getItemStack().getType() != Material.NETHER_STAR) {
                e.setCancelled(true);

                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.getByName(e.getItem().getItemStack().getItemMeta().getLore().get(0)), Config.getConfig().getInt(e.getItem().getItemStack().getItemMeta().getLore().get(1) + ".duration"), Config.getConfig().getInt(e.getItem().getItemStack().getItemMeta().getLore().get(1) + ".amplifier")));

                e.getItem().setItemStack(new ItemStack(Material.AIR));
            }else{
                netherStarsPickedUp++;
                if(netherStarsPickedUp == Config.getConfig().getInt("netherStarsToWin")){
                    MinigameMain.finish(StatesListener.sleepers);
                }
            }
        }
    }
}
