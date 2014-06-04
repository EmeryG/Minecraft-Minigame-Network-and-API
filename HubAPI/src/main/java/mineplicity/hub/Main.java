package mineplicity.hub;

import mineplicity.hub.partyAPI.PartyCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


/**
 * Created by Ervin on 6/1/2014.
 */
public class Main extends JavaPlugin {

    public static HashMap<Player, Player> invites = new HashMap<Player, Player>();
    public static FileConfiguration config;

    public void onEnable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now enabled.");
        getLogger().info(pluginFile.getName() + " version " + pluginFile.getVersion() + " is now enabled.");

        getCommand("party").setExecutor(new PartyCommand());

    }

    public void onDisable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now disabled.");

    }
}
