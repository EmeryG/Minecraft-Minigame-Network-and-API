import minepow.StageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 24/06/2014.
 */
public class Main extends JavaPlugin{

    static Main main;

    @Override
    public void onEnable(){
        StageManager.registerListener(new StatesListener());
    }

    @Override
    public void onDisable(){
    }

    public static Main getMain(){
        return main;
    }
}
