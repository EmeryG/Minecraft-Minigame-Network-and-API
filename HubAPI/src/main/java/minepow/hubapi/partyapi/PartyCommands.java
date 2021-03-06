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

public class PartyCommands implements CommandExecutor {

    public Map<Player, Party> invites = new HashMap<Player, Party>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("party") || label.equalsIgnoreCase("p")) {

            Player player = (Player) sender;

            switch (args[0].toLowerCase()) {
                case "create":
                    PartySender.partyCreate(player);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_CREATE").replaceAll("§", "&"));
                    break;
                case "disband":
                    if (PartyManager.getParty(player) != null) {
                        PartySender.partyDisband(player);
                        player.sendMessage(Main.plugin.getConfig().getString("PARTY_DISBAND").replaceAll("§", "&"));
                        return true;
                    } else {
                        player.sendMessage(Main.plugin.getConfig().getString("PARTY_DISBAND_ERROR").replaceAll("§", "&"));
                    }
                    break;
                case "invite":
                    Player target = Bukkit.getPlayer(args[1]);
                    OfflinePlayer party = PartyManager.getParty(player).getLeader();
                    if (party != null) {
                        PartySender.partyInvite(target, party);
                        player.sendMessage(Main.plugin.getConfig().getString("PARTY_INVITE").replaceAll("§", "&"));
                        return true;
                    }
                    break;
                case "accept":
                    Party currentParty = PartyManager.getParty(player);
                    if (currentParty == null) {
                        PartySender.partyAccept(player);
                        player.sendMessage(Main.plugin.getConfig().getString("PARTY_JOIN").replaceAll("§", "&"));
                        return true;
                    }
                    break;
                case "leave":
                    Party partyleave = PartyManager.getParty(player);
                    if (partyleave != null) {
                        PartySender.partyLeave(player);
                        player.sendMessage(Main.plugin.getConfig().getString("PARTY_LEAVE").replaceAll("§", "&"));
                        return true;
                    }
                    break;
                case "chat":
                    OfflinePlayer leader = PartyManager.getParty(player).getLeader();
                    String message = "";
                    for (int i = 1; i < args.length; i++) {
                        message += args[i];
                    }
                    PartySender.partyChat(player, message);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_CHAT").replaceAll("§", "&"));
                    break;
                case "kick":
                    PartySender.partyKick(player);
                    player.sendMessage(Main.plugin.getConfig().getString("PARTY_KICK").replaceAll("§", "&"));
            }
        }
        return true;
    }
}