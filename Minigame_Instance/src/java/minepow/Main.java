package minepow;

import lombok.Getter;
import minepow.LobbyStage.LobbyTimer;
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
        LobbyTimer timer = new LobbyTimer();
        timer.runTaskTimer(this, 0L, 20L);
        this.getServer().getPluginManager().registerEvents(timer, this);
    }

    @Override
    public void onDisable(){ }

}
