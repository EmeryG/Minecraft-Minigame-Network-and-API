package mineplicity.hub.news;

import java.util.List;

import me.confuser.barapi.BarAPI;
import mineplicity.hub.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class NewsGUI {

    boolean keepGoing = true;
    private int run = 0;

    Main plugin;

    public NewsGUI(Main plugin) {
        this.plugin = plugin;
    }

    public void start(final Player player) {
        final List<String> news = Main.config.getStringList("News");
        if (news == null) return;
        while (keepGoing) {
            for (final String jazz : news) {
                run = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        BarAPI.setMessage(player, jazz, (float) news.indexOf(jazz) / news.size());
                    }
                }, 8 * 20);
            }
        }
    }

    public void stop() {
        keepGoing = false;
        Bukkit.getServer().getScheduler().cancelTask(run);
    }
}
