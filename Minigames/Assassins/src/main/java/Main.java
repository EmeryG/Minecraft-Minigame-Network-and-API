import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 20/06/2014.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Manager.start();
    }
    @Override
    public void onDisable(){
    }

}