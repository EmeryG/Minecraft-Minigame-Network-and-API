package mineplicity.hub.partyAPI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 05/06/2014.
 */
public class PollListener implements Listener {

    @EventHandler
    public void onICE(InventoryClickEvent e){
        //Poll create Listener
        if(e.getInventory().getName().equalsIgnoreCase(ChatColor.stripColor("poll creater"))){
            if(e.getCurrentItem().getType() == Material.FIREBALL) {
                e.setCancelled(true);
                List<ItemStack> chosen = new ArrayList<ItemStack>();
                for(ItemStack is : e.getInventory().getContents()){
                    if(is.getItemMeta().getLore().equals("§aChosen") && chosen.size() < 5){
                        chosen.add(is);
                    }
                }
                Party party = PartyManager.getParty((Player)e.getViewers().get(0));
                if(chosen.size() == 5) {
                    PartyCommand.beginVoting(chosen, party);
                    e.getViewers().get(0).closeInventory();
                }
                else{
                    e.getViewers().get(0).closeInventory();
                    ((Player) e.getViewers().get(0)).sendMessage(ChatColor.RED + "You need to choose 5 minigames");
                }
            }
            if(e.getCurrentItem().getType() != Material.AIR && e.getCurrentItem().getType() != null){
                ItemStack is = e.getCurrentItem();
                if(is.getItemMeta().getLore().equals("§4Not chosen")){

                    ItemMeta im = is.getItemMeta();

                    List<String> lore = new ArrayList<String>();
                    lore.add("§aChosen");

                    im.setLore(lore);
                    is.setItemMeta(im);

                    e.setCancelled(true);

                }if(is.getItemMeta().getLore().equals("§aChosen")){

                    ItemMeta im = is.getItemMeta();

                    List<String> lore = new ArrayList<String>();
                    lore.add("§4 Not Chosen");

                    im.setLore(lore);
                    is.setItemMeta(im);

                    e.setCancelled(true);
                }
            }
        }

        //Poll choose listener

        if(e.getInventory().getName().equalsIgnoreCase(ChatColor.stripColor("minigame poll"))){

        }

    }
}
