package mineplicity.hub.news;

import me.confuser.barapi.BarAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Ali on 06/06/2014.
 */
public class NewsListener implements Listener{

    public void onPJE(PlayerJoinEvent e){
        Player player = e.getPlayer();
        NewsGUI gui = new NewsGUI();
        gui.start(player);
    }
}
