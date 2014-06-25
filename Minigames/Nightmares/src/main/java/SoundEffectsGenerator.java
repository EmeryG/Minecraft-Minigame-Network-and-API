import minepow.PlayingStage.Util;
import minepow.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ali on 24/06/2014.
 */
public class SoundEffectsGenerator extends BukkitRunnable{

    @Override
    public void run() {
        Location rL = Util.getRandomLocation(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));

        List<String> sounds = Config.getConfig().getStringList("sounds");
        Collections.shuffle(sounds);

        Bukkit.getWorld(Config.getConfig().getString("world")).playSound(rl, Sound.valueOf(sounds.get(0)));
    }
}
