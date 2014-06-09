package mineplicity.hub.main;

import java.util.HashMap;

import mineplicity.hub.commands.MessageCommand;
import mineplicity.hub.commands.Reporter;
import mineplicity.hub.commands.SetSpawn;
import mineplicity.hub.commands.TimeLockCommand;
import mineplicity.hub.commands.WeatherChangeCommand;
import mineplicity.hub.listeners.DamageEvent;
import mineplicity.hub.listeners.Disabler;
import mineplicity.hub.listeners.DoubleJump;
import mineplicity.hub.listeners.PlayerDeath;
import mineplicity.hub.listeners.PlayerJoin;
import mineplicity.hub.listeners.WeatherChange;
import mineplicity.hub.news.NewsCommand;
import mineplicity.hub.news.NewsListener;
import minepow.hubapi.economy.EconomyCommands;
import minepow.hubapi.partyapi.PartyCommands;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 5/30/14
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends JavaPlugin {

    public static FileConfiguration config;

    public static HashMap<Player, Player> invites = new HashMap<Player, Player>();

    public Main plugin;

    public void onEnable() {

        config = getConfig();
        plugin = this;

        //Registering Events
        DamageEvent de = new DamageEvent();
        PlayerJoin pj = new PlayerJoin();
        PlayerDeath pd = new PlayerDeath();
        WeatherChange wc = new WeatherChange();
        Disabler d = new Disabler();
        DoubleJump dj = new DoubleJump(this);
        NewsListener nl = new NewsListener(this);


        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(de, this);
        pm.registerEvents(pj, this);
        pm.registerEvents(pd, this);
        pm.registerEvents(wc, this);
        pm.registerEvents(d, this);
        pm.registerEvents(dj, this);
        pm.registerEvents(nl, this);

        //Commands
        getCommand("money").setExecutor(new EconomyCommands());
        getCommand("party").setExecutor(new PartyCommands());
        getCommand("weatherlock").setExecutor(new WeatherChangeCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("report").setExecutor(new Reporter());
        getCommand("reports").setExecutor(new Reporter());
        getCommand("timelock").setExecutor(new TimeLockCommand());
        getCommand("addnews").setExecutor(new NewsCommand(this));

        //Printing to Console Infomation
        PluginDescriptionFile pluginFile = this.getDescription();
        getLogger().info(pluginFile.getName() + " is written by " + pluginFile.getAuthors() + " is now enabled.");
        getLogger().info(pluginFile.getName() + " version " + pluginFile.getVersion() + " is now enabled.");

        //Runnable
        BukkitRunnable timeLock = new TimeLock();
        timeLock.runTaskTimer(this, 20L, 0L);

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
