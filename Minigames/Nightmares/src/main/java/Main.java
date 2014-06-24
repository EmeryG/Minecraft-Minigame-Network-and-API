import minepow.StageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 23/06/2014.
 */
public class Main extends JavaPlugin{
    public static GhostFactory ghostFactory;
    static Main main;
    @Override
    public void onEnable(){
        main = this;
        ghostFactory = new GhostFactory(main);
        StageManager.registerListener(new StatesListener());
    }

    @Override
    public void onDisable(){

    }

    public static Main getMain(){
        return main;
    }
}