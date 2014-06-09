import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Ali on 08/06/2014.
 */
public class Timer extends BukkitRunnable{

    int seconds;
    Player p;
    String server;
    Main main;

    public Timer(int seconds, Player p, String server){
        this.seconds = seconds;
        this.p = p;
        this.server = server;
    }

    @Override
    public void run() {
        seconds--;
        if(seconds < 1){
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
