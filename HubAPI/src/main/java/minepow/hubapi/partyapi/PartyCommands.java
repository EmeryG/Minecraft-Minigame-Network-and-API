package minepow.hubapi.partyapi;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/6/14
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class PartyCommands implements CommandExecutor,  Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("chat")) {
                Par
                return true;
            } else if(cmd.getName().equalsIgnoreCase("create")) {
                return true;
            } else if(cmd.getName().equalsIgnoreCase("disband")) {
                return true;
            } else if(cmd.getName().equalsIgnoreCase("leave")) {
                return true;
            } else if(cmd.getName().equalsIgnoreCase("join")) {
                return true;
            } else if(cmd.getName().equalsIgnoreCase("invite")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
