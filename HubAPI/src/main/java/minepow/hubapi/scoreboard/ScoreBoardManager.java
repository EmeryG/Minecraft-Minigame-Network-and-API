package minepow.hubapi.scoreboard;

import minepow.hubapi.economy.EconomyManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoardManager {

    static Scoreboard scoreboard = null;
    static Objective title = null;
    private static final String TITLE = ChatColor.GOLD + "MinePow";

    public static void removeScoreBoard(Player player) {
        player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
    }

    @SuppressWarnings("deprecation")
    public static void updateScoreBoard(Player player) {

        //creating a new score board
        scoreboard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        //creating an objective called ^TITLE^
        title = scoreboard.registerNewObjective(TITLE, "dummy");

        //Setting some scores
        title.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "PowMoney:")).setScore(15);
        ;
        title.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.AQUA + "" + ChatColor.BOLD + EconomyManager.getCurrentMoney(player))).setScore(14);
        ;
    }
}
