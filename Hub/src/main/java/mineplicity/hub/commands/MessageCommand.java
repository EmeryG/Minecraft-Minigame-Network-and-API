package mineplicity.hub.commands;

import mineplicity.hub.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Ali on 01/06/2014.
 */
public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {


        if (cmdLabel.equalsIgnoreCase("message")) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            //Unreplaced strings(In case of color codes
            String senderPrefix = Main.config.getString("Messager.SenderPrefix");
            String recieverPrefix = Main.config.getString("Messager.RecieverPrefix");
            String senderAndRecieverDivider = Main.config.getString("Messager.Divider");
            String messageColor = Main.config.getString("Messager.MessageColor");
            String message = "";
            for (int i = 1; i <= args.length; i++) {
                message = message + args[i];
            }
            if (!(sender instanceof Player)) {
                String processedMessage = "<" + ChatColor.DARK_RED + " Console" + ChatColor.RESET + senderAndRecieverDivider + recieverPrefix + target.getName() + "&f>" + messageColor + " " + message;
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', processedMessage));
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', processedMessage));
            }
            if (args.length > 1 && args.length < 3 && target == null) {
                Player player = (Player) sender;
                //Message read for users to see
                String processedMessage = "<" + senderPrefix + sender.getName() + senderAndRecieverDivider + recieverPrefix + target.getName() + "&f>" + messageColor + " " + message;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', processedMessage));
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', processedMessage));
            }
        }
        return false;
    }
}
