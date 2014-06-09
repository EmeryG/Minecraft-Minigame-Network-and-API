package mineplicity.hub.commands;

import mineplicity.hub.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Reporter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (s.equals("report")) {

            Player player = (Player) commandSender;

            String message = "";
            HashMap<String, String> reports = new HashMap<String, String>();
            for (int i = 1; i < strings.length; i++) {
                message += strings[i];
                reports.put(player.getName(), message);
            }

            Main.config.set("Report.Messages", reports);

        } else if (strings[0].equalsIgnoreCase("list")) {
            Main.config.getList("Report.Messages");
        }
        return false;
    }
}
