import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Ali on 20/06/2014.
 */
public class Targeting {
    public static HashMap<UUID,UUID> targetList = new HashMap<UUID, UUID>();
    public static void registerTargeting(){
        List<Player> players = Arrays.asList(Bukkit.getOnlinePlayers());
        Collections.shuffle(players);
        for(int i = 0; i < players.size(); i++){
            if(i != players.size()-1){
                targetList.put(players.get(i).getUniqueId(), players.get(i+1).getUniqueId());
            }
            else{
                targetList.put(players.get(i).getUniqueId(), players.get(0).getUniqueId());
            }
        }
    }

    public static void assignNewTarget(Player player){
        UUID oldTarget = targetList.get(player.getUniqueId());
        UUID newTarget = targetList.get(oldTarget);
        targetList.replace(player.getUniqueId(), oldTarget, newTarget);
    }
}
