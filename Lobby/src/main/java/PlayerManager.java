import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Ali on 08/06/2014.
 */
public class PlayerManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new Timer(15, e.getPlayer()).runTaskTimer(Main.getMain(), 1L, 20L);
    }

}
