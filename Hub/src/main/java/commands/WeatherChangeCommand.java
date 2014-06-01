package commands;

import main.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 01/06/2014.
 */
public class WeatherChangeCommand implements CommandExecutor {

    FileConfiguration config = Main.config;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        Player player = (Player) sender;
        Main main = new Main();
        World world = player.getWorld();
        if (cmdLabel.equalsIgnoreCase("weatherlock")
                || cmdLabel.equalsIgnoreCase("wl")) {
            if (args.length < 1 || args.length > 2) {
                player.sendMessage("Invalid arguments. Either /wl <disabe/enable> or /wl set <sun/rain>");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.GREEN + "WeatherLock has been disabled");
                    config.set("WeatherLock.enabled", false);
                    main.remoteSaveConfig();
                } else if (args[0].equalsIgnoreCase("enable")) {
                    player.sendMessage(ChatColor.GREEN + "WeatherLock has been enabled");
                    config.set("WeatherLock.enabled", true);
                    main.remoteSaveConfig();
                }

            } else if (args.length == 2) {
                if (args[0].toString().equalsIgnoreCase("set")) {
                    //The player only entered the weather so we default to players current world
                    System.out.println("Set works");
                    if (args[1].equals("sun")) {
                        setWeather("sun", world);

                    } else if (args[1].equals("rain")) {
                        setWeather("rain", world);

                    } else {
                        player.sendMessage("Invalid weather type");
                    }
                }
            }
        }
        return false;
    }

    private void setWeather(String string, World world) {
        //Gets config before it is altered
        boolean oldEnabled = config.getBoolean("WeatherLock.enabled");
        //Disables the listener so it doesnt cancel the weather change
        config.set("WeatherLock.enabled", false);
        if (string.equals("sun")) {
            world.setStorm(false);

        } else if (string.equals("rain")) {
            world.setStorm(true);

        }
        //Resets the config to the way it was
        config.set("WeatherLock.enabled", oldEnabled);
    }
}
