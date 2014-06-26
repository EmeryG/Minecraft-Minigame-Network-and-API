package minepow;

import lombok.Getter;
import minepow.LobbyStage.LobbyTimer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 14/06/2014.
 */
public class Main extends JavaPlugin{

    @Getter
    static Main main;

    @Override
    public void onEnable(){
        main = this;
        StageManager.toLobby();
        LobbyTimer timer = new LobbyTimer();
        timer.runTaskTimer(this, 0L, 20L);
        this.getServer().getPluginManager().registerEvents(timer, this);
    }

    @Override
    public void onDisable(){ }

    public static FileConfiguration getMainConfig() {
        return main.getConfig();
    }

    public static void saveMainConfig() {
        main.getConfig();
    }

    public static void reloadMainConfig() {
        main.reloadConfig();
    }

    public static boolean contains(String thing) {
        try {
            main.getConfig().get(thing);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Main getMain(){
        return main;
    }
}
