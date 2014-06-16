package LobbyStage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 15/06/2014.
 */
public class VoteManager {

    public static List<Vote> votes = new ArrayList<Vote>();
    public static ItemStack displayItem;

    @EventHandler
    public void onPJE(PlayerJoinEvent e){
        e.getPlayer().getInventory().addItem(new ItemStack(displayItem));
    }

    @EventHandler
    public void onPIE(PlayerInteractEvent e){
        if(e.getItem() == displayItem){
            openGUI(e.getPlayer());
        }
    }

    @EventHandler
    public void onICE(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase(displayItem.getItemMeta().getDisplayName())){
            addVote(e.getCurrentItem().getItemMeta().getDisplayName());
        }
    }

    private void openGUI(Player p) {
        int math = votes.size() / 9 + 1 * 9;
        Inventory inv = Bukkit.createInventory(null, math, displayItem.getItemMeta().getDisplayName());
        for(Vote v : votes){
            inv.addItem(new ItemStack(v.displayItem));
        }
        p.openInventory(inv);
    }

    private void addVote(String name){
        for(Vote v : votes){
            if(v.name.equalsIgnoreCase(name)){
                v.votedFor++;
            }
        }
    }
}
