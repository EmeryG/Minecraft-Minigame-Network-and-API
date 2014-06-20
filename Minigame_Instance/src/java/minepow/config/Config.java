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

    static HashMap<String, HashMap<String, HashMap<Integer, Location>>> config = null;

    public static HashMap<String, HashMap<String, HashMap<Integer, Location>>> getMapInfo() {
        if(config == null) {


            HashMap<String,
                    HashMap<String,
                            HashMap<Integer, Location>>> mapInfo = new HashMap<String, HashMap<String, HashMap<Integer, Location>>>();

            FileConfiguration config = Main.getMain().getConfig();
            
            for(String map : config.getStringList("points")) {
                HashMap<String, HashMap<Integer, Location>> points = new HashMap<String, HashMap<Integer, Location>>();
                for(String pointType : config.getStringList("points." + map)) {
                    HashMap<Integer, Location> pointSet = new HashMap<Integer, Location>();
                    for(int pointNumber : config.getIntegerList("points." + map + "." + pointType)) {
                        pointSet.put(pointNumber,
                                new Location(
                                        Bukkit.getWorld(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "world")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x")),
                                        Double.parseDouble(config.getString("points." + map + "." + pointType + "." + pointNumber + "." + "x"))));
                    }
                    points.put(pointType, pointSet);
                }

                mapInfo.put(map, points);
            }
            return mapInfo;
        } else {
            return config;
        }
    }

    /*

       To get Map: HashMap<String,
                       HashMap<Integer, Location>> getMapInfo().get(mapName);

       To get Map Point Sets: HashMap<Integer, Location> getMapInfo().get(mapName).get(pointType);

       To get Map Point: Location getMapInfo().get(mapName).get(pointType).get(pointNumber);

     */
}
