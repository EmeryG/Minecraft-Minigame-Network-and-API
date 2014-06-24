import minepow.LobbyStage.LobbyMain;
import minepow.LobbyStage.Vote;
import minepow.PlayingStage.MinigameMain;
import minepow.config.Config;
import minepow.listeners.PlayerInput;
import minepow.listeners.States;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * Created by Ali on 20/06/2014.
 */
public class StatesListener implements States, PlayerInput{
    String mapChosen;
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
        MinigameMain.registerListener(new GameListeners());
        Targeting.registerTargeting();
        CompassTarget target = new CompassTarget();
        target.runTaskTimer(Main.getMain(), 200, 20);
        MinigameMain.registerThread(new CompassTarget(),200L, 20L);
        MinigameMain.spawnPlayersRandomly(Config.getMapInfo().get(mapChosen).get("border").get(1), Config.getMapInfo().get(mapChosen).get("border").get(2));
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
