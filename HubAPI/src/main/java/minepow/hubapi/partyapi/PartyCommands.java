package minepow.hubapi.partyapi;

import org.bukkit.Bukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.event.Listener;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */

public class PartyCommands implements CommandExecutor {

    public Map<Player, Party> invites = new HashMap<Player, Party>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("party") || label.equalsIgnoreCase("p")) {

            Player player = (Player) sender;

            if (args[0].equalsIgnoreCase("create")) {
                Party party = new Party(player);
            } else if (args[0].equalsIgnoreCase("disband")) {
                Party party = PartyManager.getParty(player);
                PartyManager.deleteParty(party);
            } else if (args[0].equalsIgnoreCase("invite")) {
                Player target = Bukkit.getPlayer(args[1]);
                invites.put(target, PartyManager.getParty(player));
            } else if (args[0].equalsIgnoreCase("join")) {
                Party party = invites.get(player);
                party.addMember(player);
                invites.remove(player);
            } else if (args[0].equalsIgnoreCase("leave")) {
                Party party = PartyManager.getParty(player);
                party.deleteMember(player);
            }
        }
        return false;
    }
}