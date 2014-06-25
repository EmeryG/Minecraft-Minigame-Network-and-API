package minepow.config;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/24/14
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kit {
    @Getter
    ItemStack[] armor;

    @Getter
    ArrayList<ItemStack> items;

    public Kit(ItemStack[] a, ArrayList<ItemStack> is) {
        armor = a;
        items = is;
    }

    public void givePlayerItems(Player p) {
        p.getInventory().setArmorContents(armor);

        for(ItemStack item : items) {
            p.getInventory().addItem(item);
        }
    }
}
