import minepow.PlayingStage.MinigameMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Ali on 24/06/2014.
 */
public class GameListener implements Listener{
    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            if (((Player) e.getEntity()).getHealth() - e.getDamage() < 1) {
                if (States)
                    if (StatesListener.bodyguards.contains(e.getEntity())) {
                        StatesListener.bodyguards.remove(e.getEntity());
                        StatesListener.rebels.add((org.bukkit.entity.Player) e.getEntity());
                    } else if (StatesListener.rebels.contains(e.getEntity())) {
                        StatesListener.rebels.remove(e.getEntity());
                        StatesListener.silverfish.add((org.bukkit.entity.Player) e.getEntity());
                    }
            }
        }else{
            MinigameMain.finish(StatesListener.rebels);
        }
    }
}
