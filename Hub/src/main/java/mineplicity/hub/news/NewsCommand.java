package mineplicity.hub.news;

import mineplicity.hub.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Ali on 06/06/2014.
 */
public class NewsCommand implements CommandExecutor{
    FileConfiguration config = Main.config;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("addnews")){
            String message = "";
            for(int i = 0; i < args.length; i++){
                message += args[i];
            }
            addNews(message, Integer.parseInt(args[0]));
            return true;
        }
        return false;
    }

    public void addNews(String message, int number) {
        config.set("News."+number, message);
    }
}
