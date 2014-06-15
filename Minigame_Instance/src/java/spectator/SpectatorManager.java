package spectator;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 14/06/2014.
 */
public class SpectatorManager {

    public static List<Spectator> spectators = new ArrayList<Spectator>();

    public static Spectator getSpectator(Player player){
        for(Spectator s : spectators){
            if(s.getPlayer() == player)
                return s;
        }
        return null;
    }

    public static Spectator getSpectator(String targetName){
        for(Spectator s : spectators){
            if(s.getPlayer().getName().equalsIgnoreCase(targetName))
                return s;
        }
        return null;
    }

    public static void addSpectator(Player player){
        spectators.add(new Spectator(player));
    }

    public static void removeSpectator(Player player){
        for(Spectator s : spectators){
            if(s.getPlayer() == player)
                spectators.remove(s);
        }
    }

    public static void removeSpectator(Spectator spectator){
        spectators.remove(spectator);
    }

}
