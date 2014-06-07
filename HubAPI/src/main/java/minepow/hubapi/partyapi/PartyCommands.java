package minepow.hubapi.partyapi;

import minepow.hubapi.Main;
import org.bukkit.Bukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

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
                player.sendMessage(Main.plugin.getConfig().getString("PARTY_CREATE").replaceAll("§","&"));
                return true;

            } else if (args[0].equalsIgnoreCase("disband")) {
                if(PartyManager.getParty(player) != null) {
                    PartySender.partyDisband(player);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_DISBAND").replaceAll("§","&"));
                    return true;
                } else {
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_DISBAND_ERROR").replaceAll("§","&"));
                    return false;
                }

            } else if (args[0].equalsIgnoreCase("invite")) {
                Player target = Bukkit.getPlayer(args[1]);
                OfflinePlayer party = PartyManager.getParty(player).getLeader();
                if(party != null) {
                    PartySender.partyInvite(target, party);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_INVITE").replaceAll("§","&"));
                    return true;
                }

            } else if (args[0].equalsIgnoreCase("accept")) {
                Party currentParty = PartyManager.getParty(player);
                if(currentParty == null) {
                    PartySender.partyAccept(player);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_JOIN").replaceAll("§","&"));
                    return true;
                }

            } else if (args[0].equalsIgnoreCase("leave")) {
                Party party = PartyManager.getParty(player);
                if(party != null) {
                    PartySender.partyLeave(player);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_LEAVE").replaceAll("§","&"));
                    return true;
                }

            } else if (args[0].equalsIgnoreCase("chat")) {
                OfflinePlayer leader = PartyManager.getParty(player).getLeader();
                String message = "";
                for(int i = 1; i < args.length; i++) {
                    message += args[i];
                }
                PartySender.partyChat(player, message);
                player.sendMessage(Main.plugin.getConfig().getString("PARTY_CHAT").replaceAll("§","&"));
                return true;

            } else if(args[0].equalsIgnoreCase("kick")){
                PartySender.partyKick(player);
                player.sendMessage(Main.plugin.getConfig().getString("PARTY_KICK").replaceAll("§","&"));
            } else {
                return true;
            }
        }
        return false;
    }
}