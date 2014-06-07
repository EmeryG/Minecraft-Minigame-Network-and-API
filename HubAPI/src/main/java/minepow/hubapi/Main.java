package minepow.hubapi;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import lilypad.client.connect.api.result.FutureResultListener;
import lilypad.client.connect.api.result.StatusCode;
import lilypad.client.connect.api.result.impl.RedirectResult;
import minepow.hubapi.partyapi.sockets.ServerConnections;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;


/**
 * Created by Ervin on 6/1/2014.
 */
public class Main extends JavaPlugin {

    public static Plugin plugin;

    public void onDisable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now disabled.");

    }

    public void onEnable() {

        new ServerConnections().start();

        //Printing to Console Information
        plugin = this;
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now enabled.");
        getLogger().info(pluginFile.getName() + " version " + pluginFile.getVersion() + " is now enabled.");

    }

    public Connect getConnect() {
        return (Connect) Bukkit.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    }

    public void redirectRequest(String server, final Player player) {
        try {
            Connect c = getConnect();
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
