package mineplicity.hub.news;

import mineplicity.hub.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Ali on 06/06/2014.
 */

public class NewsCommand implements CommandExecutor{
    
	FileConfiguration config = Main.config;
	
	Main plugin;

    public NewsCommand(Main plugin){
    	this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("addnews")){
        	if(args.length < 2){
        		commandSender.sendMessage(ChatColor.RED + "/addnews <Number> <Message>");
        		return true;
        	}
        	int num = -1;
        	
        	try{
        		num = Integer.parseInt(args[0]);
        	}catch(Exception e){
        		commandSender.sendMessage(ChatColor.RED + "This is not a number!");
        	}
        	if(num > 10){
        		commandSender.sendMessage(ChatColor.RED + "Max number is 10!");
        		return true;
        	}
        	
            String message = "";
            for(int i = 1; i < args.length; i++){
                message += args[i];
            }
            addNews(message, num);
            return true;
        }
        return false;
    }

    public void addNews(String message, int number) {
        config.set("News."+number, message);
        plugin.saveConfig();
    }
}
