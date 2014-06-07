package minepow.hubapi.economy;

import java.util.HashMap;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * Created with Eclipse.
 * User: Erez
 * Date: 7/6/14
 * Time: 5:00 PM
 */

public class EconomyManager {

    public static HashMap<Player, Integer> players = new HashMap<Player, Integer>();

    public static void addMoney(Player player, int money) {

        if (!players.containsKey(player)) {
            players.put(player, money);
            return;
        }

        int currentMoney = players.get(player);
        players.put(player, currentMoney + money);

    }

    public static boolean canAfford(Player player, int money) {
        if (getCurrentMoney(player) >= money)
            return true;
        return false;
    }

    public static void payForPlayer(Player player, Player target, int money) {
        if (canAfford(player, money)) {
            removeMoney(player, money);
            addMoney(target, money);
            return;
        }
        return;
    }

    public static void removeMoney(Player player, int money) {

        if (!players.containsKey(player)) {
            return;
        }

        int currentMoney = players.get(player);
        int futureMoney = currentMoney - money;

        if (futureMoney >= 0) {
            players.put(player, currentMoney - money);
            return;
        }

        return;
    }

    public static int getCurrentMoney(Player player) {
        if (players.containsKey(player)) {
            return players.get(player);
        }
        return 0;
    }
}
