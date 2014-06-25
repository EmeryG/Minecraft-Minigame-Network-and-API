package minepow.PlayingStage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/23/14
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static Location dropItemRandonmly(Location borderPoint1, Location borderPoint2, ItemStack item){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneYGreater = borderPoint1.getBlockY() > borderPoint2.getBlockY();

        Location tp = new Location(borderPoint1.getWorld(), 0, 100, 0);
        Random r = new Random();

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

        borderPoint1.getWorld().dropItemNaturally(tp, item);

        return tp;

    }

    public static void spawnPlayersRandomly(Location borderPoint1, Location borderPoint2){
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

    public static Location spawnPlayerRandomly(Player p, Location borderPoint1, Location borderPoint2){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneZGreater = borderPoint1.getBlockZ() > borderPoint2.getBlockZ();

        Location tp = new Location(borderPoint1.getWorld(), 0, 200, 0);
        Random r = new Random();

        ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
        effects.add(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
        effects.add(new PotionEffect(PotionEffectType.SLOW, 100, 7));
        effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 100, 20));
        effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 5));

        if(isOneXGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
        }

        if(isOneZGreater) {
            tp.setZ(r.nextInt(borderPoint1.getBlockZ() - borderPoint2.getBlockZ()));
        } else {
            tp.setZ(r.nextInt(borderPoint2.getBlockZ() - borderPoint1.getBlockZ()));
        }

        p.addPotionEffects(effects);
        p.teleport(tp);

        return tp;
    }

    public static Location getRandomLocation(Location borderPoint1, Location borderPoint2){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneZGreater = borderPoint1.getBlockZ() > borderPoint2.getBlockZ();

        Location tp = new Location(borderPoint1.getWorld(), 0, 200, 0);
        Random r = new Random();

        if(isOneXGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
        }

        if(isOneZGreater) {
            tp.setZ(r.nextInt(borderPoint1.getBlockZ() - borderPoint2.getBlockZ()));
        } else {
            tp.setZ(r.nextInt(borderPoint2.getBlockZ() - borderPoint1.getBlockZ()));
        }

        return tp;
    }

    public static Location getRandomLocation(Location borderPoint1, Location borderPoint2, int y){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneZGreater = borderPoint1.getBlockZ() > borderPoint2.getBlockZ();

        Location tp = new Location(borderPoint1.getWorld(), 0, y, 0);
        Random r = new Random();

        if(isOneXGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
        }

        if(isOneZGreater) {
            tp.setZ(r.nextInt(borderPoint1.getBlockZ() - borderPoint2.getBlockZ()));
        } else {
            tp.setZ(r.nextInt(borderPoint2.getBlockZ() - borderPoint1.getBlockZ()));
        }

        return tp;
    }
}
