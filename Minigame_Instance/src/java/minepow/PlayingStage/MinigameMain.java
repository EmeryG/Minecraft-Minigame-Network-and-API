package minepow.PlayingStage;

import minepow.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

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

    public static void registerThread(BukkitRunnable thread) {
        threads.add(thread);
    }

    public static void setSpecator(Player spectator) {
        spectators.add(spectator);
    }

    public static void finish() {
        for(Listener l : listeners) {
            HandlerList.unregisterAll(l);
        }
        listeners.clear();
        for(BukkitRunnable thread : threads) {
            thread.cancel();
        }
        threads.clear();
    }
}
