import minepow.listeners.States;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Ali on 20/06/2014.
 */
public class StatesListener implements States{
    @Override
    public void onLobby() {
        Manager.startLobby();
    }

    @Override
    public void onMinigame() {
        Manager.startMinigame();
    }

    @Override
    public void onEnd(ArrayList<Player> players) {

    }
}
