package LobbyStage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 15/06/2014.
 */
public class LobbySelection {

    public static List<Selection> selections = new ArrayList<Selection>();

    public static void addSelection(Material categoryItem, String category, ArrayList<String> options, ArrayList<Material> optionIds){
        Player[] players = Bukkit.getOnlinePlayers();

        ItemStack is = new ItemStack(categoryItem);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(category);

        is.setItemMeta(im);
        for(Player p : players){
            p.getInventory().addItem(is);
        }

        Selection s = new Selection(categoryItem, options, optionIds);

        selections.add(s);

    }

}
