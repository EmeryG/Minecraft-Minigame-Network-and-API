import minepow.PlayingStage.MinigameMain;
import minepow.config.Config;
import minepow.listeners.PlayerInput;
import minepow.listeners.States;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Ali on 23/06/2014.
 */
public class StatesListener implements States, PlayerInput{
    String mapChosen;
    static List<Player> sleepers;
    static List<Player> nightmares;
    @Override
    public void onLobby() {

    }

    @Override
    public void onMinigame() {
        sleepers = Arrays.asList(Bukkit.getOnlinePlayers());
        chooseBeginningNightmare();
        MinigameMain.spawnPlayersRandomly(Config.getMapInfo().get(mapChosen).get("border").get(1), Config.getMapInfo().get(mapChosen).get("border").get(2));
        giveSleepersEffects();
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
    }

    public static void addNightmare(Player p){
        sleepers.remove(p);
        nightmares.add(p);
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.setHealth(15);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
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
