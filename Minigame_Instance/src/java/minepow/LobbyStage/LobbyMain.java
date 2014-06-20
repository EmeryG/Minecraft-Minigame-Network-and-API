package minepow.LobbyStage;

import lombok.Getter;
import lombok.Setter;
import minepow.config.Config;
import minepow.listeners.PlayerInput;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import minepow.Main;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class LobbyMain implements Listener {
    static ArrayList<PlayerInput> inputListeners = new ArrayList<PlayerInput>();
    static ArrayList<Listener> listeners = new ArrayList<Listener>();

    @Getter @Setter
    static int minimumPlayers = 3;

    @Getter @Setter
    static int interval = 120;

    @Getter
    static VoteManager voteManager = new VoteManager();

    @Getter
    static SelectionManager selectionManager = new SelectionManager();

    public static void registerListener(PlayerInput listener) {
        inputListeners.add(listener);
    }

    public static void registerListener(Listener listener) {
        listeners.add(listener);
        Bukkit.getPluginManager().registerEvents(listener, Main.getMain());
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

    public static  void start() {
        Bukkit.getPluginManager().registerEvents(voteManager, Main.getMain());
        Bukkit.getPluginManager().registerEvents(selectionManager, Main.getMain());
    }

    public static void finish() {
        inputListeners.clear();
        for(Listener l : listeners) {
            HandlerList.unregisterAll(l);
        }
        listeners.clear();
        HandlerList.unregisterAll(voteManager);
        HandlerList.unregisterAll(selectionManager);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        Player p = e.getPlayer();

        p.teleport(Config.getMapInfo().get("lobby").get("spawn").get(1));
        p.setFlying(false);

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.showPlayer(p);
        }

        for(PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
    }
}
