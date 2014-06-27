import minepow.*;
import minepow.LobbyStage.LobbyMain;
import minepow.LobbyStage.Vote;
import minepow.PlayingStage.MinigameMain;
import minepow.PlayingStage.Util;
import minepow.config.Config;
import minepow.listeners.PlayerInput;
import minepow.listeners.States;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ali on 25/06/2014.
 */
public class StatesListener implements States, PlayerInput{

    static String mapChosen;

    @Override
    public void onLobby() {
        LobbyMain.registerListener(this);
        ArrayList<String> maps = Config.getMaps();
        ArrayList<Material> Ids = new ArrayList<Material>();

        for(int i = 0; i < maps.size(); i++){
            Ids.add(i, Material.MAP);
        }

        LobbyMain.getVoteManager().votes.add(new Vote(ChatColor.BOLD + "Map Selection", Material.MAP, maps, Ids));
    }

    @Override
    public void onMinigame() {
        MinigameMain.registerListener(new GameListener());
        spawnChests();
        MinigameMain.registerThread(new SoundEffectsGenerator(), 0L, 40L);
    }

    private void spawnChests(){
        for(int i = 0; i < minepow.Main.getMainConfig().getInt("chestAmounts"); i++){
            List<String> items = minepow.Main.getMainConfig().getStringList("chestItems");
            int amountOfItemsInChest = minepow.Main.getMainConfig().getInt("amountOfItemsInChest");
            Random r = new Random();
            Location rL = Util.getRandomLocation(60, Config.getMapInfo().get(mapChosen).get("border").get(1), Config.getMapInfo().get(mapChosen).get("border").get(2));
            Block b = Bukkit.getWorld(minepow.Main.getMainConfig().getString("world")).getBlockAt(rL);
            b.setType(Material.CHEST);
            Chest c = (Chest) b.getState();
            for(int j = 0; i < amountOfItemsInChest; j++){
                c.getBlockInventory().addItem(new ItemStack(Material.getMaterial(items.get(r.nextInt(items.size() - 1)))));
            }
        }
    }

    @Override
    public void onEnd(ArrayList<Player> players) {

    }

    @Override
    public void onVoteFinish(String s, String s2) {
        mapChosen = s2;
    }

    @Override
    public void onSelect(Player player, String s, String s2) {

    }
}
