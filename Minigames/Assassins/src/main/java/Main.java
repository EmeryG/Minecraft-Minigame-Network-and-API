import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 20/06/2014.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        PluginManager pm = (PluginManager) this;
        pm.registerEvents(new GameListeners(), this);
    }
    @Override
    public void onDisable(){
    }

}