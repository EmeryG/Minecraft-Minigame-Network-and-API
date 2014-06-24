import minepow.PlayingStage.MinigameMain;
import minepow.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Ali on 23/06/2014.
 */
public class GameListeners implements Listener{

    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            if (((Player) e.getEntity()).getHealth() - e.getDamage() < 1) {
                if (StatesListener.sleepers.contains(e.getEntity())) {
                    StatesListener.addNightmare((Player) e.getEntity());
                }
                e.setCancelled(true);
                ((Player) e.getEntity()).setHealth(15);
                MinigameMain.spawnPlayerRandomly((Player) e.getEntity(), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));
            }
        }
    }
}
