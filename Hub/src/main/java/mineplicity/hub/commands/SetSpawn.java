package mineplicity.hub.commands;

import main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 01/06/2014.
 */
public class SetSpawn implements CommandExecutor {
    public SetSpawn() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("setspawn")){
            Main main = new Main();
            FileConfiguration config = Main.config;
            Player player = (Player) sender;
            double x = player.getLocation().getBlockX();
            double y = player.getLocation().getBlockY();
            double z = player.getLocation().getBlockZ();
            String world = player.getWorld().toString();
            config.set("Spawn.x", x);
            config.set("Spawn.y", y);
            config.set("Spawn.z", z);
            config.set("Spawn.world", world);
            main.saveConfig();
        }
        return false;
    }
}
