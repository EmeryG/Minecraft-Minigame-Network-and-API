package minepow.LobbyStage;

import org.bukkit.Bukkit;
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
public class SelectionManager implements Listener {

    public static List<Selection> selections = new ArrayList<Selection>();

    @EventHandler
    public void onPJE(PlayerJoinEvent e){
        Player p = e.getPlayer();
        for(Selection s : selections){
            p.getInventory().addItem(new ItemStack(s.categoryItem));
        }
    }

    @EventHandler
    public void onPIE(PlayerInteractEvent e){
        for(Selection s : selections){
            if(s.categoryItem == e.getMaterial()){
                openGUI(s, e.getPlayer());
            }
        }
    }

    @EventHandler
    public void onICE(InventoryClickEvent e){
        ItemStack is = e.getCurrentItem();
        String name = e.getInventory().getName();
        LobbyMain.onSelect((Player) e.getWhoClicked(), name, is.getItemMeta().getDisplayName());
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

}
