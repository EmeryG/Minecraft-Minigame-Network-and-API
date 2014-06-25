import minepow.PlayingStage.Util;
import minepow.config.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ali on 23/06/2014.
 */
public class RandomDrops extends BukkitRunnable {
    @Override
    public void run() {
        FileConfiguration config = Config.getConfig();
        Random r = new Random();

        String isString = config.getString(config.getStringList("drops").get(r.nextInt(config.getStringList("drops").size())));
        ItemStack is = new ItemStack(Material.getMaterial(isString));
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString(isString + ".name")));

        ArrayList<String> lore = new ArrayList<String>();

        lore.add(0, ChatColor.translateAlternateColorCodes('&', config.getString(isString + ".effect")));
        lore.add(1, config.getString(isString));

        im.setLore(lore);

        is.setItemMeta(im);

        Util.dropItemRandonmly(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2),is);
    }
}
