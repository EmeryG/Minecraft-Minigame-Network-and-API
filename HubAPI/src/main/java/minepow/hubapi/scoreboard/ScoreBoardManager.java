package minepow.hubapi.scoreboard;

import minepow.hubapi.Main;
import minepow.hubapi.economy.EconomyManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

/**
 * Created by Ervin on 6/7/2014.
 */
public class ScoreBoardManager {

    public static void scoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("Test", "Test2");
        objective.setDisplayName(Main.plugin.getConfig().getString("SCOREBOARD_TITLE").replaceAll("§","&"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = objective.getScore(Bukkit.getOfflinePlayer(Main.plugin.getConfig().getString("SOREBOARD_MONEY").replaceAll("§","&")));
        score.setScore(EconomyManager.getCurrentMoney(p));

        p.setScoreboard(board);
    }
	
}
