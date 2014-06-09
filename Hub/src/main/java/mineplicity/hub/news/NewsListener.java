package mineplicity.hub.news;

import java.util.ArrayList;

import me.confuser.barapi.BarAPI;
import mineplicity.hub.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class NewsListener implements Listener {

	Main plugin;
	FileConfiguration config;
	ArrayList<Player> players = new ArrayList<Player>();
	
	public NewsListener(Main plugin) {
		this.plugin = plugin;
		config = plugin.getConfig(); 
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		start(p);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(!players.contains(p)){
			start(p);
		}
	}

	public void start(final Player player) {
		players.add(player);
		int x = 1;
		final int[] num = {x};
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					if (config.getString("News." + num[0]) == null){
						num[0] = 1;
						return;
					}
					BarAPI.setMessage(player, config.getString("News." + num[0]).replace("&", "¤"),(float) num[0] / getMaxMsg() * 100);
					num[0]++;
				}
			},20 * 4, 20 * 2);

	}
	
	public int getMaxMsg(){
		for(int x = 1; x < 10 ; x++){
			if (config.getString("News." + x) == null){
				return x - 1;
			}
		}
		return 0;
	}
}
