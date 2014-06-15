package LobbyStage;

import listeners.PlayerInput;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/15/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class LobbyMain {
    ArrayList<PlayerInput> inputListeners = new ArrayList<PlayerInput>();

    public void registerListener(PlayerInput listener) {
        inputListeners.add(listener);
    }

    void onVoteFinish(String category, String winner) {
        for(PlayerInput ip : inputListeners) {
            ip.onVoteFinish(category, winner);
        }
    }

    void onSelect(Player p, String category, String selection) {
        for(PlayerInput ip : inputListeners) {
            ip.onSelect(p, category, selection);
        }
    }
}
