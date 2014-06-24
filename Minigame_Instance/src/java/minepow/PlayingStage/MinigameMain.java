package minepow.PlayingStage;

import minepow.Main;
import minepow.StageManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/16/14
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinigameMain {
    static ArrayList<Player> spectators = new ArrayList<Player>();
    static ArrayList<Listener> listeners = new ArrayList<Listener>();
    static ArrayList<BukkitRunnable> threads = new ArrayList<BukkitRunnable>();

    public static void registerListener(Listener listener) {
        listeners.add(listener);
        Bukkit.getPluginManager().registerEvents(listener, Main.getMain());
    }

    public static void registerThread(BukkitRunnable thread, Long delay, Long ticksBetweenRunning) {
        threads.add(thread);
        thread.runTaskTimer(Main.getMain(), delay, ticksBetweenRunning);
    }

    public static void registerThread(BukkitRunnable thread, Long delay) {
        threads.add(thread);
        thread.runTaskLater(Main.getMain(), delay);
    }

    public static void setSpecator(Player spectator) {
        spectators.add(spectator);

        spectator.setAllowFlight(true);
        spectator.setFlying(true);

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.hidePlayer(spectator);
        }
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

    public static void spawnPlayerRandomly(Player p, Location borderPoint1, Location borderPoint2){
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneYGreater = borderPoint1.getBlockY() > borderPoint2.getBlockY();

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

        if(isOneYGreater) {
            tp.setX(r.nextInt(borderPoint1.getBlockY() - borderPoint2.getBlockY()));
        } else {
            tp.setX(r.nextInt(borderPoint2.getBlockY() - borderPoint1.getBlockY()));
        }

        p.addPotionEffects(effects);
        p.teleport(tp);

    }

    public static ArrayList<Player> getSpecators() {
        return (ArrayList<Player>) spectators.clone();
    }

    public static void finish(ArrayList<Player> winners) {
        for (Listener l : listeners) {
            HandlerList.unregisterAll(l);
        }
        listeners.clear();
        for (BukkitRunnable thread : threads) {
            thread.cancel();
        }
        threads.clear();
        StageManager.toEnd(winners);
    }
}
