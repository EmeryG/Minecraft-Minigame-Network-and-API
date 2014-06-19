package minepow.config;

import minepow.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ervin on 6/19/2014.
 */
public class Config {

    public static HashMap<String, HashMap<String, Location>> getMapInfo() {
        HashMap<String, HashMap<String, Location>> mapInfo = new HashMap<String, HashMap<String, Location>>();
        FileConfiguration config = Main.getMain().getConfig();

        for(String map : config.getStringList("points")) {
            HashMap<String, Location> points = new HashMap<String, Location>();
            for(String pointType : config.getStringList("points." + map)) {
                for(String pointNumber : config.getStringList("points." + map + "." + pointType)) {
                    points.put(pointType + pointNumber, new Location(
                                    Bukkit.getWorld(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "world")),
                                    Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x")),
                                    Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x")),
                                    Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x"))));
                }
            }
            mapInfo.put(map, points);
        }
        
        return mapInfo;
    }
}
