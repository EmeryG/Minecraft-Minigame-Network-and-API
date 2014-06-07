package mineplicity.hub.news;

import me.confuser.barapi.BarAPI;
import mineplicity.hub.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Ali on 06/06/2014.
 */
public class NewsGUI {
    FileConfiguration config = Main.config;
    boolean keepGoing = true;
    public void start(Player player){
        List<String> news = config.getStringList("News");
        while(keepGoing) {
            for (String jazz : news) {
                BarAPI.setMessage(player, jazz);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void stop(){
        keepGoing = false;
    }
}
