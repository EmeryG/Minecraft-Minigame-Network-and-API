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
public class StatesListener  extends PlayerInput implements States{
    String mapChosen;
    @Override
    public void onLobby() {
        ArrayList<String> maps = Config.getMapInfo().keySet();
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
        enterPlayersIntoMap(Config.getMapInfo().get(map).get("border").get(1), Config.getMapInfo().get(map).get("border").get(2));
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
        effects.add(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
        effects.add(new PotionEffect(PotionEffectType.SLOW, 100, 7));
        effects.add(new PotionEffect(PotionEffectType.WEAKNESS, 100, 20));
        effects.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 5));

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
