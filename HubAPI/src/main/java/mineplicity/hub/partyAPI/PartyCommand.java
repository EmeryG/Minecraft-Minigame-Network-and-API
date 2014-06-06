package mineplicity.hub.partyAPI;

import mineplicity.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class PartyCommand implements CommandExecutor {

	/*
     * This package was created by Erez!
	 */

    public Map<Player, HashMap<Integer,Integer>> allVotes = new HashMap<Player, HashMap<Integer,Integer>>();
    public List<Player> votedPlayers = new ArrayList<Player>();

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only player can do this command!");
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            if (PartyManager.getParty(p) != null) {
                if (PartyManager.getParty(p).isLeader(p)) {
                    p.sendMessage(ChatColor.RED + "/party invite <Player>");
                    p.sendMessage(ChatColor.RED + "/party kick <Player>");
                    p.sendMessage(ChatColor.RED + "/party accept");
                    p.sendMessage(ChatColor.RED + "/party leave");
                    p.sendMessage(ChatColor.RED + "/party disband");
                    return true;
                } else {
                    p.sendMessage(ChatColor.RED + "/party accept");
                    p.sendMessage(ChatColor.RED + "/party leave");
                }
            }
        }

        if (args[0].equalsIgnoreCase("invite")) {
            if (args.length == 1) {
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
                if (t == null) {
                    p.sendMessage(ChatColor.RED + "Cant find player!");
                    return true;
                }
                if (p == t) {
                    p.sendMessage(ChatColor.RED + "You cant invite yourself.");
                    return true;
                }
                Main.invites.put(t, p);
                t.sendMessage(p.getDisplayName() + ChatColor.GREEN + " Sent you a party request!. To join type /party accept");
                p.sendMessage(ChatColor.GREEN + "You invited " + ChatColor.RESET + t.getDisplayName());
                return true;
            }
            p.sendMessage(ChatColor.RED + "You cant do that!");
            return true;
        }
        if (args[0].equalsIgnoreCase("kick")) {
            if (args.length == 1) {
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
                if (Main.invites.get(p) != null) {
                    party = PartyManager.getParty(Main.invites.get(p));
                    party.addPlayer(p);
                    p.sendMessage(ChatColor.GREEN + "You just joined " + Main.invites.get(p).getDisplayName() + "'s party");
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
        if (args[0].equalsIgnoreCase("info")) {
            Party party = PartyManager.getParty(p);
            if (party != null) {
                p.sendMessage(ChatColor.AQUA + "----------- Party -----------");
                for (Player t : party.getPlayers()) {
                    if (party.isLeader(t)) {
                        p.sendMessage(ChatColor.YELLOW + "Leader: " + t.getDisplayName());
                    } else {
                        p.sendMessage(t.getDisplayName());
                    }
                }
                return true;
            }
            p.sendMessage(ChatColor.RED + "You are not in a party!");
            return true;
        }

        if(args[0].equalsIgnoreCase("vote")){
            Party party = PartyManager.getParty(p);
            if(party != null && party.isLeader(p)){
                if(args[1].equalsIgnoreCase("create")){
                    setupPartyVoting(party);
                    return true;
                }else if(args[1].equalsIgnoreCase("close")){
                    closePartyVoting(party);
                    return true;
                }
                p.sendMessage(ChatColor.RED + "Leader can't vote!");
                return true;
            }
            if(party != null && args.length == 2){
                if(!votedPlayers.contains(p)) {
                    int oldValue = party.votes.get(Integer.parseInt(args[1]));
                    party.votes.replace(Integer.parseInt(args[1]), oldValue, oldValue + 1);
                    p.sendMessage(ChatColor.GREEN + "Your vote has been cast!");
                    return true;
                }else{
                    p.sendMessage(ChatColor.RED + "You have already voted!");
                    return true;
                }
            }
            p.sendMessage(ChatColor.RED + "Invalid arguments! Please use /party vote <Minigame Number>");

        }

        if (args[0].equalsIgnoreCase("message")) {
            if (args.length > 2) {
                Party party = PartyManager.getParty(p);
                if (party != null) {
                    if (party.isLeader(p)) {
                        String message = "";
                        for (int i = 2; i < args.length; i++) {
                            message += args[1];
                        }
                        party.messageParty(party, message);
                        return true;
                    }
                    p.sendMessage(ChatColor.RED + "You cant do that!");
                    return true;
                }
                p.sendMessage(ChatColor.RED + "You are not in a party!");
                return true;
            }
        }

        if(args[0].equalsIgnoreCase("chat")){
            Party party = PartyManager.getParty(p);
            if(party != null) {
                if (args[1].equalsIgnoreCase("on")) {
                    PartyChatChannel.pChatPlayers.add(p);
                    p.sendMessage(ChatColor.GREEN + "Party Chat Enabled");
                    return true;

                } else if (args[1].equalsIgnoreCase("off")) {
                    PartyChatChannel.pChatPlayers.remove(p);
                    p.sendMessage(ChatColor.GREEN + "Party Chat Disabled");
                    return true;


                } else {
                    p.sendMessage(ChatColor.RED + "/party chat < On/Off >");
                    return true;
                }
            }
            p.sendMessage(ChatColor.RED + "You are not in a party");
        }

        return true;
    }

    public void setupPartyVoting(Party party) {
        Player leader = party.getLeader();
        allVotes.put(leader, party.votes);
        openPollCreationGUI(party, leader);
    }

    public void closePartyVoting(Party party) {
        allVotes.remove(party.getLeader());
        party.messageParty(party, ChatColor.DARK_BLUE + "Minigame voting is now closed");
        int winnerId = 0;
        int highestVotes = 0;
        for(int i = 0; i <= 5; i++){
            if(party.votes.get(i) > highestVotes){
                winnerId = i;
                highestVotes = party.votes.get(i);
            }
        }
        party.messageParty(party, ChatColor.DARK_BLUE + "The minigame that won is: " + ChatColor.BOLD + party.voteDisplayNames.get(winnerId));
    }

    private void openPollCreationGUI(Party party, Player p) {
        FileConfiguration config = Main.config;
        int a = config.getInt("Minigames.Amount");
        Inventory inv = Bukkit.createInventory(null, (a / 9 + 1 * 9), ChatColor.DARK_AQUA + "Create Poll");
        for (int i = 1; i <= config.getInt("Minigames.Amount"); i++) {
            Material jazz = Material.getMaterial(config.getString("Minigames." + i + ".item"));

            ItemStack is = new ItemStack(jazz);
            ItemMeta im = is.getItemMeta();

            List<String> lore = new ArrayList<String>();

            lore.add("§4Not chosen");


            im.setLore(lore);
            im.setDisplayName(config.getString("Minigames."+i));
            is.setItemMeta(im);

            inv.addItem(is);
        }
        p.openInventory(inv);
    }

    public static void beginVoting(List<ItemStack> is, Party party) {
        party.messageParty(party, ChatColor.DARK_AQUA + "Minigame voting has begun!!!");
        List<Player> targets = party.getPlayers();
        for(Player t : targets){
            t.sendMessage(ChatColor.BOLD + "#1: "+ is.get(0).getItemMeta().getDisplayName());
            t.sendMessage(ChatColor.BOLD + "#2: "+ is.get(1).getItemMeta().getDisplayName());
            t.sendMessage(ChatColor.BOLD + "#3: "+ is.get(2).getItemMeta().getDisplayName());
            t.sendMessage(ChatColor.BOLD + "#4: "+ is.get(3).getItemMeta().getDisplayName());
            t.sendMessage(ChatColor.BOLD + "#5: "+ is.get(4).getItemMeta().getDisplayName());
        }
        int i = 0;
        for(ItemStack itemstack : is) {
            party.voteDisplayNames.put(i, itemstack.getItemMeta().getDisplayName());
            i++;
        }
    }
}
