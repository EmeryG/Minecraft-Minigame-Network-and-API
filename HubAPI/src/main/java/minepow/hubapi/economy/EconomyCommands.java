package minepow.hubapi.economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only player can do this command!");
            return true;
        }
        Player p = (Player) sender;

        if (args[0].equalsIgnoreCase("create")) {
            return true;
        } else if (label.equalsIgnoreCase("")) {

        }
        return false;
    }
}
