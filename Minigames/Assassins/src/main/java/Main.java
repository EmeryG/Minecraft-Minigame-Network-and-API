import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 20/06/2014.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Player player = Bukkit.getPlayer("test");
        player.getVehicle().getType()
    }
    @Override
    public void onDisable(){
    }

}