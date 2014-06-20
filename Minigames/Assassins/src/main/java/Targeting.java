import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Ali on 20/06/2014.
 */
public class Targeting {
    public static HashMap<Player,Player> targetList = new HashMap<Player, Player>();
    public static void registerTargeting(){
        List<Player> players = Arrays.asList(Bukkit.getOnlinePlayers());
        Collections.shuffle(players);
        for(int i = 0; i < players.size(); i++){
            if(i != players.size()-1){
                targetList.put(players.get(i), players.get(i+1));
            }
            else{
                targetList.put(players.get(i), players.get(0));
            }
        }
    }

    public static void assignNewTarget(Player player){
        Player oldTarget = targetList.get(player);
        Player newTarget = targetList.get(oldTarget);
        targetList.replace(player, oldTarget, newTarget);
    }
}
