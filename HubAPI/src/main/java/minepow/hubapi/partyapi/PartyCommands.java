package minepow.hubapi.partyapi;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartyCommands implements CommandExecutor{

    public Map<Player, List<Player>> parties = new HashMap<Player, List<Player>>();
    public Map<Player, Party> invites = new HashMap<Player, Party>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("party") || label.equalsIgnoreCase("p")){

            Player player = (Player) sender;

            if(args[0].equalsIgnoreCase("create")){

            }

            if(args[0].equalsIgnoreCase("disband")){

            }

            if(args[0].equalsIgnoreCase("invite")){
                Player target = Bukkit.getPlayer(args[1]);
                invites.put(target, );
            }

            if(args[0].equalsIgnoreCase("join")){

            }

            if(args[0].equalsIgnoreCase("leave")){

            }

        }
        return false;
    }
}
