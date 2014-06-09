package mineplicity.hub.news;

import java.util.List;

import me.confuser.barapi.BarAPI;
import mineplicity.hub.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 06/06/2014.
 */

public class NewsGUI {
    
	FileConfiguration config = Main.config;
    boolean keepGoing = true;
    private int run = 0;
    
    Main plugin;

    public NewsGUI(Main plugin){
    	this.plugin = plugin;
    }
    
    public void start(final Player player){
        final List<String> news = config.getStringList("News");
        while(keepGoing) {
            for (final String jazz : news) {
            	run = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					
					@Override
					public void run() {
						BarAPI.setMessage(player, jazz, (float) news.indexOf(jazz)/ news.size());
					}
				}, config.getInt("news.cooldown") * 20);
            }	
        }
    }

    public void stop(){
        keepGoing = false;
        Bukkit.getServer().getScheduler().cancelTask(run);
    }
}
