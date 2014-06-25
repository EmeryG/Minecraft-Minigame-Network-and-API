import minepow.PlayingStage.MinigameMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;

/**
 * Created by Ali on 24/06/2014.
 */
public class GameListener implements Listener{
    @EventHandler
    public void onEDBEE(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            if (((Player) e.getEntity()).getHealth() - e.getDamage() < 1) {
                if (StatesListener.bodyguards.size() > 0 && StatesListener.rebels.size() > 0) {
                    if (StatesListener.bodyguards.contains(e.getEntity())) {
                        StatesListener.bodyguards.remove(e.getEntity());
                        StatesListener.rebels.add((org.bukkit.entity.Player) e.getEntity());
                    } else if (StatesListener.rebels.contains(e.getEntity())) {
                        StatesListener.rebels.remove(e.getEntity());
                        StatesListener.silverfish.add((org.bukkit.entity.Player) e.getEntity());
                    }
                }else{
                    if(StatesListener.bodyguards.size() < 1){
                        ArrayList<Player> players = StatesListener.rebels;
                        players.addAll(StatesListener.silverfish);
                        MinigameMain.finish(players);
                    }else if(StatesListener.rebels.size() < 1){
                        MinigameMain.finish(StatesListener.bodyguards);
                    }
                }
            }
        }else{
            if(e.getEntity().isDead()) {
                ArrayList<Player> players = StatesListener.rebels;
                players.addAll(StatesListener.silverfish);
                MinigameMain.finish(players);
            }
        }
    }
}
