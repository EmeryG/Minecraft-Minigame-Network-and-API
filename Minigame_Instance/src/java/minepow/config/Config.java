package minepow.config;

import lombok.Getter;
import minepow.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ervin on 6/19/2014.
 */
public class Config {

    static HashMap<String, HashMap<String, HashMap<Integer, Location>>> mapInfo = null;
    static HashMap<String, Kit> kits = null;

    @Getter
    static ArrayList<String> maps = new ArrayList<String>(Main.getMainConfig().getStringList("points"));


    public static HashMap<String, HashMap<String, HashMap<Integer, Location>>> getMapInfo() {
        if(mapInfo == null) {

            mapInfo = new HashMap<String, HashMap<String, HashMap<Integer, Location>>>();

            FileConfiguration config = Main.getMainConfig();

            for(String map : config.getStringList("points")) {
                HashMap<String, HashMap<Integer, Location>> points = new HashMap<String, HashMap<Integer, Location>>();
                for(String pointType : config.getStringList("points." + map)) {
                    HashMap<Integer, Location> pointSet = new HashMap<Integer, Location>();
                    for(int pointNumber : config.getIntegerList("points." + map + "." + pointType)) {
                        pointSet.put(pointNumber,
                                new Location(
                                        Bukkit.getWorld(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "world")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "y")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "z"))));
                    }
                    points.put(pointType, pointSet);
                }

                mapInfo.put(map, points);
            }
        }

        return mapInfo;
    }

    public Kit getKit(String kit) {
        if(kits == null) {
            FileConfiguration config = Main.getMain().getConfig();
            kits = new HashMap<String, Kit>();

            for(String kt : config.getStringList("kits")) {
                ItemStack[] armor = new ItemStack[3];
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();

                for(int i = 0; i < 4; i++) {
                    armor[i] = new ItemStack(Material.getMaterial(config.getStringList("kits." + kt + "armor").get(i)));
                }

                for(String item : config.getStringList("kits." + kt + "items")) {
                    items.add(new ItemStack(Material.getMaterial(item)));
                }

                kits.put(kt, new Kit(armor, items));
            }
        }

        return kits.get(kit);
    }
}
