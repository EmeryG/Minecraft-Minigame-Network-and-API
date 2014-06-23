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

/**
 * Created by Ali on 23/06/2014.
 */
public class StatesListener implements States, PlayerInput {

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
        MinigameMain.registerListener(new GameListener());
        enterPlayersIntoMap(Config.getMapInfo().get(mapChosen).get("border").get(1), Config.getMapInfo().get(mapChosen).get("border").get(2));
    }

    @Override
    public void onEnd(ArrayList<Player> players) {

    }

    public static void enterPlayersIntoMap(Location borderPoint1, Location borderPoint2) {
        boolean isOneXGreater = borderPoint1.getBlockX() > borderPoint2.getBlockX();
        boolean isOneYGreater = borderPoint1.getBlockY() > borderPoint2.getBlockY();

        Location tp = new Location(borderPoint1.getWorld(), 0, 200, 0);
        Random r = new Random();

        ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
        effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10000000, 5));

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(isOneXGreater) {
                tp.setX(r.nextInt(borderPoint1.getBlockX() - borderPoint2.getBlockX()));
            } else {
                tp.setX(r.nextInt(borderPoint2.getBlockX() - borderPoint1.getBlockX()));
            }

            if(isOneYGreater) {
                tp.setX(r.nextInt(borderPoint1.getBlockY() - borderPoint2.getBlockY()));
            } else {
                tp.setX(r.nextInt(borderPoint2.getBlockY() - borderPoint1.getBlockY()));
            }

            p.addPotionEffects(effects);
            p.teleport(tp);
        }
    }

    @Override
    public void onVoteFinish(String s, String s2) {
        mapChosen = s2;
    }

    @Override
    public void onSelect(Player player, String s, String s2) {

    }
}
