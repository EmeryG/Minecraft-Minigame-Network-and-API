package commands;

import main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ali on 01/06/2014.
 */
public class TimeLockCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("timelock") || label.equalsIgnoreCase("tl")) {
            FileConfiguration config = Main.config;
            Main main = new Main();
            if (args.length == 1) {
                if (args[0].equals("off")) {
                    config.set("TimeLock.enabled", false);
                    main.remoteSaveConfig();
                    sender.sendMessage("Time lock disabled");
                    return true;
                } else if (args[0].equals("on")) {
                    config.set("TimeLock.enabled", true);
                    main.remoteSaveConfig();
                    sender.sendMessage("Time lock enabled");
                    return true;
                } else {
                    return false;
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("setlock")) {
                    long lockTime = Long.parseLong(args[1]);
                    config.set("TimeLock.lockedtime", processLockTime(lockTime));
                    main.remoteSaveConfig();
                    sender.sendMessage("Time locked at " + convertToClock(lockTime));
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private long processLockTime(long lockTime) {
        if (lockTime % 100 == 30) {
            return (lockTime / 100 * 100) + 50;
        }
        return lockTime;
    }

    private String convertToClock(long lockTime) {

        int hours = (int) (lockTime / 100);
        if (lockTime % 100 == 30) {
            return hours + ":30";
        }

        return hours + ":00";
    }
}
