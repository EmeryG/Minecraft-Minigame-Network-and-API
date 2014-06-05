package mineplicity.hub;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import lilypad.client.connect.api.result.FutureResultListener;
import lilypad.client.connect.api.result.StatusCode;
import lilypad.client.connect.api.result.impl.RedirectResult;
import org.bukkit.ChatColor;
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

    public Main plugin;

    public void onEnable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now enabled.");
        getLogger().info(pluginFile.getName() + " version " + pluginFile.getVersion() + " is now enabled.");

        plugin = this;

        config = getConfig();
    }

    public void onDisable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now disabled.");

    }

    public Connect getBukkitConnect() {
        return (Connect) plugin.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    }

    public void redirectRequest(String server, final Player player) {
        try {
            Connect c = getBukkitConnect();
            c.request(new RedirectRequest(server, player.getName())).registerListener(new FutureResultListener<RedirectResult>() {
                public void onResult(RedirectResult redirectResult) {
                    if (redirectResult.getStatusCode() == StatusCode.SUCCESS) {
                        return;
                    }
                    player.sendMessage(ChatColor.RED + "Could not connect");
                }
            });
        } catch (Exception exception) {
            player.sendMessage(ChatColor.RED + "Could not connect");
        }
    }
}
