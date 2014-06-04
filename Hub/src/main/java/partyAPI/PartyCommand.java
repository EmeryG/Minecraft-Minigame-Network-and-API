package partyAPI;

import mineplicity.hub.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor{
	
	/*
	 * This package was created by Erez!
	 */
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only player can do this command!");
			return true;
		}
		Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "/party invite <Player>");
				p.sendMessage(ChatColor.RED + "/party kick <Player>");
				p.sendMessage(ChatColor.RED + "/party accept");
				p.sendMessage(ChatColor.RED + "/party leave");
				p.sendMessage(ChatColor.RED + "/party disband");
				return true;
			}

			if (args[0].equalsIgnoreCase("invite")) {
				if(args.length == 1){
					p.sendMessage(ChatColor.RED + "/party invite <Player>");
					return true;
				}
				Party party = PartyManager.getParty(p);
				if (party == null) {
					PartyManager.addParty(p);
					party = PartyManager.getParty(p);
				}
					if (party.isLeader(p)) {
						Player t = Bukkit.getServer().getPlayer(args[1]);
						if(t == null){
							p.sendMessage(ChatColor.RED + "Cant find player!");
							return true;
						}
						if(p == t){
							p.sendMessage(ChatColor.RED + "You cant invite yourself.");
							return true;
						}
						Main.invites.put(t, p);
						t.sendMessage(p.getDisplayName() + ChatColor.GREEN  + " Sent you a party request!. To join type /party accept");
						p.sendMessage(ChatColor.GREEN + "You invited " + ChatColor.RESET + t.getDisplayName());
						return true;
					}
					p.sendMessage(ChatColor.RED + "You cant do that!");
				return true;
			}
			if (args[0].equalsIgnoreCase("kick")) {
				if(args.length == 1){
					p.sendMessage(ChatColor.RED + "/party kick <Player>");
					return true;
				}
				Party party = PartyManager.getParty(p);
				if (party != null) {
					if (party.isLeader(p)) {
						Player t = Bukkit.getServer().getPlayer(args[1]);
						PartyManager.getParty(p).removePlayer(t);
					}
					p.sendMessage(ChatColor.RED + "You cant do that!");
					return true;
				}
				p.sendMessage(ChatColor.RED + "You are not in a party!");
				return true;
			}
			if (args[0].equalsIgnoreCase("accept")) {
				Party party = PartyManager.getParty(p);
				if (party == null) {
					if(Main.invites.get(p) != null){
						party = PartyManager.getParty(Main.invites.get(p));
						party.addPlayer(p);
						p.sendMessage(ChatColor.GREEN  + "You just joined " + Main.invites.get(p).getDisplayName() + "'s party");
						Main.invites.get(p).sendMessage(p.getDisplayName() + ChatColor.GREEN + " Joined your party!");
						Main.invites.remove(p);
						return true;
					}
					p.sendMessage(ChatColor.RED + "No one invited you to the party... :(");
					return true;
				}
				p.sendMessage(ChatColor.RED + "You are already in a party!");
				return true;
			}
			if (args[0].equalsIgnoreCase("leave")) {
				Party party = PartyManager.getParty(p);
				if (party != null) {
					party.removePlayer(p);
					p.sendMessage(ChatColor.RED + "You left the party!");
					return true;
				}
				p.sendMessage(ChatColor.RED + "You are not in a party!");
				return true;
			}
			if (args[0].equalsIgnoreCase("disband")) {
				Party party = PartyManager.getParty(p);
				if (party != null) {
					if (party.isLeader(p)) {
						PartyManager.disbandParty(party);
					}
					p.sendMessage(ChatColor.RED + "You cant do that!");
					return true;
				}
				p.sendMessage(ChatColor.RED + "You are not in a party!");
				return true;
			}
			if(args[0].equalsIgnoreCase("info")){
				Party party = PartyManager.getParty(p);
				if (party != null) {
					p.sendMessage(ChatColor.AQUA + "----------- Party -----------");
					for(Player t : party.getPlayers()){
						if(party.isLeader(t)){
							p.sendMessage(ChatColor.YELLOW + "Leader: " + t.getDisplayName());
						}else{
							p.sendMessage(t.getDisplayName());
						}
					}
					return true;
				}
				p.sendMessage(ChatColor.RED + "You are not in a party!");
				return true;
			}
		return true;
	}

}
