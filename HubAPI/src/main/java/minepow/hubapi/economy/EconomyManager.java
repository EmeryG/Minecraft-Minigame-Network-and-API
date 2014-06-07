package minepow.hubapi.economy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.UUID;

import minepow.hubapi.Main;
import minepow.hubapi.database.DatabaseWriter;

import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

/**
 * Created with Eclipse.
 * User: Erez
 * Date: 7/6/14
 * Time: 5:00 PM
 */

abstract public class EconomyManager {

    public static HashMap<UUID, Integer> players = new HashMap<UUID, Integer>();

    public static void dump(){

        try{

            BukkitObjectOutputStream boos = new BukkitObjectOutputStream(new FileOutputStream(new File(Main.plugin.getDataFolder(), "Econonmy.dat")));
            boos.writeObject(players);
            boos.flush();
            boos.close();

        }catch(Exception e){}

    }

    //still need to sync to database
    @SuppressWarnings("unchecked")
	public static void load(){

        try{

            BukkitObjectInputStream bois = new BukkitObjectInputStream(new FileInputStream(new File(Main.plugin.getDataFolder(), "Econonmy.dat")));
            players = (HashMap<UUID, Integer>) bois.readObject();
            bois.close();


        }catch(Exception e){}

    }

    public static void addMoney(Player player, int money) {

    	//checking if the player is in the players List
        if (!players.containsKey(player.getUniqueId())) {
        	//adding him if he is not in the List
            players.put(player.getUniqueId(), money);
            return;
        }

        
        int currentMoney = players.get(player.getUniqueId());

        //adding the money and updating the list
        players.put(player.getUniqueId(), currentMoney + money);
        minepow.hubapi.database.DatabaseWriter.updateMoney(player.getUniqueId(), currentMoney+money);

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

    public static boolean removeMoney(Player player, int money) {
    	
    	//checking if the player is in the players List
        if (!players.containsKey(player.getUniqueId())) {
            return false;
        }

        
        int currentMoney = players.get(player.getUniqueId());
        int futureMoney = currentMoney - money;

        //checking if it wont be a "-number" in the player bank
        if (futureMoney >= 0) {
        	//removing and updating the list
            players.put(player.getUniqueId(), currentMoney - money);
            DatabaseWriter.updateMoney(player.getUniqueId(), currentMoney - money);
            return true;
        }

        return false;
    }

    public static int getCurrentMoney(Player player) {
    	//checking if the player is in the players List
        if (players.containsKey(player.getUniqueId())) {
            return players.get(player.getUniqueId());
        }
        return 0;
    }
}
