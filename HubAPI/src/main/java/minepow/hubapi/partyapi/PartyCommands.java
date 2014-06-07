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
                PartySender.partyCreate(player);
                return true;
            } else if (args[0].equalsIgnoreCase("disband")) {
                if(PartyManager.getParty(player) != null) {
                    PartySender.partyDisband(PartyManager.getParty(player));
                    return true;
                } else {
                    return false;
                }
            } else if (args[0].equalsIgnoreCase("invite")) {
                Player target = Bukkit.getPlayer(args[1]);
                Party party = PartyManager.getParty(player);
                if(party != null) {
                    PartySender.partyInvite(target, party);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("join")) {
                Party currentParty = PartyManager.getParty(player);
                Party targetParty = invites.get(player);
                if(currentParty == null) {
                    PartySender.partyJoin(player, targetParty);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("leave")) {
                Party party = PartyManager.getParty(player);
                if(party != null) {
                    PartySender.partyLeave(player);
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("chat")) {
                PartySender.partyChat();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }
}