import minepow.StageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 23/06/2014.
 */
public class Main extends JavaPlugin{

    @Override
    public void onEnable(){
        StageManager.registerListener(new StatesListener());
    }

    public void onDisable(){

    }
}
