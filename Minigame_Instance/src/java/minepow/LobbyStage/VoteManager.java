package minepow.LobbyStage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
public class VoteManager implements Listener{

    public static List<Vote> votes = new ArrayList<Vote>();

    @EventHandler
    public void onPJE(PlayerJoinEvent e){
        Player p = e.getPlayer();
        for(Selection s : votes){
            p.getInventory().addItem(new ItemStack(s.categoryItem));
        }
    }

    @EventHandler
    public void onPIE(PlayerInteractEvent e){
        for(Selection s : votes){
            if(s.categoryItem == e.getMaterial()){
                openGUI(s, e.getPlayer());
            }
        }
    }

    @EventHandler
    public void onICE(InventoryClickEvent e){
        ItemStack is = e.getCurrentItem();
        String name = e.getInventory().getName();
        for(Vote s : votes){
            if(s.categoryItem == e.getCurrentItem().getType()){
                addVote(s, e.getCurrentItem().getType());
            }
        }
        e.setCancelled(true);
        e.getWhoClicked().closeInventory();
    }

    private void openGUI(Selection s, Player player) {
        int size = s.names.size() / 9 + 1 * 9;
        Inventory inv = Bukkit.createInventory(null, size, s.category);

        for(int I = 0; I < s.ids.size(); I++){
            ItemStack is = new ItemStack(s.ids.get(I));
            is.getItemMeta().setDisplayName(s.names.get(I));
            inv.addItem(is);
        }

        player.openInventory(inv);
    }

    private void addVote(Vote v, Material type){
        String option = v.names.get(v.ids.indexOf(type));
        v.votes.replace(option, v.votes.get(option)+1);
        v.total++;
        if(v.total <= Bukkit.getServer().getOnlinePlayers().length){
            LobbyMain.onVoteFinish(v.category, findWinner(v));
        }
    }

    private String findWinner(Vote v){
        String currentWinner = (String) v.votes.keySet().toArray()[0];
        int currentWinnerVotes = v.votes.get(currentWinner);
        for(String s : v.votes.keySet()) {
            if(v.votes.get(s) < currentWinnerVotes) {
                currentWinner = s;
                currentWinnerVotes = v.votes.get(s);
            }
        }
        return currentWinner;
    }
}
