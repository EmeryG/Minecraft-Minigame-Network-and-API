package mineplicity.hub.commands;

import mineplicity.hub.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 01/06/2014.
 */
public class SetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("setspawn")) {
            if (sender.hasPermission("hub.setspawn")) {
                Main main = new Main();
                Player player = (Player) sender;
                double x = player.getLocation().getBlockX();
                double y = player.getLocation().getBlockY();
                double z = player.getLocation().getBlockZ();
                String world = player.getWorld().toString();
                Main.config.set("Spawn.x", x);
                Main.config.set("Spawn.y", y);
                Main.config.set("Spawn.z", z);
                Main.config.set("Spawn.world", world);
                main.remoteSaveConfig();
            }
        }
        return false;
    }
}
