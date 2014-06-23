import minepow.StageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 20/06/2014.
 */
public class Main extends JavaPlugin {

    static Main main;

    @Override
    public void onEnable(){
        StageManager.registerListener(new StatesListener());
        main = this;
    }
    @Override
    public void onDisable(){
    }

    public static Main getMain(){
        return main;
    }

}