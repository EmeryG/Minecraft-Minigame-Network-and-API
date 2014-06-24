import minepow.LobbyStage.LobbyMain;
import minepow.LobbyStage.Vote;
import minepow.PlayingStage.MinigameMain;
import minepow.config.Config;
import minepow.listeners.PlayerInput;
import minepow.listeners.States;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Ali on 23/06/2014.
 */
public class StatesListener implements States, PlayerInput{
    public static String mapChosen;
    static List<Player> sleepers;
    static List<Player> nightmares;
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
        sleepers = Arrays.asList(Bukkit.getOnlinePlayers());
        MinigameMain.registerListener(new GameListeners());
        chooseBeginningNightmare();
        MinigameMain.spawnPlayersRandomly(Config.getMapInfo().get(mapChosen).get("border").get(1), Config.getMapInfo().get(mapChosen).get("border").get(2));
        giveSleepersEffects();

        NetherStarDropper nsd = new NetherStarDropper();
        nsd.runTaskTimer(Main.getMain(), 200, 200);
        MinigameMain.registerThread(new NetherStarDropper(), 200L, 200L);
    }

    private void giveSleepersEffects() {
        for(Player p : sleepers){
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0));
        }
    }

    private void chooseBeginningNightmare() {
        Random r = new Random();
        Player n = sleepers.get(r.nextInt(sleepers.size()));
        nightmares.add(n);
        sleepers.remove(n);
        Main.ghostFactory.setGhost(n, true);

    }

    public static void addNightmare(Player p){
        sleepers.remove(p);
        nightmares.add(p);
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.setHealth(15);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        Main.ghostFactory.setGhost(p, true);
    }

    @Override
    public void onEnd(ArrayList<Player> players) {
    //GAAAAAAAAAAAAAAAAAAAAAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY MOTHER FUCKERS
    }

    @Override
    public void onVoteFinish(String s, String s2) {
        mapChosen = s2;
    }

    @Override
    public void onSelect(Player player, String s, String s2) {

    }
}
