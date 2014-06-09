package mineplicity.hub.news;

import mineplicity.hub.main.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NewsListener implements Listener{

	Main plugin;

    public NewsListener(Main plugin){
    	this.plugin = plugin;
    }
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        NewsGUI gui = new NewsGUI(plugin);
        gui.start(player);
    }
}
