package mineplicity.hub.partyAPI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;


/**
 * Created by Ali on 05/06/2014.
 */
public class PartyChatChannel implements Listener{

    ArrayList<Player> pChatPlayers = new ArrayList<Player>();

    //Player chat event
    @EventHandler
    public void onPCE(AsyncPlayerChatEvent e){
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

}
