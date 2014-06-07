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
                PartySender.partyInvite();
                return true;
            } else if (args[0].equalsIgnoreCase("join")) {
                PartySender.partyJoin();
                return true;
            } else if (args[0].equalsIgnoreCase("leave")) {
                PartySender.partyLeave();
                return true;
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