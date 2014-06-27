import minepow.PlayingStage.Util;
import minepow.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ali on 26/06/2014.
 */
public class SoundEffectsGenerator extends BukkitRunnable {
    @Override
    public void run() {
        Location l = Util.getRandomLocation(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));

        ArrayList<Sound> sounds = new ArrayList<Sound>();
        Random r = new Random();

        for(String s : minepow.Main.getMainConfig().getStringList("sounds")){
            sounds.add(Sound.valueOf(s));
        }

        Bukkit.getWorld(minepow.Main.getMainConfig().getString("world")).playSound(l, sounds.get(r.nextInt(sounds.size()-1)), 1.0F, 10.0F);
    }
}
