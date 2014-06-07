package minepow.hubapi.economy;

import java.util.HashMap;

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

    	//checking if the player is in the players List
        if (!players.containsKey(player)) {
        	//adding him if he is not in the List
            players.put(player, money);
            return;
        }

        
        int currentMoney = players.get(player);
        
        //adding the money and updating the list
        players.put(player, currentMoney + money);

    }

    public static boolean canAfford(Player player, int money) {
    	//cheking if the current money is bigger then the target amount
        if (getCurrentMoney(player) >= money)
            return true;
        return false;
    }

    public static boolean payForPlayer(Player player, Player target, int money) {
    	
    	//see if player can afford the money
        if (canAfford(player, money)) {
        	
        	//removing the money from the payer
            removeMoney(player, money);
            //adding money to the getter
            addMoney(target, money);
            return true;
        }
        return false;
    }

    public static void removeMoney(Player player, int money) {
    	
    	//checking if the player is in the players List
        if (!players.containsKey(player)) {
            return;
        }

        
        int currentMoney = players.get(player);
        int futureMoney = currentMoney - money;

        //checking if it wont be a "-number" in the player bank
        if (futureMoney >= 0) {
        	//removing and updating the list
            players.put(player, currentMoney - money);
            return;
        }

        return;
    }

    public static int getCurrentMoney(Player player) {
    	//checking if the player is in the players List
        if (players.containsKey(player)) {
            return players.get(player);
        }
        return 0;
    }
}
