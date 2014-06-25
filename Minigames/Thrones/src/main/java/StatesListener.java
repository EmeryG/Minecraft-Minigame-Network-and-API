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
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

/**
 * Created by Ali on 24/06/2014.
 */
public class StatesListener implements States, PlayerInput{

    public static String mapChosen;
    static Entity emperor;
    static ArrayList<Player> bodyguards = new ArrayList<Player>();
    static ArrayList<Player> rebels = new ArrayList<Player>();
    static ArrayList<Player> silverfish = new ArrayList<Player>();

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
        assignPlayers();
        spawnBodyguards();
        spawnEmperor();
        spawnRebels();
    }

    //Spawn code

    private void spawnBodyguards() {
        Location l = Util.getRandomLocation(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));
        for(Player p : bodyguards){
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 5));
            p.teleport(l);
        }
    }

    private void spawnEmperor() {
        emperor = Bukkit.getWorld(Config.getConfig().getString("world")).spawnEntity(bodyguards.get(0).getLocation(), EntityType.VILLAGER);
    }

    private void spawnRebels(){
        boolean b = true;
        Location l = emperor.getLocation();
        while(b) {
            l = Util.getRandomLocation(Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(1), Config.getMapInfo().get(StatesListener.mapChosen).get("border").get(2));
            if(l.distance(emperor.getLocation()) > 50){
                b = false;
            }

        }

        for(Player p : rebels) {
                p.teleport(l);
        }
    }

    private void assignPlayers() {
        List<Player> players = Arrays.asList(Bukkit.getOnlinePlayers());
        Collections.shuffle(players);
        Random r = new Random();
        for(Player p : players){
            if(r.nextInt(1) == 0){
                bodyguards.add(p);
            }else{
                rebels.add(p);
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
