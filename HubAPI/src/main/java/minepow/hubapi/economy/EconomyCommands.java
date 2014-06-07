package minepow.hubapi.economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only player can do this command!");
			return true;
		}
		Player p = (Player) sender;
		
		p.sendMessage(ChatColor.RED + "Current PowMoney: " + ChatColor.RESET + EconomyManager.getCurrentMoney(p));
		
		return true;
	}

}
