package minepow.LobbyStage;

import minepow.listeners.PlayerInput;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import minepow.Main;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class LobbyMain {
    static ArrayList<PlayerInput> inputListeners = new ArrayList<PlayerInput>();
    static ArrayList<Listener> listeners = new ArrayList<Listener>();

    public static void registerListener(PlayerInput listener) {
        inputListeners.add(listener);
    }

    public static void registerListener(Listener listener) {
        listeners.add(listener);
        Bukkit.getPluginManager().registerEvents(listener, Main.main);
    }

    public static void onVoteFinish(String category, String winner) {
        for(PlayerInput ip : inputListeners) {
            ip.onVoteFinish(category, winner);
        }
    }

    public static void onSelect(Player p, String category, String selection) {
        for(PlayerInput ip : inputListeners) {
            ip.onSelect(p, category, selection);
        }
    }

    public static void finish() {
        inputListeners.clear();
        for(Listener l : listeners) {
            HandlerList.unregisterAll(l);
        }
        listeners.clear();
    }
}
