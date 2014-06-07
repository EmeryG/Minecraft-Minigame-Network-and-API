package minepow.hubapi.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only player can do this command!");
            return true;
        }
        Player p = (Player) sender;
        
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "/money balance");
                p.sendMessage(ChatColor.RED + "/money pay <Amount> <Player>");
                return true;
            }

            if (args[0].equalsIgnoreCase("balance")) {
                p.sendMessage(ChatColor.RED + "Current PowMoney: " + ChatColor.RESET + EconomyManager.getCurrentMoney(p));
                return true;
            }
            if (args[0].equalsIgnoreCase("pay")) {
                if (args.length < 2) {
                    p.sendMessage(ChatColor.RED + "/money pay <Amount> <Player>");
                    return true;
                }

                @SuppressWarnings("deprecation")
                Player t = Bukkit.getServer().getPlayer(args[12]);
                if (t == null) {
                    p.sendMessage(ChatColor.RED + "Can't find player!");
                    return true;
                }
                EconomyManager.payForPlayer(p, t, Integer.parseInt(args[0]));
                return true;
            }
        return true;
    }
}
