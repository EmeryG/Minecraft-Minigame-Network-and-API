package minepow.listeners;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Emery
 * Date: 6/16/14
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface States {
    public void onLobby();
    public void onMinigame();
    public void onEnd(ArrayList<Player> winners);
}
