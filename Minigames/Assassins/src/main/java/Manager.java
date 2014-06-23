<<<<<<< HEAD
import org.bukkit.entity.Player;

import java.util.HashMap;
=======
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;
>>>>>>> a6c94b1e9f31aa960838fc384a2c5e5fe919e865

/**
 * Created by Ali on 20/06/2014.
 */
public class Manager {

    public static void startMinigame(){
        Targeting.registerTargeting();
        enterPlayersIntoMap();
    }

    public static void startLobby() {
    }

    public static void enterPlayersIntoMap(Location borderPoint1, Location borderPoint2) {
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneYGreater = borderPoint1.getBlockY() > borderPoint2.getBlockY();

        Location tp = new Location(borderPoint1.getWorld(), 0, 200, 0);
        Random r = new Random();

        ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
        effects.add(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
        effects.add(new PotionEffect(PotionEffectType.SLOW, 100, 7));
        effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 100, 20));
        effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 5));

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(isOneXGreater) {
                tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
            } else {
                tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
            }

            if(isOneYGreater) {
                tp.setX(r.nextInt(borderPoint1.getBlockY() - borderPoint2.getBlockY()));
            } else {
                tp.setX(r.nextInt(borderPoint2.getBlockY() - borderPoint1.getBlockY()));
            }

            p.addPotionEffects(effects);
            p.teleport(tp);
        }
    }
}