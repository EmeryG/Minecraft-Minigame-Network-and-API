package mineplicity.hub.main;

import commands.*;

import listeners.DamageEvent;
import listeners.PlayerHunger;

import mineplicity.hub.listeners.DamageEvent;
import mineplicity.hub.listeners.PlayerHunger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 5/30/14
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JavaPlugin {

    public static FileConfiguration config;

    public void onEnable() {

        config = getConfig();

        //Registering Events
        DamageEvent de = new DamageEvent();
        PlayerHunger ph = new PlayerHunger();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(de, this);
        pm.registerEvents(ph, this);

        //Commands
        getCommand("weatherlock").setExecutor(new WeatherChangeCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("report").setExecutor(new Reporter());
        getCommand("reports").setExecutor(new Reporter());
        getCommand("timelock").setExecutor(new TimeLockCommand());

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now enabled.");
        getLogger().info(pluginFile.getName() + " version " + pluginFile.getVersion() + " is now enabled.");

    }

    public void onDisable() {

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is now disabled.");

    }

    public void remoteSaveConfig() {

        saveConfig();

    }
}
