package mineplicity.hub.commands;

import mineplicity.hub.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 01/06/2014.
 */
public class Reporter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equals("report")){

            Player player = (Player) commandSender;

            String message = "";

            for(int i = 1; i< strings.length; i++){
                message += strings[i];
            }

            Main.config.set("Report.Messages", player.getName() + ", " + message);

        }else if(strings[0].equalsIgnoreCase("list")){

        }


        return false;
    }
}
