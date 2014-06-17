package minepow.LobbyStage;

import minepow.MinigameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/16/14
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class LobbyTimer extends BukkitRunnable implements Listener {

    int seconds = -1;
    int interval = 120;


    public void run() {
        if(MinigameManager.getState() != MinigameManager.State.PRE) {
            seconds = -1;
        }

        if(seconds > -1) {
            if(seconds == 0) {
                LobbyMain.finish();
            }
            seconds--;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(Bukkit.getOnlinePlayers().length > 2
                && MinigameManager.getState() == MinigameManager.State.PRE
                && seconds == -1) {
            seconds += 120;
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(Bukkit.getOnlinePlayers().length < 2
                && MinigameManager.getState() == MinigameManager.State.PRE
                && seconds != -1) {
            seconds = -1;
        }
    }
}
