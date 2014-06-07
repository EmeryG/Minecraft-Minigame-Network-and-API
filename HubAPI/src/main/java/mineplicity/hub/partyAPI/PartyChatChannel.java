package mineplicity.hub.partyAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ali on 05/06/2014.
 */
public class PartyChatChannel implements Listener{

    public static List<Player> pChatPlayers = new ArrayList<Player>();

    //Player chat event
    @EventHandler
    public void onPPCE(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        for(Player p : pChatPlayers){
            if(p == player){
                Party party = PartyManager.getParty(player);
                if(party != null){
                    e.setCancelled(true);
                    for(Player t : party.getPlayers()){
                        t.sendMessage(ChatColor.DARK_BLUE + "[Party Chat]" + ChatColor.RESET + e.getMessage());
                    }
                }
                break;
            }
        }
    }

    //Normal chat no show for party chat
    @EventHandler(priority = EventPriority.LOW)
    public void onPNCE(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        if(!pChatPlayers.contains(player)){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(pChatPlayers.contains(p)){
                    e.setCancelled(true);
                }
            }
        }
    }

}
