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
