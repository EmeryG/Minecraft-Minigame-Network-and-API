import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Ali on 08/06/2014.
 */
public class Timer extends BukkitRunnable implements Listener {

    int interval;
    int seconds;
    Player p;
    Main main;

    public Timer(int inter, Player p){
        this.p = p;
        this.interval = inter;
        this.seconds += inter;
    }

    @Override
    public void run() {
        seconds--;
        if(seconds < 1){
            String server = InstanceListener.getHighestPriority();
            if(server == "") {
                seconds += interval;
            } else {
                this.cancel();
                try {
                    main.connect.request(new RedirectRequest(server, p.getName()));
                } catch (RequestException e) {
                    Bukkit.getPlayer(p.getName()).sendMessage(ChatColor.GOLD + "Error: Couldn't sent you to " + ChatColor.RED + server);
                    e.printStackTrace();
                }
            }

        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(e.getPlayer() == p) {
            this.cancel();
        }
    }
}
